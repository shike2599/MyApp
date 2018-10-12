package project.wy.com.myappdemo;

import android.app.Application;
import android.content.Context;
import android.provider.ContactsContract;

import com.videogo.openapi.EZOpenSDK;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.OkhttpUtils;

public class MyApp extends Application {
    private  static Context mContext;

    public static EZOpenSDK getOpenSDK() {
        return EZOpenSDK.getInstance();
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initOkHttp();
        initEZSDK();
    }

    private void initEZSDK() {
        /** * sdk日志开关，正式发布需要去掉 */
        EZOpenSDK.showSDKLog(true);
        /** * 设置是否支持P2P取流,详见api */
        EZOpenSDK.enableP2P(false);
        EZOpenSDK.initLib(this, Constant.APP_KEY);
        getOpenSDK().setAccessToken(Constant.ACCESSTOKE);
    }

    //初始化Okhttp
    private void initOkHttp() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)//连接超时(单位:秒)
                .writeTimeout(20, TimeUnit.SECONDS)//写入超时(单位:秒)
                .readTimeout(20, TimeUnit.SECONDS)//读取超时(单位:秒)
//                .pingInterval(20, TimeUnit.SECONDS)////websocket轮训间隔(单位:秒)
                .build();
        OkhttpUtils.initClient(okHttpClient);
    }

    public static Context getContext() {
        return mContext;
    }
}
