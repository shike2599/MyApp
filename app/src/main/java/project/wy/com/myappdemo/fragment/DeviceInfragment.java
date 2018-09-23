package project.wy.com.myappdemo.fragment;

import android.view.View;
import android.widget.TextView;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.base.BaseFragment;
import project.wy.com.myappdemo.bean.EquipmentBean;

public class DeviceInfragment extends BaseFragment {
    private TextView device_name,device_type_info,device_num,device_type_num,device_product,device_phone,device_pay,
            device_serial_num,device_health_state,device_maintenan_cycle,device_period_of_depreciation,
            device_life_cy,device_install_num,device_remarks;
    private static EquipmentBean  equInfoBean;
    public static void  setInfoBean(EquipmentBean infoBean){
        equInfoBean = infoBean;
    }

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.device_info_layout,null);
        this.device_name = view.findViewById(R.id.device_name_info);
        this.device_type_info = view.findViewById(R.id.device_type_info);
        this.device_num = view.findViewById(R.id.device_num);
        this.device_type_num = view.findViewById(R.id.device_type_num);
        this.device_product = view.findViewById(R.id.device_product);
        this.device_phone = view.findViewById(R.id.device_phone);
        this.device_pay = view.findViewById(R.id.device_pay);
        this.device_serial_num = view.findViewById(R.id.device_serial_num);
        this.device_health_state = view.findViewById(R.id.device_health_state);
        this.device_maintenan_cycle = view.findViewById(R.id.device_maintenan_cycle);
        this.device_period_of_depreciation = view.findViewById(R.id.device_period_of_depreciation);
        this.device_life_cy = view.findViewById(R.id.device_life_cy);
        this.device_install_num = view.findViewById(R.id.device_install_num);
        this.device_remarks = view.findViewById(R.id.device_remarks);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        device_name.setText(equInfoBean.getEquip_name());
        device_type_info.setText(equInfoBean.getEquip_no());
        device_num.setText(equInfoBean.getEquip_id()+"");
        if(equInfoBean.getEquip_type()!=null){
            device_type_num.setText((String)equInfoBean.getEquip_type());
        }else{
            device_type_num.setText("");
        }
        device_product.setText(equInfoBean.getEquip_manu());
        device_phone.setText(equInfoBean.getEquip_tel());
        device_pay.setText(equInfoBean.getEquip_bfee()+"");

        device_serial_num.setText(equInfoBean.getEquip_snum()+"");//有问题

        device_health_state.setText(equInfoBean.getEquip_state()+"");
        device_maintenan_cycle.setText(equInfoBean.getEquip_mdate()+"");

        device_period_of_depreciation.setText(equInfoBean.getEquip_life()+"");//有问题

        device_life_cy.setText(equInfoBean.getEquip_life()+"");
        if(equInfoBean.getEquip_room()!=null){
            device_install_num.setText((String)equInfoBean.getEquip_room());
        }else{
            device_install_num.setText("");
        }
        if(equInfoBean.getEquip_memo()!=null){
            device_remarks.setText(equInfoBean.getEquip_memo()+"");
        }else{
            device_remarks.setText("");
        }
    }
}
