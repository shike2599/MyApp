package project.wy.com.myappdemo.widget.window;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.PopupWindow;

import java.util.List;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.bean.CompanyInfoBean;
import project.wy.com.myappdemo.bean.ProjectInfoBean;
import project.wy.com.myappdemo.untils.Constant;

/**
 * Created by lichee on 2018/9/26.
 */

public class MenuPopupWindow extends PopupWindow {
    private Context context;
    private View contentView;
    private ExpandableListView popList;
    private  NormalExpandableListAdapter adapter;
    private final static String TAG = "MenuPopupWindow";

    public MenuPopupWindow(Context context) {
        this.context = context;
        //获得 LayoutInflater 的实例
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        contentView = inflater.inflate(R.layout.popup_company_info, null);
        popList = contentView.findViewById(R.id.pop_list);
        adapter = new NormalExpandableListAdapter();
        popList.setAdapter(adapter);
        adapter.setOnGroupExpandedListener(new OnGroupExpandedListener() {
            @Override
            public void onGroupExpanded(int groupPosition) {
                expandOnlyOne(groupPosition);
            }
        });

        //  设置分组项的点击监听事件
        popList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                Log.d(TAG, "onGroupClick: groupPosition:" + groupPosition + ", id:" + id);
                // 请务必返回 false，否则分组不会展开
                return false;
            }
        });

        //  设置子选项点击监听事件
        popList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                Log.i(TAG,"onChildClick: groupPosition:" + groupPosition + ", childPosition:" + childPosition);
                Object obj = null;
                updateUI.setUI(obj);
                return true;
            }
        });

        this.setContentView(contentView);
        // 设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth(WindowManager.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体的高
        this.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        // 设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        this.setOutsideTouchable(true);
        // 刷新状态
        this.update();
    }

    /**
     * 显示popupWindow
     *
     * @param parent
     */
    public void showPopupWindow(View parent) {
        if (!this.isShowing()) {
            // 以下拉方式显示popupwindow
            this.showAsDropDown(parent, -80, 70);
        } else {
            this.dismiss();
        }
    }

    public void setData(CompanyInfoBean companyInfoBean,List<ProjectInfoBean> projectInfoBeanList) {
        adapter.setData(companyInfoBean,projectInfoBeanList);
        adapter.notifyDataSetChanged();
    }

    // 每次展开一个分组后，关闭其他的分组
    private boolean expandOnlyOne(int expandedPosition) {
        boolean result = true;
        int groupLength = popList.getExpandableListAdapter().getGroupCount();
        for (int i = 0; i < groupLength; i++) {
            if (i != expandedPosition && popList.isGroupExpanded(i)) {
                result &= popList.collapseGroup(i);
            }
        }
        return result;
    }

    public OnDeviceBeanUpdate updateUI;
    public interface OnDeviceBeanUpdate{
       void setUI(Object object);
    }
    public void setOnDeviceUpdate(OnDeviceBeanUpdate deviceUpdate){
        updateUI = deviceUpdate;
    }
}
