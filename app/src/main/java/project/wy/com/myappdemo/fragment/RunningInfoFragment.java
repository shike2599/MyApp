package project.wy.com.myappdemo.fragment;

import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.base.BaseFragment;
import project.wy.com.myappdemo.bean.EquipmentOperBean;
import project.wy.com.myappdemo.bean.EquipmentOperInfoBean;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.ToastUtil;

public class RunningInfoFragment extends BaseFragment {

    private CombinedChart barChart;
    private YAxis leftAxis;             //左侧Y轴
    private YAxis rightAxis;            //右侧Y轴
    private XAxis xAxis;                //X轴

    private EquipmentOperInfoBean eopInfoBean;

    public void setEquId(int equId) {
        this.equId = equId;
    }

    private int equId;
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
        initData();
    }


    @Override
    protected void initData() {
        super.initData();
        DialogUtil.showDialogLoading(mContext, "");
        //准备数据
        Map<String, String> params = new HashMap<>();
        params.put("equip_para_id", String.valueOf(equId));
        Log.i(TAG, "equip_para_id:" + equId);
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
                Gson gson = new Gson();
                eopInfoBean = gson.fromJson(resultDesc, EquipmentOperInfoBean.class);
                //处理数据是 记得判断每条柱状图对应的数据集合 长度是否一致
                LinkedHashMap<String, List<Float>> chartDataMap = new LinkedHashMap<>();
                List<String> xValues = new ArrayList<>();
                List<Float> yValues = new ArrayList<>();
                List<Integer> colors = Arrays.asList(
                        mContext.getResources().getColor(R.color.blue), mContext.getResources().getColor(R.color.blue)
                );
                List<EquipmentOperBean> valueList = eopInfoBean.getData();
                Collections.reverse(valueList);

                for (EquipmentOperBean valueBean : valueList) {
                    xValues.add(valueBean.getEquip_oper_time());
                    yValues.add(Float.parseFloat(valueBean.getEquip_oper_info()));
                }
                chartDataMap.put("设备运行信息", yValues);
                initBarChart(barChart);
                showBarChart(xValues, chartDataMap, colors);
                DialogUtil.hideDialogLoading();
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
    private void initBarChart(CombinedChart barChart) {
        /***图表设置***/
        //背景颜色
        barChart.setBackgroundColor(Color.WHITE);
        //不显示图表网格
        barChart.setDrawGridBackground(false);
        //背景阴影
        barChart.setDrawBarShadow(false);
        barChart.setHighlightFullBarEnabled(false);
        //显示边框
        barChart.setDrawBorders(false);

        barChart.setDragEnabled(true);
        barChart.setScaleYEnabled(false); //是否可以缩放 仅y轴

        Legend legend = barChart.getLegend(); // 设置比例图标示，就是那个一组y的value的
        legend.setEnabled(false);//是否绘制比例图
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);
        legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
        legend.setForm(Legend.LegendForm.SQUARE);

        //  不显示右下角描述内容
        Description description = new Description();
        description.setEnabled(false);
        barChart.setDescription(description);

        /***XY轴的设置***/
        //X轴设置显示位置在底部
        xAxis = barChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);//不显示x轴网格
        xAxis.setAxisMinimum(-0.5f);
        xAxis.setGranularity(1f);//设置最小间隔，防止当放大时，出现重复标签。
        xAxis.setTextSize(8f);

        leftAxis = barChart.getAxisLeft();
        rightAxis = barChart.getAxisRight();
        //保证Y轴从0开始，不然会上移一点
        // 上面的右图是以下代码设置后的效果图
        leftAxis.setStartAtZero(false);
        leftAxis.setTextSize(8f);

        leftAxis.setDrawGridLines(false);
        rightAxis.setEnabled(false);
        rightAxis.setDrawGridLines(false);
        barChart.setExtraOffsets(15, 30, 20, 10);//设置视图窗口大小
        barChart.animateX(1500);//数据显示动画，从左往右依次显示
        barChart.setPinchZoom(true);//设置按比例放缩柱状图
        barChart.setMaxVisibleValueCount(100);
        Matrix mMatrix = new Matrix();
        mMatrix.postScale(25f, 1f);
        barChart.getViewPortHandler().refresh(mMatrix, barChart, false);
        barChart.invalidate();
    }

    /**
     * 柱状图始化设置 一个BarDataSet 代表一列柱状图
     *
     * @param barDataSet 柱状图
     * @param color      柱状图颜色
     */
    private void initBarDataSet(BarDataSet barDataSet, int color) {
        barDataSet.setColor(color);
        barDataSet.setFormLineWidth(20f);
        barDataSet.setFormSize(15f);
        //显示柱状图顶部值
        barDataSet.setDrawValues(true);
    }

    /**
     * @param xValues   X轴的值
     * @param dataLists LinkedHashMap<String, List<Float>>
     *                  key对应柱状图名字  List<Float> 对应每类柱状图的Y值
     * @param colors
     */
    public void showBarChart(final List<String> xValues, LinkedHashMap<String, List<Float>> dataLists,
                             @ColorRes List<Integer> colors) {

        List<IBarDataSet> dataSets = new ArrayList<>();
        BarData barData = new BarData();
        List<Float> yValueList = null;
        for (LinkedHashMap.Entry<String, List<Float>> entry : dataLists.entrySet()) {
            String name = entry.getKey();
            yValueList = entry.getValue();

            List<BarEntry> entries = new ArrayList<>();

            for (int i = 0; i < yValueList.size(); i++) {

                entries.add(new BarEntry(i, yValueList.get(i)));
            }

            Log.i(TAG,"MAX:"+Collections.max(yValueList));
            Log.i(TAG,"MIN:"+Collections.min(yValueList));
            leftAxis.setAxisMinValue(Collections.min(yValueList));
            leftAxis.setAxisMaxValue(Collections.max(yValueList));

            // 每一个BarDataSet代表一类柱状图
            BarDataSet barDataSet = new BarDataSet(entries, name);
            initBarDataSet(barDataSet, colors.get(0));
            dataSets.add(barDataSet);
            barData.addDataSet(barDataSet);// 添加一组柱形图，如果有多组柱形图数据，则可以多次addDataSet来设置
        }

//        //X轴自定义值
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xValues.get((int) Math.abs(value) % xValues.size());
            }
        });

        CombinedData combinedData = new CombinedData(); // 创建组合图的数据源
        barData.setBarWidth(0.5f);
        combinedData.setData(barData);  // 添加柱形图数据源
        barChart.setData(combinedData); // 为组合图设置数据源
    }

}
