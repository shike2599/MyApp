package project.wy.com.myappdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

import project.wy.com.myappdemo.adapter.AlertInfoAdapter;
import project.wy.com.myappdemo.bean.AlarmLogInfo;
import project.wy.com.myappdemo.bean.EquipmentInfoBean;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.LogUtil;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.ToastUtil;

public class AlertInfoActivity extends Activity {
    private String TAG = "AlertInfoActivity";
    private TextView title_text;
    private ImageView back_img;
    private ListView alert_listview;
    private AlertInfoAdapter alertInfoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_info);
        initView();
        initDate();
    }

    private void initDate() {
        int proj_id = this.getIntent().getIntExtra("Proj_id",-1);
        LogUtil.d(TAG,"---Proj_id----"+proj_id);
        if(proj_id!=-1){
            DialogUtil.showDialogLoading(this,null);
            Map<String,String> parms = new HashMap<>();
            parms.put("proj_id",String.valueOf(proj_id));
            OkhttpUtils.postAsyn(Constant.QUEST_AlARM_BY_PROID, parms, new HttpCallback() {
                @Override
                public void onSuccess(String resultDesc) {
                    super.onSuccess(resultDesc);
                    Log.d(TAG,resultDesc);
                    DialogUtil.hideDialogLoading();
                    Gson gson = new Gson();
                    AlarmLogInfo alarmLogInfo = gson.fromJson(resultDesc, AlarmLogInfo.class);
                    if(alarmLogInfo!=null&&alarmLogInfo.getList()!= null&&alarmLogInfo.getList().size()>0){
                        alertInfoAdapter.setDate(alarmLogInfo);
                        alert_listview.setAdapter(alertInfoAdapter);
                        alertInfoAdapter.notifyDataSetChanged();
                    }
                }

                @Override
                public void onFailure(int code, String message) {
                    super.onFailure(code, message);
                    DialogUtil.hideDialogLoading();
                    ToastUtil.showText("服务器异常！！！");
                }
            });
        }
    }

    private void initView() {
        title_text = findViewById(R.id.title_msg);
        back_img = findViewById(R.id.back_img);
        alert_listview = findViewById(R.id.alert_listview);
        back_img.setVisibility(View.VISIBLE);
        title_text.setText("报警信息");
        back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertInfoActivity.this.finish();
            }
        });
        alertInfoAdapter = new AlertInfoAdapter(this);
    }
}
