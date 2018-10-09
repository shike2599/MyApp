package project.wy.com.myappdemo.fragment;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.base.BaseFragment;
import project.wy.com.myappdemo.bean.DeviceInfoBean;
import project.wy.com.myappdemo.bean.EquipmentBean;
import project.wy.com.myappdemo.bean.FileIdBean;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.ImageUtils;
import project.wy.com.myappdemo.untils.LogUtil;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.StringUtil;
import project.wy.com.myappdemo.untils.ToastUtil;

public class DeviceInfragment extends BaseFragment {
    private static final String TAG = DeviceInfragment.class.getSimpleName();
    private TextView device_name,next_mainten_time_TextVeiw,device_use_data,
                    device_product,device_phone,device_pay,
                    device_maintenan_cycle,device_period_of_depreciation,
                    device_life_cy, device_remarks;
    private static EquipmentBean  equInfoBean;
    private ImageView device_pic;
    private ImageView healthy_img;
    public static void  setInfoBean(EquipmentBean infoBean){
        equInfoBean = infoBean;
    }

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.device_info_layout,null);
        this.device_name = view.findViewById(R.id.device_name_info);
        next_mainten_time_TextVeiw = view.findViewById(R.id.next_mainten_time_TextVeiw);//下次维修时间
        device_use_data = view.findViewById(R.id.device_use_data);

        this.device_product = view.findViewById(R.id.device_product);
        this.device_phone = view.findViewById(R.id.device_phone);
        this.device_pay = view.findViewById(R.id.device_pay);

        this.device_maintenan_cycle = view.findViewById(R.id.device_maintenan_cycle);
        this.device_period_of_depreciation = view.findViewById(R.id.device_period_of_depreciation);
        this.device_life_cy = view.findViewById(R.id.device_life_cy);
        this.device_remarks = view.findViewById(R.id.device_remarks);

        this.device_pic = view.findViewById(R.id.device_pic);
        this.healthy_img = view.findViewById(R.id.healthy_imageView);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        DialogUtil.showDialogLoading(mContext,null);
        device_name.setText(equInfoBean.getEquip_name());

        if(equInfoBean.getEquip_ndate()!=null){
            long first_time = equInfoBean.getEquip_ndate().getTime();
            if(new Date().getTime()  > first_time){
                next_mainten_time_TextVeiw.setTextColor(Color.argb(100,191,37,43));
            }
            next_mainten_time_TextVeiw.setText(StringUtil.stampToDate(String.valueOf(first_time))[0]);
            device_use_data.setText(StringUtil.stampToDate(String.valueOf(equInfoBean.getEquip_udate().getTime()))[0]);

        }else{
            next_mainten_time_TextVeiw.setText("未知时间");
            device_use_data.setText("未知时间");
        }





        device_product.setText(equInfoBean.getEquip_manu());
        device_phone.setText(equInfoBean.getEquip_tel());
        device_pay.setText(equInfoBean.getEquip_bfee()+"");

        device_maintenan_cycle.setText(equInfoBean.getEquip_mdate()+"");

        device_period_of_depreciation.setText(equInfoBean.getEquip_life()+"");//有问题

        device_life_cy.setText(equInfoBean.getEquip_atime()+"");

        int healthy_state  = equInfoBean.getEquip_state();
        setHealthy_img(healthy_state);


        if(equInfoBean.getEquip_memo()!=null){
            device_remarks.setText("设备备注："+equInfoBean.getEquip_memo()+"");
        }else{
            device_remarks.setText("");
        }
        FileIdBean fileIdBean = equInfoBean.getFile_id();
        if(fileIdBean!=null && fileIdBean.getFile_path()!=null && !fileIdBean.getFile_path().equals("")){
            String fileArr[] = fileIdBean.getFile_path().split("\\\\");
            //http://116.62.186.91:8080//gywyext//picture//8b2187ecec4d28820180923110257542.jpg
            String realPath = "http://116.62.186.91:8080//"+fileArr[3]+"//"+fileArr[4]+"//"+fileArr[5];
            LogUtil.d(TAG,"RealPaht---"+realPath);
            OkhttpUtils.displayAsynImage(realPath, new HttpCallback() {
                @Override
                public void onSuccess(String resultDesc) {
                    super.onSuccess(resultDesc);
                }

                @Override
                public void onBitmapSuccess(Bitmap bitmap) {
                    super.onBitmapSuccess(bitmap);
                    DialogUtil.hideDialogLoading();
                    device_pic.setImageBitmap(bitmap);
                }

                @Override
                public void onFailure(int code, String message) {
                    super.onFailure(code, message);
                    DialogUtil.hideDialogLoading();
                    ToastUtil.showText("图片加载失败！");
                }
            });
        }else{
            ToastUtil.showText("图片不存在");
        }


    }

    //选择健康状态
    private void setHealthy_img(int state){
        if(state == 1){
            healthy_img.setBackgroundResource(R.mipmap.healthy_1_icon);
        }else if(state == 2){
            healthy_img.setBackgroundResource(R.mipmap.healthy_2_icon);
        }else if(state == 3){
            healthy_img.setBackgroundResource(R.mipmap.healthy_3_icon);
        }else if(state == 4){
            healthy_img.setBackgroundResource(R.mipmap.healthy_4_icon);
        }else if(state == 5){
            healthy_img.setBackgroundResource(R.mipmap.healthy_5_icon);
        }else if(state == 6){
            healthy_img.setBackgroundResource(R.mipmap.healthy_6_icon);
        }else if(state == 7){
            healthy_img.setBackgroundResource(R.mipmap.healthy_7_icon);
        }else if(state == 8){
            healthy_img.setBackgroundResource(R.mipmap.healthy_8_icon);
        }else if(state == 9){
            healthy_img.setBackgroundResource(R.mipmap.healthy_9_icon);
        }else if(state == 10){
            healthy_img.setBackgroundResource(R.mipmap.healthy_10_icon);
        }
    }
}
