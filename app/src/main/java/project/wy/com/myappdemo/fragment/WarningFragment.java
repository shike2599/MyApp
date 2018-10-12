package project.wy.com.myappdemo.fragment;


import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.base.BaseFragment;
import project.wy.com.myappdemo.bean.EquipmentBean;
import project.wy.com.myappdemo.bean.ProjectInfoBean;
import project.wy.com.myappdemo.bean.RoomBean;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.LogUtil;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.ToastUtil;

public class WarningFragment extends BaseFragment {
    private static final String TAG = WarningFragment.class.getSimpleName();
    private EditText input_info,input_remark;
    private Button commit_btn;
    private Spinner input_num;
    private Spinner location;
    private ArrayAdapter<String> adapter;
    private ArrayAdapter<String> adapter_loaction;
    private int deivice_id;

    private  List<String> roomName_list = new ArrayList<>() ;
    private  List<String> id_list  = new ArrayList<>();;
    private  List<List<EquipmentBean>> dataList;
    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.warining_fragment_activity,null);
        commit_btn = view.findViewById(R.id.commit_btn);
        input_num = view.findViewById(R.id.spinner_select_id);
        location = view.findViewById(R.id.spinner_select_location);

        input_info = view.findViewById(R.id.device_warn_info);
        input_remark = view.findViewById(R.id.device_warn_rmaker);
        return view;
    }

    public void setData(EquipmentBean equBean) {
        input_num.setSelection(input_num.getCount() - equBean.getEquip_id());
    }

    public  void setLocation(List<List<EquipmentBean>> dataList,List<RoomBean> roomBeans) {
        this.dataList = dataList;
        roomName_list.clear();
        for(RoomBean roomBean : roomBeans){
            roomName_list.add(roomBean.getEquip_room_name());
        }

        if(adapter_loaction!=null){
            adapter_loaction.notifyDataSetChanged();
        }
        if(location!=null){
            id_list.clear();
            List<EquipmentBean> list = dataList.get(0);
            for(EquipmentBean equipmentBeans : list){
                id_list.add(equipmentBeans.getEquip_name());
            }
            adapter = new ArrayAdapter<>(mContext,android.R.layout.simple_spinner_item,id_list);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
            input_num.setAdapter(adapter);
        }
    }

    @Override
    protected void initData() {
        super.initData();

        adapter_loaction = new ArrayAdapter<>(mContext,android.R.layout.simple_spinner_item,
                roomName_list);
        adapter_loaction.setDropDownViewResource(android.R.layout.simple_spinner_item);
        location.setAdapter(adapter_loaction);

        location.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                id_list.clear();
                final List<EquipmentBean> list = dataList.get(position);
                for(EquipmentBean equipmentBeans : list){
                    id_list.add(equipmentBeans.getEquip_name());
                }

                adapter = new ArrayAdapter<>(mContext,android.R.layout.simple_spinner_item,id_list);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
                input_num.setAdapter(adapter);
                input_num.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        deivice_id = list.get(position).getEquip_id();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        commit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String device_wainfo = input_info.getText().toString().trim();
                String device_remaker = input_remark.getText().toString().trim();

                if(device_wainfo!=null&&!device_wainfo.equals("")){
                    DialogUtil.showDialogLoading(mContext,"正在上传信息，请稍等...");
                    Map<String,String> parms = new HashMap<>();
                    parms.put("equip_id",deivice_id+"");
                    parms.put("alarmLog_info",device_wainfo);
                    parms.put("alarmLog_memo",device_remaker);
                    OkhttpUtils.postAsyn(Constant.ADD_WARNING_INFO, parms, new HttpCallback() {
                        @Override
                        public void onSuccess(String resultDesc) {
                            super.onSuccess(resultDesc);
                            DialogUtil.hideDialogLoading();
                            LogUtil.d(TAG,resultDesc);
                            ToastUtil.showText("上传成功！");
                        }

                        @Override
                        public void onFailure(int code, String message ) {
                            super.onFailure(code, message);
                            DialogUtil.hideDialogLoading();
                            ToastUtil.showText("服务器异常，上传失败！");
                        }
                    });
                }else{
                    ToastUtil.showText("报警信息不能为空！");
                }
            }
        });

    }

    @Override
    public void onResume() {
        super.onResume();
    }

}
