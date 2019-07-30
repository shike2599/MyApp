package project.wy.com.myappdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import project.wy.com.myappdemo.adapter.WarningNewAdapter;
import project.wy.com.myappdemo.fragment.DeviceListFragment;

public class WarningNewsActivity extends Activity {

    ImageView backImage;
    ListView listView;
    WarningNewAdapter warningNewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warning_news);
        backImage = findViewById(R.id.im_back);
        listView = findViewById(R.id.warn_new_list);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        warningNewAdapter = new WarningNewAdapter(this);
        warningNewAdapter.setData(DeviceListFragment.warningNewsListBean);
        listView.setAdapter(warningNewAdapter);
    }
}
