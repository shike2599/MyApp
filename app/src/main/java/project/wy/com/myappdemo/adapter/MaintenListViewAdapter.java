package project.wy.com.myappdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.bean.MaintenanceInfoBean;
import project.wy.com.myappdemo.untils.StringUtil;

public class MaintenListViewAdapter extends BaseAdapter {
    private Context mContext;
    private MaintenanceInfoBean maintenanceInfoBean;
    public MaintenListViewAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setDate(MaintenanceInfoBean maintenanceInfoBean){
        this.maintenanceInfoBean = maintenanceInfoBean;
    }
    @Override
    public int getCount() {
        return maintenanceInfoBean.getResult().size();
    }

    @Override
    public Object getItem(int position) {
        return maintenanceInfoBean.getResult().get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if(convertView == null){
           convertView = View.inflate(mContext, R.layout.mainten_listview_item_layout,null);
           viewHolder = new ViewHolder();
           viewHolder.show_data = convertView.findViewById(R.id.date_textview);
           viewHolder.show_time = convertView.findViewById(R.id.time_textview);
           viewHolder.show_user_time = convertView.findViewById(R.id.show_user_maintime_textview);
           viewHolder.show_content = convertView.findViewById(R.id.show_mainten_content);
           viewHolder.show_result = convertView.findViewById(R.id.show_mainten_result);
           viewHolder.show_momo = convertView.findViewById(R.id.show_mainten_memo);
            convertView.setTag(convertView);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        MaintenanceInfoBean.ResultBean resultBean = maintenanceInfoBean.getResult().get(position);
        String[] time_arr = StringUtil.stampToDate(resultBean.getEquip_main_date().getTime()+"");
        viewHolder.show_data.setText(time_arr[0]);
        viewHolder.show_time.setText(time_arr[1]);
        String user_time_str = resultBean.getEquip_main_worker()+"用了"+resultBean.getEquip_main_time()+"分钟";
        viewHolder.show_user_time.setText(user_time_str);
        String content = "完成了"+resultBean.getEquip_main_info();
        viewHolder.show_content.setText(content);

        String result = "";
        if(resultBean.getEquip_main_result() == 0){
            result = "维保结果：正常";
        }else{
            result = "维保失败，需要更换";
        }
        viewHolder.show_result.setText(result);
        viewHolder.show_momo.setText("维保备注："+resultBean.getEquip_main_memo());
        return convertView;
    }

    static class ViewHolder {
        TextView show_data;
        TextView show_time;
        TextView show_user_time;
        TextView show_content;
        TextView show_result;
        TextView show_momo;
    }
}
