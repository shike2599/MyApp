package project.wy.com.myappdemo.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;
import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.bean.EquipmentBean;
import project.wy.com.myappdemo.bean.RoomBean;


public class MyExpListViewAdapter extends BaseExpandableListAdapter{
    private Context mContext;
    private List<List<EquipmentBean>> equipmentList = new ArrayList<>();
    private List<RoomBean> rooms;
    //用于存放Indicator的集合
    private SparseArray<ImageView> mIndicators;
    public MyExpListViewAdapter(Context context){
        mContext = context;
    }

    public void setData( List<RoomBean> rooms,List<List<EquipmentBean>> equipmentList){
        this.rooms = rooms;
        equipmentList = this.equipmentList;
        mIndicators = new SparseArray<>();
    }

    //根据分组的展开闭合状态设置指示器
    public void setIndicatorState(int groupPosition, boolean isExpanded) {
        if (isExpanded) {
            mIndicators.get(groupPosition).setImageResource(R.mipmap.ic_expand_rdown_new);
        } else {
            mIndicators.get(groupPosition).setImageResource(R.mipmap.ic_expand_right_new);
        }
    }

    @Override
    public int getGroupCount() {
        if(rooms != null){
            return rooms.size();
        }
        return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return equipmentList.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        if(rooms != null){
            return rooms.get(groupPosition).getEquip_room_name();
        }
        return "";
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        if(rooms != null && equipmentList.get(groupPosition) != null ){
            return equipmentList.get(groupPosition).get(childPosition).getEquip_name();
        }
        return "";
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
    //获取显示指定分组的视图
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.mainten_expandable_item_layout, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tvLocal = (TextView) convertView.findViewById(R.id.tv_local);
            groupViewHolder.ivIndicator = (ImageView) convertView.findViewById(R.id.iv_indicator);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        //把位置和图标添加到Map
        mIndicators.put(groupPosition, groupViewHolder.ivIndicator);
        //根据分组状态设置Indicator
        setIndicatorState(groupPosition, isExpanded);
        groupViewHolder.tvLocal.setText(rooms.get(groupPosition).getEquip_room_name()+"");
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_expand_child, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.device_name = (TextView) convertView.findViewById(R.id.device_name);
            childViewHolder.device_model = (TextView) convertView.findViewById(R.id.device_model);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.device_name.setText(equipmentList.get(groupPosition).get(childPosition).getEquip_name()+"");
        childViewHolder.device_model.setText(equipmentList.get(groupPosition).get(childPosition).getEquip_no()+"");
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

    static class GroupViewHolder {
        TextView tvLocal;
        ImageView ivIndicator;
    }

    static class ChildViewHolder {
        TextView device_name,device_model;
    }
}
