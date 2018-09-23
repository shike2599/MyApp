package project.wy.com.myappdemo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.base.BaseFragment;
import project.wy.com.myappdemo.bean.DeviceBean;
import project.wy.com.myappdemo.fragment.DeviceInfragment;
import project.wy.com.myappdemo.fragment.Maintenanfragment;
import project.wy.com.myappdemo.fragment.RunningInfoFragment;



public class DeviceInfoActivity extends FragmentActivity {

    private RadioGroup mRg_device;
    private List<BaseFragment> mBaseFragment;
    private TextView title_show;
    /**
     * 选中的Fragment的对应的位置
     */
    private int position;

    /**
     * 上次切换的Fragment
     */
    private Fragment mContent;
    private ImageView back_img;
    private DeviceBean.ListBean listBean;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);
        Intent beanInent = this.getIntent();
        listBean = (DeviceBean.ListBean) beanInent.getSerializableExtra("DeviceBean");

        //初始化View
        initView();
        //初始化Fragment
        initFragment();
        //设置RadioGroup的监听
        setListener();
    }

    private void setListener() {
        mRg_device.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //设置默认选中常用框架
        mRg_device.check(R.id.rb_deiveinfo);
    }

    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId){
                case R.id.rb_deiveinfo://device_info
                    position = 0;
                    title_show.setText("设备信息");
                    break;
                case R.id.rb_running://runing
                    position = 1;
                    title_show.setText("运行信息");
                    break;
                case R.id.rb_miantenan://维护
                    position = 2;
                    title_show.setText("维护信息");
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
                    ft.add(R.id.fl_device,to).commit();
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
        mBaseFragment.add(new DeviceInfragment());//
        mBaseFragment.add(new RunningInfoFragment());//
        mBaseFragment.add(new Maintenanfragment());//

        DeviceInfragment.setListBrean(listBean);
    }

    private void initView() {
//        setContentView(R.layout.activity_device_info);
        mRg_device = (RadioGroup) findViewById(R.id.rg_deivice);
        title_show = (TextView) findViewById(R.id.title_msg);
        back_img = (ImageView) findViewById(R.id.back_img);
        back_img.setVisibility(View.VISIBLE);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeviceInfoActivity.this.finish();
            }
        });
    }
}
