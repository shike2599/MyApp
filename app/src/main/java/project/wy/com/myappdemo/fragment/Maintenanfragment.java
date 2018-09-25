package project.wy.com.myappdemo.fragment;

import android.view.View;

import android.widget.ExpandableListView;
import android.widget.ListView;

import com.google.gson.Gson;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.adapter.MaintenListViewAdapter;
import project.wy.com.myappdemo.adapter.MyExpListViewAdapter;
import project.wy.com.myappdemo.base.BaseFragment;
import project.wy.com.myappdemo.bean.MaintenanceInfoBean;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.LogUtil;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.ToastUtil;


/**
 * 维保信息
 */
public class Maintenanfragment extends BaseFragment {
    private static final String TAG = Maintenanfragment.class.getSimpleName();
//    private ExpandableListView mExpListView;
//    private MyExpListViewAdapter myExpListViewAdapter;

    private MaintenanceInfoBean maintenanceInfoBean;
    private static int mEp_id;


    private ListView  mainten_listView;
    private MaintenListViewAdapter maintenListViewAdapter;
    public static void setEpId(int ep_id){
         mEp_id = ep_id;
    }
    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.miantenan_info_layout,null);
//        myExpListViewAdapter = new MyExpListViewAdapter(mContext);
//        mExpListView = view.findViewById(R.id.mainten_exp_listview);
//        mExpListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//                boolean groupExpanded = parent.isGroupExpanded(groupPosition);
//                myExpListViewAdapter.setIndicatorState(groupPosition,groupExpanded);
//                return false;
//            }
//        });


        maintenListViewAdapter = new MaintenListViewAdapter(mContext);
        mainten_listView = view.findViewById(R.id.mainten_listView);



        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        DialogUtil.showDialogLoading(mContext,null);
        OkhttpUtils.postAsyn(Constant.QUEST_MAINTEN_INFO, null, new HttpCallback() {
            @Override
            public void onSuccess(String resultDesc) {
                super.onSuccess(resultDesc);
                DialogUtil.hideDialogLoading();
                LogUtil.d(TAG,resultDesc);
                Gson gson = new Gson();
                maintenanceInfoBean = gson.fromJson(resultDesc, MaintenanceInfoBean.class);
                if(maintenanceInfoBean!=null&&maintenanceInfoBean.getResult().size()>0){
//                    myExpListViewAdapter.setData(maintenanceInfoBean,mEp_id);
//                    mExpListView.setAdapter(myExpListViewAdapter);
//                    myExpListViewAdapter.notifyDataSetChanged();

                    maintenListViewAdapter.setDate(maintenanceInfoBean);
                    mainten_listView.setAdapter(maintenListViewAdapter);
                    maintenListViewAdapter.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(int code, String message) {
                super.onFailure(code, message);
                DialogUtil.hideDialogLoading();
                ToastUtil.showText("服务器异常，获取失败！");
            }
        });
    }
}
