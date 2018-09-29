package project.wy.com.myappdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ezvizuikit.open.EZUIError;
import com.ezvizuikit.open.EZUIKit;
import com.ezvizuikit.open.EZUIPlayer;

import java.util.Calendar;

import project.wy.com.myappdemo.untils.Constant;

public class OpenYSPlayerActivity extends Activity {
     private String URL = "ezopen://open.ys7.com/C24186733/1.hd.live";
     private EZUIPlayer ezuiPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_ysplayer);

        ezuiPlayer = (EZUIPlayer) findViewById(R.id.player_ui);
        //设置播放参数
        ezuiPlayer.setUrl(URL);
        //设置播放回调callback
        ezuiPlayer.setCallBack(new EZUIPlayer.EZUIPlayerCallBack() {
            @Override
            public void onPlaySuccess() {

            }

            @Override
            public void onPlayFail(EZUIError ezuiError) {

            }

            @Override
            public void onVideoSizeChange(int i, int i1) {

            }

            @Override
            public void onPrepared() {


                //开始播放
                ezuiPlayer.startPlay();
            }

            @Override
            public void onPlayTime(Calendar calendar) {

            }

            @Override
            public void onPlayFinish() {

            }
        });

    }
}
