package project.wy.com.myappdemo.fragment;

import android.content.Intent;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.videogo.constant.IntentConsts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import project.wy.com.myappdemo.DeviceInfoActivity;
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
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.ToastUtil;
import project.wy.com.myappdemo.widget.window.MenuPopupWindow;

public class DeviceListFragment extends BaseFragment{

    private static final String TAG = DeviceListFragment.class.getSimpleName();
    private ExpandableListView mExpListView;
    private MyExpListViewAdapter myExpListViewAdapter;
    private EquipmentInfoBean equInfoBean;
    private SearchView search_edit;
    private static List<EquipmentBean> equipments;
    private List<RoomBean> rooms;
    private LocalDeviceInfoBean mLocalDeviceInfoBean;
    private List<List<EquipmentBean>> equipmentList = new ArrayList<>();

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.deivelist_fargment_layout, null);

        mExpListView = (ExpandableListView)view.findViewById(R.id.device_list_ExpandableListView);
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
                params.put("equip_id", searchKey);
                doPost(params,"info",Constant.QUEST_DEVICE_INFO);
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
                        Log.d(TAG,"-----carmer-----"+groupPosition);
                        Intent intent = new Intent(mContext, EZRealPlayActivity.class);
//                        intent.putExtra(IntentConsts.EXTRA_CAMERA_INFO, cameraInfo);
//                        intent.putExtra(IntentConsts.EXTRA_DEVICE_INFO, deviceInfo);
                        mContext.startActivity(intent);
                    }
                });
                return false;
            }
        });

        mExpListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Log.d(TAG,"----Child----"+childPosition);
                Intent intent = new Intent();
                intent.setClass(mContext, DeviceInfoActivity.class);
                intent.putExtra("DeviceInfoBean",equipmentList.get(groupPosition).get(childPosition));
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
//        DialogUtil.showDialogLoading(mContext, "");
//        准备数据
//        Map<String, String> params = new HashMap<>();
//        params.put("page", String.valueOf(1));
//        params.put("searchKey", "");
//        doPost(params, "list", Constant.QUEST_ALL_DEVICE);

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
//                    Gson gson = new Gson();
//                    mLocalDeviceInfoBean = gson.fromJson(resultDesc, LocalDeviceInfoBean.class);
//                    rooms = mLocalDeviceInfoBean.getRoom();
//                    equipments = mLocalDeviceInfoBean.getEquipment();
//                    int rmlen =  rooms.size();
//                    int devlen = equipments.size();
//                    for(int i = 0; i < rmlen; i++){
//                        List<EquipmentBean> equipList = new ArrayList<>();
//                        for(int j = 0; j < devlen; j++){
//                            RoomBean  room = rooms.get(i);
//                            EquipmentBean equipmentBean = equipments.get(j);
//                            if(room.getEquip_room_id() == equipmentBean.getEquip_room().getEquip_room_id()){
//                                equipList.add(equipmentBean);
//                            }
//                        }
//                        equipmentList.add(i,equipList);
//                    }
//
//                    //设置适配器
//                    myExpListViewAdapter.setData(mLocalDeviceInfoBean.getRoom(),equipmentList);
//                    mExpListView.setAdapter(myExpListViewAdapter);
//                    myExpListViewAdapter.notifyDataSetChanged();
                } else if (type.equals("info")) {
                    Gson gson = new Gson();
                    equInfoBean = gson.fromJson(resultDesc, EquipmentInfoBean.class);
                    Log.i(TAG, "xwz::::" + resultDesc);
                    if(equInfoBean.getEquipment() != null){
                        Intent intent = new Intent();
                        intent.setClass(mContext, DeviceInfoActivity.class);
                        intent.putExtra("DeviceInfoBean", equInfoBean.getEquipment());
                        mContext.startActivity(intent);
                    }else{
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

    public static List<Integer> getDeviceBeanList() {
        List<Integer> id_list = new ArrayList<>();
        if (equipments != null) {
            for (EquipmentBean equipmentBean : equipments) {
                id_list.add(equipmentBean.getEquip_id());
            }
        }
        return id_list;
    }

    public void setDeviceBean(LocalDeviceInfoBean deviceBean) {
        this.mLocalDeviceInfoBean = deviceBean;
        rooms = mLocalDeviceInfoBean.getRoom();
        equipments = mLocalDeviceInfoBean.getEquipment();
        int rmlen =  rooms.size();
        int devlen = equipments.size();
        for(int i = 0; i < rmlen; i++){
            List<EquipmentBean> equipList = new ArrayList<>();
            for(int j = 0; j < devlen; j++){
                RoomBean  room = rooms.get(i);
                EquipmentBean equipmentBean = equipments.get(j);
                if(room.getEquip_room_id() == equipmentBean.getEquip_room().getEquip_room_id()){
                    equipList.add(equipmentBean);
                }
            }
            equipmentList.add(i,equipList);
        }

//        //设置适配器

        myExpListViewAdapter.setData(mLocalDeviceInfoBean.getRoom(),equipmentList);
        myExpListViewAdapter.notifyDataSetChanged();
    }
}
