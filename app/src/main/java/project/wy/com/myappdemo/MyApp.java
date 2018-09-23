package project.wy.com.myappdemo;

import android.app.Application;
import android.content.Context;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import project.wy.com.myappdemo.untils.OkhttpUtils;

public class MyApp extends Application {
    private  static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        initOkHttp();
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
