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

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.bean.CompanyInfoBean;
import project.wy.com.myappdemo.bean.LocalDeviceInfoBean;
import project.wy.com.myappdemo.bean.ProjectInfoBean;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.LogUtil;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.ToastUtil;

/**
 * Created by lichee on 2018/9/26.
 */

public class MenuPopupWindow extends PopupWindow {
    private Context mContext;
    private View contentView;
    private ExpandableListView popList;
    private  NormalExpandableListAdapter adapter;
    private final static String TAG = "MenuPopupWindow";
    private CompanyInfoBean companyInfoBean;
    private List<ProjectInfoBean> projectInfoBeanList;

    public MenuPopupWindow(Context context) {
        this.mContext = context;
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
                int pro_id = projectInfoBeanList.get(childPosition).getResult().get(childPosition).getProj_id();
                DialogUtil.showDialogLoading(mContext,"正在查询...");
                Map<String,String> prams = new HashMap<>();
                prams.put("proj_id",String.valueOf(pro_id));
                OkhttpUtils.postAsyn(Constant.QUEST_DEVCE_BY_PROJ, prams, new HttpCallback() {
                    @Override
                    public void onSuccess(String resultDesc) {
                        super.onSuccess(resultDesc);
                        LogUtil.d(TAG,resultDesc);
                        DialogUtil.hideDialogLoading();
                        Gson gson = new Gson();
                        LocalDeviceInfoBean localDeviceInfoBean = gson.fromJson(resultDesc, LocalDeviceInfoBean.class);
                        if(localDeviceInfoBean!=null&&localDeviceInfoBean.getEquipment().size()>0){
                            updateUI.setUI(localDeviceInfoBean);
                        }else{
                            ToastUtil.showText("未找到数据");
                        }
                    }

                    @Override
                    public void onFailure(int code, String message) {
                        super.onFailure(code, message);
                        DialogUtil.hideDialogLoading();
                        ToastUtil.showText("服务器异常！！！");
                    }
                });
                Object obj = null;

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
        this.companyInfoBean = companyInfoBean;
        this.projectInfoBeanList = projectInfoBeanList;
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
