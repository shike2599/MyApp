package project.wy.com.myappdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import project.wy.com.myappdemo.adapter.DeviceListAdapter;
import project.wy.com.myappdemo.bean.AlarmLogInfo;
import project.wy.com.myappdemo.bean.EquipMainOverdue;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.LogUtil;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.ToastUtil;

public class MeinAndHealthyActivity extends Activity {
    private String TAG = "MeinAndHealthyActivity";
    private ImageView back_img;
    private ListView device_listview;
    private DeviceListAdapter deviceListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mein_and_healthy);

       initView();
       initData();
    }
    private void initView(){
        back_img = findViewById(R.id.back_img);
        back_img.setVisibility(View.VISIBLE);
        device_listview = findViewById(R.id.mein_healthy_listview);
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MeinAndHealthyActivity.this.finish();
            }
        });
        deviceListAdapter = new DeviceListAdapter(this);

    }
    private void initData() {
       Intent intent = this.getIntent();
       int proj_id = intent.getIntExtra("Proj_id",-1);
        LogUtil.d(TAG,"---Proj_id----"+proj_id);
        Map<String,String> parms = new HashMap<>();
       parms.put("proj_id",String.valueOf(proj_id));
       String type = intent.getStringExtra("Type");
       String URL= "";
       if(type!=null&&type.equals("")){
           if(type.equals("WaitMainten")){
              URL = Constant.QUEST_OVERMAINT_BY_PROID;
           }else{
              URL = Constant.QUEST_HEASTA_BY_PROID;
           }
           DialogUtil.showDialogLoading(this,null);
           OkhttpUtils.postAsyn(URL, parms, new HttpCallback() {
               @Override
               public void onSuccess(String resultDesc) {
                   super.onSuccess(resultDesc);
                   DialogUtil.hideDialogLoading();
                   Gson gson = new Gson();
                   EquipMainOverdue equipMainOverdue = gson.fromJson(resultDesc, EquipMainOverdue.class);
                   if(equipMainOverdue!=null&&equipMainOverdue.getList()!= null
                           &&equipMainOverdue.getList().size()>0){
                       deviceListAdapter.setData(equipMainOverdue);
                       device_listview.setAdapter(deviceListAdapter);
                       deviceListAdapter.notifyDataSetChanged();
                   }
               }

               @Override
               public void onFailure(int code, String message) {
                   super.onFailure(code, message);
                   DialogUtil.hideDialogLoading();
               }
           });
       }else{
           ToastUtil.showText("未找到数据！！！");
       }
    }
}
