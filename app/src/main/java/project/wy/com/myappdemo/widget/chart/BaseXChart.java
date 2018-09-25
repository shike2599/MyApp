package project.wy.com.myappdemo.widget.chart;

import android.support.annotation.ColorRes;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by lichee on 2018/9/25.
 */

public interface BaseXChart<T> {

    void initXChart(T chart);
    void showXChart(T chart, final List<String> xValues, LinkedHashMap<String, List<Float>> dataLists,
                      @ColorRes List<Integer> colors);
}
