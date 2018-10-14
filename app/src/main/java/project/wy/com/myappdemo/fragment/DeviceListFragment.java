package project.wy.com.myappdemo.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.widget.SearchView;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.videogo.constant.IntentConsts;
import com.videogo.errorlayer.ErrorInfo;
import com.videogo.exception.BaseException;
import com.videogo.exception.ErrorCode;
import com.videogo.openapi.bean.EZCameraInfo;
import com.videogo.openapi.bean.EZDeviceInfo;
import com.videogo.util.ConnectionDetector;
import com.videogo.util.LogUtil;
import com.videogo.util.Utils;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.wy.com.myappdemo.DeviceInfoActivity;
import project.wy.com.myappdemo.MainActivity;
import project.wy.com.myappdemo.MyApp;
import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.adapter.MyExpListViewAdapter;
import project.wy.com.myappdemo.base.BaseFragment;
import project.wy.com.myappdemo.bean.DeviceInfoBean;
import project.wy.com.myappdemo.bean.EquipmentBean;
import project.wy.com.myappdemo.bean.EquipmentInfoBean;
import project.wy.com.myappdemo.bean.LocalDeviceInfoBean;
import project.wy.com.myappdemo.bean.RoomBean;
import project.wy.com.myappdemo.camera.realplay.EZRealPlayActivity;
import project.wy.com.myappdemo.camera.realplay.RealPlaySquareInfo;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.EZUtils;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.ShareUtils;
import project.wy.com.myappdemo.untils.ToastUtil;
import project.wy.com.myappdemo.widget.window.MenuPopupWindow;

public class DeviceListFragment extends BaseFragment {

    private static final String TAG = DeviceListFragment.class.getSimpleName();
    private ExpandableListView mExpListView;
    private MyExpListViewAdapter myExpListViewAdapter;
    private EquipmentInfoBean equInfoBean;
    private SearchView search_edit;
    private  List<EquipmentBean> equipments;
    private  List<RoomBean> rooms;
    private LocalDeviceInfoBean mLocalDeviceInfoBean;
    private List<List<EquipmentBean>> equipmentList = new ArrayList<>();
    List<EZDeviceInfo> mDeviceList = null;
    private WarningFragment warningFragment;
    private int proj_id;
    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.deivelist_fargment_layout, null);

        mExpListView = (ExpandableListView) view.findViewById(R.id.device_list_ExpandableListView);
        search_edit = (SearchView) view.findViewById(R.id.search_device_view);
        search_edit.setSubmitButtonEnabled(true);
        search_edit.setQueryHint("请输入设备名称或型号查找设备");
        //s设置搜素框监听时间
        search_edit.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                String searchKey = query.trim();
                DialogUtil.showDialogLoading(mContext, "");
                //准备数据
                Map<String, String> params = new HashMap<>();
                params.put("proj_id", String.valueOf(proj_id));
                params.put("searchKey", searchKey);
                Log.i(TAG,"proj_id:"+proj_id+",searchKey:"+searchKey);
                doPost(params, "info", Constant.QUEST_DEVCE_BY_NAME_OR_EID);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        mExpListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, final int groupPosition, long id) {
                ImageView carmer = (ImageView) v.findViewById(R.id.iv_carmer);
                carmer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d(TAG, "-----carmer-----" + groupPosition);
                        // final EZDeviceInfo deviceInfo = mAdapter.getItem(groupPosition);
                        if (mDeviceList != null && mDeviceList.size() > 0) {
                            int index = 0;
                            for(int i = 0; i < mDeviceList.size(); i++){
                                if(mDeviceList.get(i).getDeviceName().contains("C6H")){
                                    index = i;
                                    Log.i(TAG,"name:"+mDeviceList.get(i).getDeviceName()+",index:"+i);
                                }
                            }

                            final EZDeviceInfo deviceInfo = mDeviceList.get(index);
                            if (deviceInfo.getCameraNum() <= 0 || deviceInfo.getCameraInfoList() == null || deviceInfo.getCameraInfoList().size() <= 0) {
                                Log.d(TAG, "cameralist is null or cameralist size is 0");
                                return;
                            }
                            if (deviceInfo.getCameraNum() == 1 && deviceInfo.getCameraInfoList() != null && deviceInfo.getCameraInfoList().size() == 1) {
                                Log.d(TAG, "cameralist have one camera");
                                final EZCameraInfo cameraInfo = EZUtils.getCameraInfoFromDevice(deviceInfo, 0);
                                if (cameraInfo == null) {
                                    return;
                                }
                                Intent intent = new Intent(mContext, EZRealPlayActivity.class);
                                intent.putExtra(IntentConsts.EXTRA_CAMERA_INFO, cameraInfo);
                                intent.putExtra(IntentConsts.EXTRA_DEVICE_INFO, deviceInfo);
                                mContext.startActivity(intent);
                                return;
                            }
                        }
                    }
                });
                return false;
            }
        });

        mExpListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Log.d(TAG, "----Child----" + childPosition);
                Intent intent = new Intent();
                intent.setClass(mContext, DeviceInfoActivity.class);
                intent.putExtra("DeviceInfoBean", equipmentList.get(groupPosition).get(childPosition));
                mContext.startActivity(intent);
                return false;
            }
        });
        return view;
    }


    @Override
    protected void initData() {
        super.initData();
        myExpListViewAdapter = new MyExpListViewAdapter(mContext);
        mExpListView.setAdapter(myExpListViewAdapter);
        proj_id = (Integer) ShareUtils.getSharedPreference(mContext, "proj_id", -1);
        if (proj_id != -1) {
            DialogUtil.showDialogLoading(mContext, "");
            Map<String, String> prams = new HashMap<>();
            prams.put("proj_id", String.valueOf(proj_id));
            doPost(prams, "list", Constant.QUEST_DEVCE_BY_PROJ);
        }
        new GetCamersInfoListTask().execute();
    }

    //开始查找
    private void doPost(Map<String, String> params, final String type, String Url) {
        DialogUtil.showDialogLoading(mContext, "正在查找，请稍等...");
        OkhttpUtils.postAsyn(Url, params, new HttpCallback() {
            @Override
            public void onSuccess(String resultDesc) {
                super.onSuccess(resultDesc);
                //LogUtil.d(TAG,resultDesc);
                DialogUtil.hideDialogLoading();
                if (type.equals("list")) {
                    Gson gson = new Gson();
                    mLocalDeviceInfoBean = gson.fromJson(resultDesc, LocalDeviceInfoBean.class);
                    rooms = mLocalDeviceInfoBean.getRoom();
                    equipments = mLocalDeviceInfoBean.getEquipment();

                    warningFragment.setLocation(equipmentList,rooms);

                    int rmlen = 0;
                    int devlen = 0;
                    if(rooms!=null&&rooms.size()>0){
                        rmlen =  rooms.size();
                    }else{
                        ToastUtil.showText("暂无设备！");
                        return;
                    }
                    if(equipments!=null&&equipments.size()>0){
                        devlen = equipments.size();
                    }else {
                        ToastUtil.showText("暂无设备！");
                        return;
                    }

                    for(int i = 0; i < rmlen; i++){
                        List<EquipmentBean> equipList = new ArrayList<>();
                        for (int j = 0; j < devlen; j++) {
                            RoomBean room = rooms.get(i);
                            EquipmentBean equipmentBean = equipments.get(j);
                            if (room.getEquip_room_id() == equipmentBean.getEquip_room().getEquip_room_id()) {
                                equipList.add(equipmentBean);
                            }
                        }
                        equipmentList.add(i, equipList);
                    }

                    //设置适配器
                    myExpListViewAdapter.setData(mLocalDeviceInfoBean.getRoom(), equipmentList);
                    mExpListView.setAdapter(myExpListViewAdapter);
                    myExpListViewAdapter.notifyDataSetChanged();
                } else if (type.equals("info")) {
                    Gson gson = new Gson();
                    equInfoBean = gson.fromJson(resultDesc, EquipmentInfoBean.class);
                    Log.i(TAG, "xwz::::" + resultDesc);
                    if (equInfoBean.getEquipment() != null) {
                        Intent intent = new Intent();
                        intent.setClass(mContext, DeviceInfoActivity.class);
                        intent.putExtra("DeviceInfoBean", equInfoBean.getEquipment());
                        mContext.startActivity(intent);
                    } else {
                        ToastUtil.showText("未查找到设备！！");
                    }

                }

            }

            @Override
            public void onFailure(int code, String message) {
                super.onFailure(code, message);
                DialogUtil.hideDialogLoading();
                if (type.equals("list")) {
                    ToastUtil.showText("服务器异常！！！");
                } else {
                    ToastUtil.showText("查找失败请输入正确的设备ID");
                }
            }
        });
    }

    public void setDeviceBean(LocalDeviceInfoBean deviceBean) {
        this.mLocalDeviceInfoBean = deviceBean;
        rooms = mLocalDeviceInfoBean.getRoom();
        equipments = mLocalDeviceInfoBean.getEquipment();

        int rmlen = rooms.size();
        int devlen = equipments.size();
        for (int i = 0; i < rmlen; i++) {
            List<EquipmentBean> equipList = new ArrayList<>();
            for (int j = 0; j < devlen; j++) {
                RoomBean room = rooms.get(i);
                EquipmentBean equipmentBean = equipments.get(j);
                if (room.getEquip_room_id() == equipmentBean.getEquip_room().getEquip_room_id()) {
                    equipList.add(equipmentBean);
                }
            }
            equipmentList.add(i, equipList);
            warningFragment.setLocation(equipmentList,rooms);
        }

        //设置适配器
        myExpListViewAdapter.setData(mLocalDeviceInfoBean.getRoom(), equipmentList);
        myExpListViewAdapter.notifyDataSetChanged();
    }

    public void setWaringFragment(WarningFragment waringFragment) {
        this.warningFragment = waringFragment;
    }


    /**
     * 获取事件消息任务
     */
    private class GetCamersInfoListTask extends AsyncTask<Void, Void, List<EZDeviceInfo>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<EZDeviceInfo> doInBackground(Void... params) {
            try {
                List<EZDeviceInfo> result = null;
                result = MyApp.getOpenSDK().getDeviceList(0, 20);
                Log.i(TAG, "result:" + result);
                return result;
            } catch (BaseException e) {
                ErrorInfo errorInfo = (ErrorInfo) e.getObject();
                Log.i(TAG,"err message:"+e.getMessage()+",code:"+errorInfo.errorCode);
                return null;
            }
        }
        @Override
        protected void onPostExecute(List<EZDeviceInfo> result) {
            super.onPostExecute(result);
            if (result != null) {
                mDeviceList = result;
            }
        }
    }
}
