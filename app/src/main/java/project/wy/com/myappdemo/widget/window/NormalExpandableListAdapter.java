package project.wy.com.myappdemo.widget.window;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import project.wy.com.myappdemo.AlertInfoActivity;
import project.wy.com.myappdemo.MainActivity;
import project.wy.com.myappdemo.MeinAndHealthyActivity;
import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.bean.CompanyInfoBean;
import project.wy.com.myappdemo.bean.MaintenanceInfoBean;
import project.wy.com.myappdemo.bean.ProjectBean;
import project.wy.com.myappdemo.bean.ProjectInfoBean;
import project.wy.com.myappdemo.bean.SubProBean;
import project.wy.com.myappdemo.bean.SubProInfoBean;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.LogUtil;

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
    private SubProInfoBean mSubProInfoBean;
    private Context context;
    private int pro_id;

    //根据分组的展开闭合状态设置指示器
    public void setIndicatorState(int groupPosition, boolean isExpanded) {
        if (isExpanded) {
            mIndicators.get(groupPosition).setImageResource(R.mipmap.ic_minus);
        } else {
            mIndicators.get(groupPosition).setImageResource(R.mipmap.ic_add);
        }
    }

    public NormalExpandableListAdapter(Context context) {
        this.context = context;
        mIndicators = new SparseArray<>();
    }

public void setData(CompanyInfoBean companyInfoBean, List<ProjectInfoBean> projectInfoBeanList, SubProInfoBean subProInfoBean) {
    mCompanyInfoBean = companyInfoBean;
    mProjectInfoBeanList = projectInfoBeanList;
    mSubProInfoBean = subProInfoBean;
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
            childViewHolder.warning = (Button) convertView.findViewById(R.id.warning_child);
            childViewHolder.wait_mainten  = (Button)convertView.findViewById(R.id.wait_mainten_child);
            childViewHolder.healthy_state = (Button)convertView.findViewById(R.id.healthy_state_child);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }
        ProjectBean projectBean = mProjectInfoBeanList.get(groupPosition).getResult().get(childPosition);
        pro_id = projectBean.getProj_id();
        childViewHolder.tvTitle.setText(projectBean.getProj_name());
        List<SubProBean> subProBeans = mSubProInfoBean.getLeft();
        for(SubProBean subProBean : subProBeans){
            if(Integer.parseInt(subProBean.getProj_id()) == projectBean.getProj_id()){
                ClickListener clickListener = new ClickListener();
                childViewHolder.warning.setText("报警"+subProBean.getAlart()+"");
                childViewHolder.wait_mainten.setText("待维保"+subProBean.getNdate()+"");
                childViewHolder.healthy_state.setText("健康状态差"+subProBean.getState()+"");

                childViewHolder.warning.setOnClickListener(clickListener);
                childViewHolder.wait_mainten.setOnClickListener(clickListener);
                childViewHolder.healthy_state.setOnClickListener(clickListener);
            }
        }
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
        Button warning;
        Button wait_mainten;
        Button healthy_state;

    }

    private class ClickListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.warning_child:
                    LogUtil.d(TAG,"-----点击了----");
                    Intent intent = new Intent();
                    intent.setClass(context,AlertInfoActivity.class);
                    intent.putExtra("Proj_id",pro_id);
                    context.startActivity(intent);
                    return;
                case R.id.wait_mainten_child:
                    LogUtil.d(TAG,"-----点击了----");
                    Intent intent1 = new Intent();
                    intent1.setClass(context,MeinAndHealthyActivity.class);
                    intent1.putExtra("Proj_id",pro_id);
                    intent1.putExtra("Type","WaitMainten");
                    context.startActivity(intent1);
                    return;
                case R.id.healthy_state_child:
                    LogUtil.d(TAG,"-----点击了----");
                    Intent intent2 = new Intent();
                    intent2.setClass(context,MeinAndHealthyActivity.class);
                    intent2.putExtra("Proj_id",pro_id);
                    intent2.putExtra("Type","Healthy");
                    context.startActivity(intent2);
                    break;
            }
        }
    }

}
