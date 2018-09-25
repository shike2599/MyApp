package project.wy.com.myappdemo.widget.chart;

import android.graphics.Color;
import android.graphics.Matrix;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by lichee on 2018/9/25.
 */

public class BarXChart implements BaseXChart<CombinedChart> {

    private YAxis leftAxis;             //左侧Y轴
    private YAxis rightAxis;            //右侧Y轴
    private XAxis xAxis;                //X轴

    @Override
    public void initXChart(CombinedChart barChart) {
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
        barChart.animateX(5000);//数据显示动画，从左往右依次显示
        barChart.setPinchZoom(true);//设置按比例放缩柱状图
        barChart.setMaxVisibleValueCount(100);
        Matrix mMatrix = new Matrix();
        mMatrix.postScale(25f, 1f);//柱形图放大
        barChart.getViewPortHandler().refresh(mMatrix, barChart, false);
        barChart.invalidate();
    }

    /**
     * @param xValues   X轴的值
     * @param dataLists LinkedHashMap<String, List<Float>>
     *                  key对应柱状图名字  List<Float> 对应每类柱状图的Y值
     * @param colors
     */
    @Override
    public void showXChart(CombinedChart barChart,final List<String> xValues, LinkedHashMap<String, List<Float>> dataLists, List<Integer> colors) {
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
        barDataSet.setValueTextSize(10f);
        //显示柱状图顶部值
        barDataSet.setDrawValues(true);
    }

}
