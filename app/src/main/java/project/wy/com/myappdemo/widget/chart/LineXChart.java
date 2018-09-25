package project.wy.com.myappdemo.widget.chart;

import android.graphics.Color;
import android.graphics.Matrix;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by lichee on 2018/9/25.
 */

public class LineXChart implements BaseXChart<LineChart> {

    private YAxis leftAxis;             //左侧Y轴
    private YAxis rightAxis;            //右侧Y轴
    private XAxis xAxis;                //X轴

    @Override
    public void initXChart(LineChart lineChart) {
        /***图表设置***/
        //背景颜色
        lineChart.setBackgroundColor(Color.WHITE);
        //不显示图表网格
        lineChart.setDrawGridBackground(false);

        //显示边框
        lineChart.setDrawBorders(false);

        lineChart.setDragEnabled(true);
        lineChart.setScaleYEnabled(false); //是否可以缩放 仅y轴

        Legend legend = lineChart.getLegend(); // 设置比例图标示，就是那个一组y的value的
        legend.setEnabled(false);//是否绘制比例图
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(true);
        legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
        legend.setForm(Legend.LegendForm.LINE);

        //  不显示右下角描述内容
        Description description = new Description();
        description.setEnabled(false);
        lineChart.setDescription(description);

        /***XY轴的设置***/
        //X轴设置显示位置在底部
        xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);//不显示x轴网格
        xAxis.setAxisMinimum(0f);
        xAxis.setGranularity(1f);//设置最小间隔，防止当放大时，出现重复标签。
        xAxis.setTextSize(8f);
        xAxis.setLabelRotationAngle(120f);

        leftAxis = lineChart.getAxisLeft();
        rightAxis = lineChart.getAxisRight();
        //保证Y轴从0开始，不然会上移一点
        // 上面的右图是以下代码设置后的效果图
        leftAxis.setStartAtZero(false);
        leftAxis.setTextSize(8f);

        leftAxis.setDrawGridLines(false);
        rightAxis.setEnabled(false);
        rightAxis.setDrawGridLines(false);
        lineChart.setExtraOffsets(15, 30, 20, 10);//设置视图窗口大小
        lineChart.animateX(500);//数据显示动画，从左往右依次显示
        lineChart.setPinchZoom(true);//设置按比例放缩
        lineChart.setMaxVisibleValueCount(100);
        Matrix mMatrix = new Matrix();
        mMatrix.postScale(25f, 1f);//放大
        lineChart.getViewPortHandler().refresh(mMatrix, lineChart, false);
        lineChart.invalidate();
    }

    @Override
    public void showXChart(LineChart lineChart,final List<String> xValues, LinkedHashMap<String, List<Float>> dataLists, List<Integer> colors) {
        List<ILineDataSet> dataSets = new ArrayList<>();
        LineData lineData = new LineData();
        List<Float> yValueList = null;
        for (LinkedHashMap.Entry<String, List<Float>> entry : dataLists.entrySet()) {
            String name = entry.getKey();
            yValueList = entry.getValue();

            List<Entry> entries = new ArrayList<>();
            for (int i = 0; i < yValueList.size(); i++) {
                entries.add(new BarEntry(i, yValueList.get(i)));
            }

            leftAxis.setAxisMinValue(Collections.min(yValueList));
            leftAxis.setAxisMaxValue(Collections.max(yValueList));

            LineDataSet lineDataSet = new LineDataSet(entries, name);
            initBarDataSet(lineDataSet, colors.get(0));
            dataSets.add(lineDataSet);
            lineData.addDataSet(lineDataSet);
        }

//        //X轴自定义值
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xValues.get((int) Math.abs(value) % xValues.size());
            }
        });
        lineChart.setData(lineData);
    }

    private void initBarDataSet(LineDataSet lineDataSet, int color) {
        lineDataSet.setColor(color);
        lineDataSet.setFillColor(color);
        lineDataSet.setFormLineWidth(20f);
        lineDataSet.setFormSize(15f);
        lineDataSet.setValueTextSize(10f);
        lineDataSet.setCubicIntensity(0.2f);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet.setDrawValues(false);
        lineDataSet.setDrawCircles(false);
    }

}
