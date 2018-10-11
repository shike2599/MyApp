package project.wy.com.myappdemo;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.google.gson.Gson;
import com.videogo.openapi.EZOpenSDK;
import com.znq.zbarcode.CaptureActivity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import project.wy.com.myappdemo.base.BaseFragment;
import project.wy.com.myappdemo.bean.CompanyInfoBean;
import project.wy.com.myappdemo.bean.EquipmentBean;
import project.wy.com.myappdemo.bean.EquipmentInfoBean;
import project.wy.com.myappdemo.bean.LocalDeviceInfoBean;
import project.wy.com.myappdemo.bean.ProjectInfoBean;
import project.wy.com.myappdemo.bean.RoomBean;
import project.wy.com.myappdemo.fragment.DeviceListFragment;
import project.wy.com.myappdemo.fragment.UserFragment;
import project.wy.com.myappdemo.fragment.WarningFragment;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.LogUtil;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.ShareUtils;
import project.wy.com.myappdemo.untils.ToastUtil;
import project.wy.com.myappdemo.widget.window.MenuPopupWindow;
import project.wy.com.myappdemo.widget.window.NormalExpandableListAdapter;

public class MainActivity extends FragmentActivity{
    private static final String TAG = MainActivity.class.getSimpleName();
    private RadioGroup mRg_main;
    private List<BaseFragment> mBaseFragment;
    private ImageView menu_id;

    /**
     * 选中的Fragment的对应的位置
     */
    private int position;
    private int QR_CODE = 1;

    private final static int SEACH = 1;
    private final static int END = 2;
    /**
     * 上次切换的Fragment
     */
    private Fragment mContent;
    private TextView title_show;
    private TextView qrCode; //扫一扫
    private CompanyInfoBean mCompanyInfoBean;
    private List<ProjectInfoBean> mProjectInfoBeanList = new ArrayList<>();

    private DeviceListFragment deviceListFragment;
    private WarningFragment warningFragment ;
    private DrawerLayout mDrawerLayout;

    private ExpandableListView compExpList;
    private NormalExpandableListAdapter adapter;


    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SEACH:
                    findProjectInfo();
                    break;
                case END:
                    adapter.setData(mCompanyInfoBean,mProjectInfoBeanList);
                    adapter.notifyDataSetChanged();
                    int proj_id = (Integer) ShareUtils.getSharedPreference(
                            MainActivity.this,"proj_id",-1);
                    if(proj_id == -1){
                        mDrawerLayout.openDrawer(Gravity.LEFT);
                        ToastUtil.showText("请先选择要查看的项目！！！");
                    }
                    break;
            }
        }
    };

    private void findProjectInfo() {
        for (int i = 0; i < mCompanyInfoBean.getResult().size(); i++) {
            String comp_id_seach = mCompanyInfoBean.getResult().get(i).getComp_id() + "";
            Map<String, String> map = new HashMap<>();
            map.put("company_id", comp_id_seach);
            doPost(Constant.QUEST_PRO_INFO, map, "pro");
        }
        mHandler.sendEmptyMessage(END);
    }

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

        initPopupData();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void initPopupData() {
        doPost(Constant.QUEST_COMP_INFO, null, "comp");
    }

    private void doPost(String url, final Map<String, String> parms, final String type) {
        OkhttpUtils.postAsyn(url, parms, new HttpCallback() {
            @Override
            public void onSuccess(String resultDesc) {
                super.onSuccess(resultDesc);
                if (type.equals("comp")) {
                    Gson gson = new Gson();
                    mCompanyInfoBean = gson.fromJson(resultDesc, CompanyInfoBean.class);
                    mHandler.sendEmptyMessageAtTime(SEACH, 100);
                } else {
                    Gson gson = new Gson();
                    ProjectInfoBean projectInfoBean = gson.fromJson(resultDesc, ProjectInfoBean.class);
                    mProjectInfoBeanList.add(projectInfoBean);
                }
            }

            @Override
            public void onFailure(int code, String message) {
                super.onFailure(code, message);
                ToastUtil.showText("服务器异常！！！");
            }
        });
    }

    private void setListener() {
        mRg_main.setOnCheckedChangeListener(new MyOnCheckedChangeListener());
        //设置默认选中常用框架
        mRg_main.check(R.id.rb_deivelist);
    }


    class MyOnCheckedChangeListener implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.rb_deivelist://device_list
                    position = 0;
                    menu_id.setVisibility(View.VISIBLE);
                    qrCode.setVisibility(View.VISIBLE);
                    title_show.setText(getResources().getText(R.string.device_info));
                    break;
                case R.id.rb_warning://warning
                    position = 1;
                    menu_id.setVisibility(View.GONE);
                    qrCode.setVisibility(View.VISIBLE);
                    title_show.setText(getResources().getText(R.string.warning_info));
                    break;
                case R.id.rb_user_info://user
                    position = 2;
                    menu_id.setVisibility(View.GONE);
                    title_show.setText(getResources().getText(R.string.user_set));
                    qrCode.setVisibility(View.GONE);
                    break;
                default:
                    position = 0;
                    break;
            }

            //根据位置得到对应的Fragment
            BaseFragment to = getFragment();
            //替换
            switchFrament(mContent, to);

        }
    }


    /**
     * @param from 刚显示的Fragment,马上就要被隐藏了
     * @param to   马上要切换到的Fragment，一会要显示
     */
    private void switchFrament(Fragment from, Fragment to) {
        if (from != to) {
            mContent = to;
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            //才切换
            //判断有没有被添加
            if (!to.isAdded()) {
                //to没有被添加
                //from隐藏
                if (from != null) {
                    ft.hide(from);
                }
                //添加to
                if (to != null) {
                    ft.add(R.id.fl_content, to).commit();
                }
            } else {
                //to已经被添加
                // from隐藏
                if (from != null) {
                    ft.hide(from);
                }
                //显示to
                if (to != null) {
                    ft.show(to).commit();
                }
            }
        }

    }

    /**
     * 根据位置得到对应的Fragment
     *
     * @return
     */
    private BaseFragment getFragment() {
        BaseFragment fragment = mBaseFragment.get(position);
        return fragment;
    }

    private void initFragment() {
        mBaseFragment = new ArrayList<>();

        deviceListFragment = new DeviceListFragment();


        mBaseFragment.add(deviceListFragment);//

        warningFragment =  new WarningFragment();
        mBaseFragment.add(warningFragment);//

        mBaseFragment.add(new UserFragment());//

        deviceListFragment.setWaringFragment(warningFragment);
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        mRg_main = (RadioGroup) findViewById(R.id.rg_main);
        title_show = (TextView) findViewById(R.id.title_msg);
        qrCode = (TextView) findViewById(R.id.qrcode_textView);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.DrawerLayout_comp);

        compExpList = (ExpandableListView)findViewById(R.id.pop_list);
        adapter = new NormalExpandableListAdapter();
        compExpList.setAdapter(adapter);

        //  设置分组项的点击监听事件
        compExpList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.d(TAG, "onGroupClick: groupPosition:" + groupPosition + ", id:" + id);
                // 请务必返回 false，否则分组不会展开
                return false;
            }
        });

        //  设置子选项点击监听事件
        compExpList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Log.i(TAG,"onChildClick: groupPosition:" + groupPosition + ", childPosition:" + childPosition);
                if(mProjectInfoBeanList.get(groupPosition).getResult().size()>0&&
                        mProjectInfoBeanList.get(groupPosition).getResult().get(childPosition)!=null){

                    int pro_id = mProjectInfoBeanList.get(groupPosition).getResult().get(childPosition).getProj_id();
                    //保存proj_id,第一次获取
                    ShareUtils.putSharedPreference(MainActivity.this,"proj_id",pro_id);
                    DialogUtil.showDialogLoading(MainActivity.this,"正在查询...");
                    Map<String,String> prams = new HashMap<>();
                    prams.put("proj_id",String.valueOf(pro_id));
                    OkhttpUtils.postAsyn(Constant.QUEST_DEVCE_BY_PROJ, prams, new HttpCallback() {
                        @Override
                        public void onSuccess(String resultDesc) {
                            super.onSuccess(resultDesc);
                            LogUtil.d(TAG,resultDesc);
                            DialogUtil.hideDialogLoading();
                            Gson gson = new Gson();
                            LocalDeviceInfoBean localDeviceInfoBean = gson.fromJson(resultDesc, LocalDeviceInfoBean.class);
                            if(localDeviceInfoBean!=null&&localDeviceInfoBean.getEquipment()!=null
                                    &&localDeviceInfoBean.getEquipment().size()>0){
                                deviceListFragment.setDeviceBean(localDeviceInfoBean);
                                mDrawerLayout.closeDrawer(Gravity.LEFT);
                            }else{
                                ToastUtil.showText("未找到数据");
                            }
                        }

                        @Override
                        public void onFailure(int code, String message) {
                            super.onFailure(code, message);
                            DialogUtil.hideDialogLoading();
                            ToastUtil.showText("服务器异常！！！");
                        }
                    });

                }else{
                  ToastUtil.showText("该项目下无设备！！！");
                }

                return true;
            }
        });

        qrCode.setVisibility(View.VISIBLE);
        //点击扫一扫
        qrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
                MainActivity.this.startActivityForResult(intent, QR_CODE);

            }
        });

        menu_id = (ImageView) findViewById(R.id.menu_img);
        menu_id.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);
            }
        });

    }

    //记录用户首次点击返回键的时间
    private long firstTime = 0;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if (System.currentTimeMillis() - firstTime > 2000) {
                Toast.makeText(MainActivity.this, "再按一次退出程序！", Toast.LENGTH_SHORT).show();
                firstTime = System.currentTimeMillis();
            } else {
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
            if (data != null) {
                Bundle b = data.getExtras();
                if (b != null) {
                    String result = b.getString(CaptureActivity.EXTRA_STRING);
                    DialogUtil.showDialogLoading(MainActivity.this, null);
                    Map<String, String> prams = new HashMap<>();
                    prams.put("equip_id", result.trim());
                    OkhttpUtils.postAsyn(Constant.QUEST_DEVICE_INFO, prams, new HttpCallback() {
                        @Override
                        public void onSuccess(String resultDesc) {
                            super.onSuccess(resultDesc);
                            DialogUtil.hideDialogLoading();
                            Gson gson = new Gson();
                            EquipmentInfoBean equInfoBean = gson.fromJson(resultDesc, EquipmentInfoBean.class);
                            if (equInfoBean.getEquipment() != null) {
                                if(position == 0) {
                                    Intent intent = new Intent();
                                    intent.setClass(MainActivity.this, DeviceInfoActivity.class);
                                    intent.putExtra("DeviceInfoBean", equInfoBean.getEquipment());
                                    MainActivity.this.startActivity(intent);
                                }else if(position == 1){
                                    WarningFragment warningFragment =  (WarningFragment)getFragment();
                                    warningFragment.setData(equInfoBean.getEquipment());
                                }

                            } else {
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
