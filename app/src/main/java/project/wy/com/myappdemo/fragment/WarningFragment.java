package project.wy.com.myappdemo.fragment;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.HashMap;
import java.util.Map;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.base.BaseFragment;
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
    private ArrayAdapter<Integer> adapter;
    private int deivice_id;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.warining_fragment_activity,null);
        commit_btn = view.findViewById(R.id.commit_btn);
        input_num = view.findViewById(R.id.spinner_select_id);
        input_info = view.findViewById(R.id.device_warn_info);
        input_remark = view.findViewById(R.id.device_warn_rmaker);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        adapter = new ArrayAdapter<>(mContext,android.R.layout.simple_spinner_item,DeviceListFragment.getDeviceBeanList());
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        input_num.setAdapter(adapter);
        input_num.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                deivice_id = adapter.getItem(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final String device_wainfo = input_info.getText().toString();
        final String device_remaker = input_remark.getText().toString();
        commit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(device_wainfo!=null){
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
                        public void onFailure(int code, String message) {
                            super.onFailure(code, message);
                            DialogUtil.hideDialogLoading();
                            ToastUtil.showText("服务器异常，上传失败！");
                        }
                    });
                }else{
                    ToastUtil.showText("设备ID或报警信息不能为空！");
                }
            }
        });

    }
}
