package project.wy.com.myappdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.bean.WarningNewsListBean;
import project.wy.com.myappdemo.untils.StringUtil;

/**
 * Created by lichee on 2019/7/30.
 */

public class WarningNewAdapter extends BaseAdapter {

    Context mContext;
    WarningNewsListBean warningNewsListBean;

    public WarningNewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(WarningNewsListBean warningNewsListBean){
        this.warningNewsListBean = warningNewsListBean;
    }

    @Override
    public int getCount() {
        if(warningNewsListBean != null && warningNewsListBean.getList() !=null){
            return warningNewsListBean.getList().size();
        }
        return 0;
    }

    @Override
    public Object getItem(int i) {
        if(warningNewsListBean != null && warningNewsListBean.getList() !=null){
            return warningNewsListBean.getList().get(i);
        }
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        WarningNewAdapter.ViewHolder viewHolder;
        if(convertView == null){
            convertView = View.inflate(mContext, R.layout.warning_new_listview_item,null);
            viewHolder = new WarningNewAdapter.ViewHolder();
            viewHolder.show_time = convertView.findViewById(R.id.waring_time_textview);
            viewHolder.show_device_name = convertView.findViewById(R.id.waring_deviceName_textview);
            viewHolder.show_alert_content = convertView.findViewById(R.id.waring_show_content);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (WarningNewAdapter.ViewHolder) convertView.getTag();
        }
        WarningNewsListBean.ListBean listBean = warningNewsListBean.getList().get(position);
        String[] time_arr = StringUtil.stampToDate(listBean.getAlarm_log_date().getTime()+"");
        viewHolder.show_time.setText(time_arr[0]);
        viewHolder.show_device_name.setText(listBean.getEquipment().getEquip_name());
        String content = "报警信息:"+listBean.getAlarm_log_info();
        viewHolder.show_alert_content.setText(content);
        return convertView;
    }

    static class ViewHolder {
        TextView show_time;
        TextView show_device_name;
        TextView show_alert_content;
    }



}
