package project.wy.com.myappdemo.fragment;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import project.wy.com.myappdemo.DeviceInfoActivity;
import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.adapter.DeviceListAdapter;
import project.wy.com.myappdemo.base.BaseFragment;
import project.wy.com.myappdemo.bean.DeviceInfoBean;
import project.wy.com.myappdemo.bean.EquipmentBean;
import project.wy.com.myappdemo.bean.EquipmentInfoBean;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.ToastUtil;

public class DeviceListFragment extends BaseFragment {
    private static final String TAG = DeviceListFragment.class.getSimpleName();
    private ListView mListView;
    private EditText search_edit;
    private Button search_btn;
    private DeviceListAdapter adapter;
    private static DeviceInfoBean deviceBean;
    private EquipmentInfoBean equInfoBean;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.deivelist_fargment_layout, null);
        mListView = (ListView) view.findViewById(R.id.listview);
        search_edit = (EditText) view.findViewById(R.id.search_eidt);
        search_btn = (Button) view.findViewById(R.id.start_search);
        search_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String seach_key = search_edit.getText().toString();
                if (seach_key != null & !seach_key.equals("")) {
                    Map<String, String> params = new HashMap<>();
                    params.put("equip_id", seach_key);
                    doPost(params, "info", Constant.QUEST_DEVICE_INFO);
                } else {
                    ToastUtil.showText("请输入设备ID！！！");
                }
            }
        });
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.setClass(mContext, DeviceInfoActivity.class);
                intent.putExtra("DeviceInfoBean", deviceBean.getList().get(position));
                mContext.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        adapter = new DeviceListAdapter(mContext);
//        mListView.setAdapter(adapter);
        DialogUtil.showDialogLoading(mContext, "");
        //准备数据
        Map<String, String> params = new HashMap<>();
        params.put("page", String.valueOf(1));
        params.put("searchKey", "");
        doPost(params, "list", Constant.QUEST_ALL_DEVICE);

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
                    deviceBean = gson.fromJson(resultDesc, DeviceInfoBean.class);
                    //设置适配器
                    adapter.setData(deviceBean);
                    mListView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else if (type.equals("info")) {
                    Gson gson = new Gson();
                    equInfoBean = gson.fromJson(resultDesc, EquipmentInfoBean.class);
                    Log.i(TAG, "xwz::::" + resultDesc);
                    Intent intent = new Intent();
                    intent.setClass(mContext, DeviceInfoActivity.class);
                    intent.putExtra("DeviceInfoBean", equInfoBean.getEquipment());
                    mContext.startActivity(intent);
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
        if (deviceBean != null) {
            for (EquipmentBean equipmentBean : deviceBean.getList()) {
                id_list.add(equipmentBean.getEquip_id());
            }
        }
        return id_list;
    }
}
