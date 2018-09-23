package project.wy.com.myappdemo.fragment;

import android.view.View;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.base.BaseFragment;

public class DeviceInfragment extends BaseFragment {
    public DeviceInfragment(){

    }
    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.device_info_layout,null);
        return view;
    }
}
