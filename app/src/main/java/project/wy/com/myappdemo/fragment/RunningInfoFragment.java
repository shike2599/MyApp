package project.wy.com.myappdemo.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.wy.com.myappdemo.DeviceInfoActivity;
import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.base.BaseFragment;
import project.wy.com.myappdemo.bean.DeviceInfoBean;
import project.wy.com.myappdemo.bean.EquipmentInfoBean;
import project.wy.com.myappdemo.bean.EquipmentOperBean;
import project.wy.com.myappdemo.bean.EquipmentOperInfoBean;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.ToastUtil;

public class RunningInfoFragment extends BaseFragment {

    private BarChart barChart;
    private YAxis leftAxis;             //左侧Y轴
    private YAxis rightAxis;            //右侧Y轴
    private XAxis xAxis;                //X轴
    private Legend legend;              //图例
    private LimitLine limitLine;        //限制线

    private EquipmentOperInfoBean eopInfoBean;

    private final static String TAG = RunningInfoFragment.class.getSimpleName();

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.running_info_layout, null);
        barChart = view.findViewById(R.id.bar_chart);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initBarChart(barChart);
//        BarChartBean barChartBean = LocalJsonAnalyzeUtil.JsonToObject(this,
//                "bar_chart.json", BarChartBean.class);
//        List<VtDateValueBean> dateValueList = barChartBean.getStFinDate().getVtDateValue();
//        Collections.reverse(dateValueList);//将集合 逆序排列，转换成需要的顺序

//        showBarChart(dateValueList, "设备信息", getResources().getColor(R.color.blue));
//
        initData();
        initBarChartData();

    }

    private void initBarChartData() {
        List<EquipmentOperBean> dataList = eopInfoBean.getData();
        showBarChart(dataList, "设备信息", getResources().getColor(R.color.blue));
    }

    @Override
    protected void initData() {
        super.initData();
        DialogUtil.showDialogLoading(mContext, "");
        //准备数据
        Map<String, String> params = new HashMap<>();
        params.put("equip_para_id", String.valueOf(7));
        params.put("startDate", "2018-09-10 00:00:00");
        doPost(params, Constant.QUEST_DEVICE_RUN_INFO);

    }

    //开始查找
    private void doPost(Map<String, String> params, String Url) {
        DialogUtil.showDialogLoading(mContext, "正在查找，请稍等...");
        OkhttpUtils.postAsyn(Url, params, new HttpCallback() {
            @Override
            public void onSuccess(String resultDesc) {
                super.onSuccess(resultDesc);
                Log.d(TAG,resultDesc);
                DialogUtil.hideDialogLoading();
                Gson gson = new Gson();
                eopInfoBean = gson.fromJson(resultDesc,EquipmentOperInfoBean.class);

            }

            @Override
            public void onFailure(int code, String message) {
                super.onFailure(code, message);
                DialogUtil.hideDialogLoading();
                ToastUtil.showText("服务器异常！！！");
            }
        });
    }


    /**
     * 初始化BarChart图表
     */
    private void initBarChart(BarChart barChart) {
        /***图表设置***/
        //背景颜色
        barChart.setBackgroundColor(Color.WHITE);
        //不显示图表网格
        barChart.setDrawGridBackground(false);
        //背景阴影
        barChart.setDrawBarShadow(false);
        barChart.setHighlightFullBarEnabled(false);
        //显示边框
        barChart.setDrawBorders(true);
        //设置动画效果
//        barChart.animateY(1000, Easing.);
//        barChart.animateX(1000, Easing.Linear);

        /***XY轴的设置***/
        //X轴设置显示位置在底部
        xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);

        leftAxis = barChart.getAxisLeft();
        rightAxis = barChart.getAxisRight();
        //保证Y轴从0开始，不然会上移一点
        leftAxis.setAxisMinimum(0f);
        rightAxis.setAxisMinimum(0f);

        /***折线图例 标签 设置***/
        legend = barChart.getLegend();
        legend.setForm(Legend.LegendForm.LINE);
        legend.setTextSize(11f);
        //显示位置
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        //是否绘制在图表里面
        legend.setDrawInside(false);
    }

    /**
     * 柱状图始化设置 一个BarDataSet 代表一列柱状图
     *
     * @param barDataSet 柱状图
     * @param color      柱状图颜色
     */
    private void initBarDataSet(BarDataSet barDataSet, int color) {
        barDataSet.setColor(color);
        barDataSet.setFormLineWidth(1f);
        barDataSet.setFormSize(15.f);
        //不显示柱状图顶部值
        barDataSet.setDrawValues(false);
    }

    public void showBarChart(List<EquipmentOperBean> dataList, String name, int color) {
        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < dataList.size(); i++) {
            /**
             * 此处还可传入Drawable对象 BarEntry(float x, float y, Drawable icon)
             * 即可设置柱状图顶部的 icon展示
             */
            BarEntry barEntry = new BarEntry(i, Float.parseFloat(dataList.get(i).getEquip_oper_info()));
            entries.add(barEntry);
        }
        // 每一个BarDataSet代表一类柱状图
        BarDataSet barDataSet = new BarDataSet(entries, name);
        initBarDataSet(barDataSet, color);

        BarData data = new BarData(barDataSet);
        barChart.setData(data);
    }

}
