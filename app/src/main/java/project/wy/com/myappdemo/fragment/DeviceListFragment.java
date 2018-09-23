package project.wy.com.myappdemo.fragment;

import android.view.View;
import android.widget.ListView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.adapter.DeviceListAdapter;
import project.wy.com.myappdemo.base.BaseFragment;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.http.ResultDesc;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.LogUtil;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.ToastUtil;

public class DeviceListFragment extends BaseFragment {
    private static final String TAG = DeviceListFragment.class.getSimpleName();
    private ListView mListView;


    private DeviceListAdapter adapter;
    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.deivelist_fargment_layout,null);
        mListView = (ListView) view.findViewById(R.id.listview);
//        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//            }
//        });
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        DialogUtil.showDialogLoading(mContext, "");

        //准备数据
        Map<String,String> params = new HashMap<>();
        params.put("page",String.valueOf(1));
        params.put("searchKey","");
        OkhttpUtils.postAsyn(Constant.QUEST_ALL_DEVICE, params, new HttpCallback() {
            @Override
            public void onSuccess(String resultDesc) {
                super.onSuccess(resultDesc);
                DialogUtil.hideDialogLoading();
                LogUtil.d(TAG,""+resultDesc);
            }

            @Override
            public void onFailure(int code, String message) {
                super.onFailure(code, message);
            }
        });
        //设置适配器
//        adapter = new DeviceListAdapter(mContext,datas);
//        mListView.setAdapter(adapter);
    }
}
