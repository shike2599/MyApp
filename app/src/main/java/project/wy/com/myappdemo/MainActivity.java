package project.wy.com.myappdemo;

import android.content.Intent;
import android.media.Image;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.znq.zbarcode.CaptureActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.wy.com.myappdemo.base.BaseFragment;
import project.wy.com.myappdemo.bean.EquipmentInfoBean;
import project.wy.com.myappdemo.fragment.DeviceListFragment;
import project.wy.com.myappdemo.fragment.UserFragment;
import project.wy.com.myappdemo.fragment.WarningFragment;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.LogUtil;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.ToastUtil;

public class MainActivity extends FragmentActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private RadioGroup mRg_main;
    private List<BaseFragment> mBaseFragment;
    /**
     * 选中的Fragment的对应的位置
     */
    private int position;
    private int QR_CODE =1;
    /**
     * 上次切换的Fragment
     */
    private Fragment mContent;
    private TextView title_show;

    private TextView qrCode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //初始化View
        initView();
        //初始化Fragment
        initFragment();
        //设置RadioGroup的监听
        setListener();
    }

    private void setListener() {
        mRg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //设置默认选中常用框架
        mRg_main.check(R.id.rb_deivelist);
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_deivelist://device_list
                    position = 0;
                    title_show.setText("设备信息");
                    break;
                case R.id.rb_warning://warning
                    position = 1;
                    title_show.setText("报警信息");
                    break;
                case R.id.rb_user_info://user
                    position = 2;
                    title_show.setText("我的");
                    break;
                default:
                    position = 0;
                    break;
            }

            //根据位置得到对应的Fragment
            BaseFragment to = getFragment();
            //替换
            switchFrament(mContent,to);

        }
    }


    /**
     *
     * @param from 刚显示的Fragment,马上就要被隐藏了
     * @param to 马上要切换到的Fragment，一会要显示
     */
    private void switchFrament(Fragment from,Fragment to) {
        if(from != to){
            mContent = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //才切换
            //判断有没有被添加
            if(!to.isAdded()){
                //to没有被添加
                //from隐藏
                if(from != null){
                    ft.hide(from);
                }
                //添加to
                if(to != null){
                    ft.add(R.id.fl_content,to).commit();
                }
            }else{
                //to已经被添加
                // from隐藏
                if(from != null){
                    ft.hide(from);
                }
                //显示to
                if(to != null){
                    ft.show(to).commit();
                }
            }
        }

    }

    /**
     * 根据位置得到对应的Fragment
     * @return
     */
    private BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragment.get(position);
        return fragment;
    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();
        mBaseFragment.add(new DeviceListFragment());//
        mBaseFragment.add(new WarningFragment());//
        mBaseFragment.add(new UserFragment());//
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mRg_main = (RadioGroup) findViewById(R.id.rg_main);
        title_show = (TextView) findViewById(R.id.title_msg);

        qrCode = (TextView) findViewById(R.id.qrcode_textView);
        qrCode.setVisibility(View.VISIBLE);
        //点击扫一扫
        qrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CaptureActivity.class);
                MainActivity.this.startActivityForResult(intent, QR_CODE);

            }
        });
    }

    //记录用户首次点击返回键的时间
    private long firstTime=0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK && event.getAction()==KeyEvent.ACTION_DOWN){
            if (System.currentTimeMillis()-firstTime>2000){
                Toast.makeText(MainActivity.this,"再按一次退出程序！",Toast.LENGTH_SHORT).show();
                firstTime=System.currentTimeMillis();
            }else{
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == QR_CODE) {
            if(data!=null){
                Bundle b = data.getExtras();
                if(b!=null){
                    String result = b.getString(CaptureActivity.EXTRA_STRING);
                    DialogUtil.showDialogLoading(MainActivity.this,null);
//                    Toast.makeText(this, result + "", Toast.LENGTH_SHORT).show();
                    Map<String,String> prams = new HashMap<>();
                    prams.put("equip_id", result.trim());
                    OkhttpUtils.postAsyn(Constant.QUEST_DEVICE_INFO, prams, new HttpCallback() {
                        @Override
                        public void onSuccess(String resultDesc) {
                            super.onSuccess(resultDesc);
                            DialogUtil.hideDialogLoading();
                            Gson gson = new Gson();
                            EquipmentInfoBean equInfoBean = gson.fromJson(resultDesc, EquipmentInfoBean.class);
                            Log.i(TAG, "xwz::::" + resultDesc);
                            if(equInfoBean.getEquipment() != null){
                                Intent intent = new Intent();
                                intent.setClass(MainActivity.this, DeviceInfoActivity.class);
                                intent.putExtra("DeviceInfoBean", equInfoBean.getEquipment());
                                MainActivity.this.startActivity(intent);
                            }else{
                                ToastUtil.showText("未查找到设备!！");
                            }

                        }

                        @Override
                        public void onFailure(int code, String message) {
                            super.onFailure(code, message);
                            DialogUtil.hideDialogLoading();
                            ToastUtil.showText("查找失败，服务器异常！！！");
                        }
                    });

                }
            }

        }
    }

}
