package project.wy.com.myappdemo.fragment;


import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import me.crosswall.lib.coverflow.core.CoverTransformer;
import me.crosswall.lib.coverflow.core.PagerContainer;
import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.adapter.PagerContainerAdapter;
import project.wy.com.myappdemo.adapter.ProInfoListViewAdapter;
import project.wy.com.myappdemo.base.BaseFragment;
import project.wy.com.myappdemo.bean.CompanyBean;
import project.wy.com.myappdemo.bean.CompanyInfoBean;
import project.wy.com.myappdemo.bean.ProjectInfoBean;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.LogUtil;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.ToastUtil;

public class UserFragment extends BaseFragment {
    private static final String TAG = UserFragment.class.getSimpleName();

    private ProjectInfoBean projectInfoBean;
    private CompanyInfoBean companyInfoBean;
    private PagerContainer mContainer;
    private ViewPager pager;
    private PagerContainerAdapter mContainerAdapter;
    private ProInfoListViewAdapter adapter;
    private ListView prolist;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.user_fragmente_layout, null);
        mContainer = view.findViewById(R.id.pager_container);
        prolist = view.findViewById(R.id.proj_list);
        pager = mContainer.getViewPager();
        pager.setClipChildren(false);
        pager.setPageTransformer(false, new CoverTransformer(0.3f, 0f, 0f, 0f));
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int index = 0;

            @Override
            public void onPageSelected(int position) {
                index = position;
                searchProjInfo(position);
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state == ViewPager.SCROLL_STATE_IDLE) {

                }

            }
        });
        return view;
    }

    public void searchProjInfo(int position){
        CompanyBean companyBean = companyInfoBean.getResult().get(position);
        Log.i(TAG,"cid = "+companyBean.getComp_id());
        String comp_id_seach = companyBean.getComp_id() + "";
        Map<String, String> map = new HashMap<>();
        map.put("company_id", comp_id_seach);
        doPost(Constant.QUEST_PRO_INFO, map, "pro");
    }

    @Override
    protected void initData() {
        super.initData();
        //查找公司信息
        doPost(Constant.QUEST_COMP_INFO, null, "comp");
        DialogUtil.showDialogLoading(mContext, null);
    }

    private void doPost(String url, final Map<String, String> parms, final String type) {
        OkhttpUtils.postAsyn(url, parms, new HttpCallback() {
            @Override
            public void onSuccess(String resultDesc) {
                super.onSuccess(resultDesc);
                LogUtil.d(TAG, resultDesc);
                DialogUtil.hideDialogLoading();
                if (type.equals("comp")) {
                    Gson gson = new Gson();
                    companyInfoBean = gson.fromJson(resultDesc, CompanyInfoBean.class);
                    initPagerContainterData();
                } else {
                    Gson gson = new Gson();
                    projectInfoBean = gson.fromJson(resultDesc, ProjectInfoBean.class);
                    Log.i(TAG,"projectInfoBean");
                    initListViewData();
                }
            }

            @Override
            public void onFailure(int code, String message) {
                super.onFailure(code, message);
                DialogUtil.hideDialogLoading();
                ToastUtil.showText("服务器异常！！！");
            }
        });
    }

    public void initListViewData() {
        Log.i(TAG,"initListViewData");
        adapter = new ProInfoListViewAdapter(mContext);
        adapter.setData(projectInfoBean.getResult());
        prolist.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    public void initPagerContainterData() {
        mContainerAdapter = new PagerContainerAdapter(mContext);
        mContainerAdapter.setData(companyInfoBean);
        pager.setAdapter(mContainerAdapter);
        pager.setOffscreenPageLimit(mContainerAdapter.getCount());
        mContainerAdapter.notifyDataSetChanged();
        searchProjInfo(0);
    }
}
