package project.wy.com.myappdemo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.List;
import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.bean.ProjectBean;

/**
 *
 * @author lichee
 * @date 2018/9/28
 */

public class ProInfoListViewAdapter extends BaseAdapter {

    private Context mContext;
    private List<ProjectBean> mProjectBeans ;

    public void setData(List<ProjectBean> list){
        mProjectBeans = list;
    }

    public ProInfoListViewAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        if(mProjectBeans != null){
           return mProjectBeans.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if(mProjectBeans != null){
            return mProjectBeans.get(position);
        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
       ViewHolder viewHolder;
        if(view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.item_project_info, null);
            viewHolder = new ViewHolder();
            viewHolder.proj_name = view.findViewById(R.id.proj_name);
            viewHolder.proj_rank = view.findViewById(R.id.proj_rank);
            viewHolder.proj_num = view.findViewById(R.id.proj_num);
            viewHolder.proj_addr = view.findViewById(R.id.proj_addr);
            viewHolder.pro_comp_memo = view.findViewById(R.id.pro_comp_memo);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }

        viewHolder.proj_name.setText(mProjectBeans.get(position).getProj_name()+"");
        viewHolder.proj_rank.setText(mProjectBeans.get(position).getProj_rank()+"");
        viewHolder.proj_num.setText(mProjectBeans.get(position).getProj_num()+"");
        viewHolder.proj_addr.setText(mProjectBeans.get(position).getProj_addr()+"");
        viewHolder.pro_comp_memo.setText(mProjectBeans.get(position).getProj_memo()+"");

        return view;
    }

    static class ViewHolder {
        TextView proj_name;
        TextView proj_rank;
        TextView proj_num;
        TextView proj_addr;
        TextView pro_comp_memo;
    }

}
