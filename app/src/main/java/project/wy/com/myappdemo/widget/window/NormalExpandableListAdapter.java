package project.wy.com.myappdemo.widget.window;

import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.bean.CompanyInfoBean;
import project.wy.com.myappdemo.bean.MaintenanceInfoBean;
import project.wy.com.myappdemo.bean.ProjectInfoBean;

/**
 * @author Richie on 2017.07.31
 *         普通的 ExpandableListView 的适配器
 */
public class NormalExpandableListAdapter extends BaseExpandableListAdapter {
    private static final String TAG = "NormalExpandableListAda";

    private CompanyInfoBean mCompanyInfoBean;
    private List<ProjectInfoBean> mProjectInfoBeanList;
    private SparseArray<ImageView> mIndicators;
    private OnGroupExpandedListener mOnGroupExpandedListener;


    //根据分组的展开闭合状态设置指示器
    public void setIndicatorState(int groupPosition, boolean isExpanded) {
        if (isExpanded) {
            mIndicators.get(groupPosition).setImageResource(R.mipmap.ic_minus);
        } else {
            mIndicators.get(groupPosition).setImageResource(R.mipmap.ic_add);
        }
    }

    public NormalExpandableListAdapter() {
        mIndicators = new SparseArray<>();
    }

public void setData(CompanyInfoBean companyInfoBean,List<ProjectInfoBean> projectInfoBeanList) {
    mCompanyInfoBean = companyInfoBean;
    mProjectInfoBeanList = projectInfoBeanList;
}

    public void setOnGroupExpandedListener(OnGroupExpandedListener onGroupExpandedListener) {
        mOnGroupExpandedListener = onGroupExpandedListener;
    }

    @Override
    public int getGroupCount() {
        if(mCompanyInfoBean != null && mCompanyInfoBean.getResult() != null) {
            return mCompanyInfoBean.getResult().size();
        }
            return 0;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        if(mProjectInfoBeanList != null && mProjectInfoBeanList.get(groupPosition) != null && mProjectInfoBeanList.get(groupPosition).getResult() != null){
            return mProjectInfoBeanList.get(groupPosition).getResult().size();
        }
       return 0;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mCompanyInfoBean.getResult().get(groupPosition).getComp_name();
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mProjectInfoBeanList.get(groupPosition).getResult().get(childPosition).getProj_name();
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

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View
            convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_company_info_group, parent, false);
            groupViewHolder = new GroupViewHolder();
            groupViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.group_name);
            groupViewHolder.ivImg = (ImageView) convertView.findViewById(R.id.group_img);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        //      把位置和图标添加到Map
        mIndicators.put(groupPosition, groupViewHolder.ivImg);
        //      根据分组状态设置Indicator
        setIndicatorState(groupPosition, isExpanded);
        groupViewHolder.tvTitle.setText(mCompanyInfoBean.getResult().get(groupPosition).getComp_name());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View
            convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_company_info_child, parent, false);
            childViewHolder = new ChildViewHolder();
            childViewHolder.tvTitle = (TextView) convertView.findViewById(R.id.list_child);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        childViewHolder.tvTitle.setText(mProjectInfoBeanList.get(groupPosition).getResult().get(childPosition).getProj_name());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {
        Log.d(TAG, "onGroupExpanded() called with: groupPosition = [" + groupPosition + "]");
        if (mOnGroupExpandedListener != null) {
            mOnGroupExpandedListener.onGroupExpanded(groupPosition);
        }
    }

    @Override
    public void onGroupCollapsed(int groupPosition) {
        Log.d(TAG, "onGroupCollapsed() called with: groupPosition = [" + groupPosition + "]");
    }

    private static class GroupViewHolder {
        TextView tvTitle;
        ImageView  ivImg;
    }

    private static class ChildViewHolder {
        TextView tvTitle;
    }
}
