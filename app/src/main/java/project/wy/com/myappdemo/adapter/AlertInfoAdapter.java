package project.wy.com.myappdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.bean.AlarmLogInfo;
import project.wy.com.myappdemo.untils.StringUtil;

public class AlertInfoAdapter extends BaseAdapter {
    private Context mContext;
    private AlarmLogInfo alarmLogInfo;
    public AlertInfoAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setDate(AlarmLogInfo alarmLogInfo){
        this.alarmLogInfo = alarmLogInfo;
    }
    @Override
    public int getCount() {
        return alarmLogInfo.getList().size();
    }

    @Override
    public Object getItem(int position) {
        return alarmLogInfo.getList().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        AlertInfoAdapter.ViewHolder viewHolder;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.alert_info_listview_item,null);
            viewHolder = new AlertInfoAdapter.ViewHolder();
            viewHolder.show_data = convertView.findViewById(R.id.alert_date_textview);
            viewHolder.show_time = convertView.findViewById(R.id.alert_time_textview);
            viewHolder.show_device_name = convertView.findViewById(R.id.alert_deviceName_textview);
            viewHolder.show_alert_content = convertView.findViewById(R.id.alert_show_content);
            viewHolder.show_alert_momo = convertView.findViewById(R.id.alert_memo_textview);
            convertView.setTag(convertView);
        }else{
            viewHolder = (AlertInfoAdapter.ViewHolder) convertView.getTag();
        }
        AlarmLogInfo.ListBean listBean = alarmLogInfo.getList().get(position);
        String[] time_arr = StringUtil.stampToDate(listBean.getAlarm_log_date().getTime()+"");
        viewHolder.show_data.setText(time_arr[0]);
        viewHolder.show_time.setText(time_arr[1]);
        viewHolder.show_device_name.setText(listBean.getEquip_name());
        String content = "由于"+listBean.getAlarm_log_info();
        viewHolder.show_alert_content.setText(content);
        viewHolder.show_alert_momo.setText("维保备注："+listBean.getAlarm_log_memo());
        return convertView;
    }

    static class ViewHolder {
        TextView show_data;
        TextView show_time;
        TextView show_device_name;
        TextView show_alert_content;
        TextView show_alert_momo;
    }
}
