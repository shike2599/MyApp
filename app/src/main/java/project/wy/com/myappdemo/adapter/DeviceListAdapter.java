package project.wy.com.myappdemo.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.bean.DeviceInfoBean;
import project.wy.com.myappdemo.bean.EquipMainOverdue;

public class DeviceListAdapter extends BaseAdapter {

    private Context mContext;
    private EquipMainOverdue deviceList;
    public DeviceListAdapter(Context context) {
        mContext = context;
    }

    public void setData(EquipMainOverdue deviceBean) {
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
         TextView deive_name = null;
         TextView device_type = null;

        if(convertView == null){
           convertView = View.inflate(mContext, R.layout.item_expand_child,null);
           deive_name = convertView.findViewById(R.id.device_name);
           device_type = convertView.findViewById(R.id.device_model);

           convertView.setTag(new ViewHolder(deive_name,device_type));
        }else{
            ViewHolder viewHolder = (ViewHolder) convertView.getTag();
            deive_name = viewHolder.device_name;
            device_type = viewHolder.device_type;
        }
        String name = deviceList.getList().get(position).getEquip_name();
        String type = deviceList.getList().get(position).getEquip_memo();
        deive_name.setText(name);
        device_type.setText(type);
        return convertView;
    }

    private class ViewHolder{
        private TextView device_name;
        private TextView device_type;
        public ViewHolder(TextView device_name,TextView device_type ){
            this.device_name = device_name;
            this.device_type = device_type;

        }
    }
}
