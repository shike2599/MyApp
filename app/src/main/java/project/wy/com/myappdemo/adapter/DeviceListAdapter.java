package project.wy.com.myappdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import project.wy.com.myappdemo.bean.DeviceBean;

public class DeviceListAdapter extends BaseAdapter {

    private Context mContext;
    private DeviceBean deviceList;
    public DeviceListAdapter(Context context) {
        mContext = context;
    }

    public void setData(DeviceBean deviceBean) {
        deviceList = deviceBean;
    }
    @Override
    public int getCount() {
        return deviceList.getList().size();
    }

    @Override
    public Object getItem(int position) {
        return deviceList.getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
