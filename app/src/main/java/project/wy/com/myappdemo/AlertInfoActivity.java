package project.wy.com.myappdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class AlertInfoActivity extends Activity {
    private TextView title_text;
    private ImageView back_img;
    private ListView alert_listview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_info);
        title_text = findViewById(R.id.title_msg);
        back_img = findViewById(R.id.back_img);
        alert_listview = findViewById(R.id.alert_listview);
        back_img.setVisibility(View.VISIBLE);
        title_text.setText("报警信息");
    }
}
