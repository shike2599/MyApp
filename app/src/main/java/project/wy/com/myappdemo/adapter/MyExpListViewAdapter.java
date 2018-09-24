package project.wy.com.myappdemo.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.bean.MaintenanceInfoBean;
import project.wy.com.myappdemo.untils.StringUtil;

public class MyExpListViewAdapter extends BaseExpandableListAdapter{
    private Context mContext;
    private MaintenanceInfoBean mMaintenBean;
    private int mEp_id;
    //                用于存放Indicator的集合
    private SparseArray<ImageView> mIndicators;
    public MyExpListViewAdapter(Context context){
        mContext = context;
    }

    public void setData( MaintenanceInfoBean maintenanceInfoBean,int ep_id){
        mMaintenBean = maintenanceInfoBean;
        mEp_id = ep_id;
        mIndicators = new SparseArray<>();
    }

    //            根据分组的展开闭合状态设置指示器
    public void setIndicatorState(int groupPosition, boolean isExpanded) {
        if (isExpanded) {
            mIndicators.get(groupPosition).setImageResource(R.mipmap.ic_expand_rdown_new);
        } else {
            mIndicators.get(groupPosition).setImageResource(R.mipmap.ic_expand_right_new);
        }
    }

    @Override
    public int getGroupCount() {
        return mMaintenBean.getResult().size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mMaintenBean.getResult().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return 1;
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }
    //        获取显示指定分组的视图
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.mainten_expandable_item_layout, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.mainten_exp_father_textivew);
            groupViewHolder.ivIndicator = (ImageView) convertView.findViewById(R.id.iv_indicator);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        String time_1 = StringUtil.stampToDate(mMaintenBean.getResult().get(groupPosition).getEquip_main_date().getTime()+"");
        String time_2 = time_1+"  "+"星期"+mMaintenBean.getResult().get(groupPosition).getEquip_main_date().getDay();
        //      把位置和图标添加到Map
        mIndicators.put(groupPosition, groupViewHolder.ivIndicator);
        //      根据分组状态设置Indicator
        setIndicatorState(groupPosition, isExpanded);
        groupViewHolder.tvTitle.setText(time_2);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_expand_child, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.equipment = (TextView) convertView.findViewById(R.id.equipment);
            childViewHolder.equip_main_id = (TextView) convertView.findViewById(R.id.equip_maintenance_id);
            childViewHolder.equip_id = (TextView) convertView.findViewById(R.id.equip_id);
            childViewHolder.equip_main_info = (TextView) convertView.findViewById(R.id.equip_maintenance_info);
            childViewHolder.equip_date = (TextView) convertView.findViewById(R.id.equip_maintenance_date);
            childViewHolder.equip_main_time = (TextView) convertView.findViewById(R.id.quip_maintenance_time);
            childViewHolder.equip_main_worker = (TextView) convertView.findViewById(R.id.equip_maintenance_worker);
            childViewHolder.equip_main_result = (TextView) convertView.findViewById(R.id.equip_maintenance_result);
            childViewHolder.equip_main_memo = (TextView) convertView.findViewById(R.id.equip_maintenance_memo);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        Object obj = mMaintenBean.getResult().get(groupPosition).getEquipment();
        if(obj != null&& !obj.equals("")){
            childViewHolder.equipment.setText((String)obj);
        }else{
            childViewHolder.equipment.setText("");
        }
        childViewHolder.equip_main_id.setText( mMaintenBean.getResult().get(groupPosition).getEquip_main_id()+"");
        childViewHolder.equip_id.setText( mEp_id+"");
        childViewHolder.equip_main_info.setText( mMaintenBean.getResult().get(groupPosition).getEquip_main_info());
        String data = StringUtil.stampToDate(mMaintenBean.getResult().get(groupPosition).getEquip_main_date().getTime()+"");
        String time      = data+"  "+"星期"+mMaintenBean.getResult().get(groupPosition).getEquip_main_date().getDay();
        childViewHolder.equip_date.setText(time);
        childViewHolder.equip_main_time.setText( mMaintenBean.getResult().get(groupPosition).getEquip_main_time()+"");
        childViewHolder.equip_main_worker.setText( mMaintenBean.getResult().get(groupPosition).getEquip_main_worker());
        if(mMaintenBean.getResult().get(groupPosition).getEquip_main_result() == 0){
            childViewHolder.equip_main_result.setText( "正常");
        }else{
            childViewHolder.equip_main_result.setText("维保失败，需要更换");
        }
        childViewHolder.equip_main_memo.setText( mMaintenBean.getResult().get(groupPosition).getEquip_main_memo());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static class GroupViewHolder {
        TextView tvTitle;
        ImageView ivIndicator;
    }

    static class ChildViewHolder {
        TextView equipment,equip_main_memo,equip_main_time,equip_main_worker,
                equip_main_id,equip_main_info,equip_main_result,equip_id,equip_date;
    }
}
