package project.wy.com.myappdemo.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import com.bigkoo.pickerview.TimePickerView;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.LineChart;
import com.google.gson.Gson;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.base.BaseFragment;
import project.wy.com.myappdemo.bean.EquipmentBean;
import project.wy.com.myappdemo.bean.EquipmentOperBean;
import project.wy.com.myappdemo.bean.EquipmentOperInfoBean;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.LogUtil;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.StringUtil;
import project.wy.com.myappdemo.untils.ToastUtil;
import project.wy.com.myappdemo.widget.chart.BarXChart;
import project.wy.com.myappdemo.widget.chart.BaseXChart;
import project.wy.com.myappdemo.widget.chart.LineXChart;

public class RunningInfoFragment extends BaseFragment implements View.OnClickListener{

    private CombinedChart barChart;
    private LineChart lineChart;
    private TextView show_deivce_name;
    private EditText input_time,input_info;
    private Button start_select_btn,start_input_info;
    private EquipmentOperInfoBean eopInfoBean;
    private EquipmentBean equipmentBean;

    private Spinner parms_spinner;
    private ArrayAdapter<String> adapter;

    public void setEquId(int equId) {
        this.equId = equId;
    }

    public void setBean(EquipmentBean bean) {
        this.equipmentBean = bean;
    }

    private int equId;
    private final static String TAG = RunningInfoFragment.class.getSimpleName();
    private TimePickerView tmPicker;

    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.running_info_layout, null);
        barChart = view.findViewById(R.id.bar_chart);
        lineChart = view.findViewById(R.id.line_chart);
        show_deivce_name = view.findViewById(R.id.runing_deivce_name);
        input_time = view.findViewById(R.id.select_timer);
        input_info = view.findViewById(R.id.input_running_info);
        start_select_btn = view.findViewById(R.id.start_search_runing_btn);
        start_input_info = view.findViewById(R.id.start_push_runing_info);

        parms_spinner = view.findViewById(R.id.device_prams_spinner);


        input_time.setOnClickListener(this);
        start_select_btn.setOnClickListener(this);
        start_input_info.setOnClickListener(this);

        if(equipmentBean!=null){
            show_deivce_name.setText(equipmentBean.getEquip_name());
        }

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

        adapter = new ArrayAdapter<>(mContext,android.R.layout.simple_spinner_item,new String[] {"请选择设备参数信息"});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        parms_spinner.setAdapter(adapter);
        parms_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                deivice_id = adapter.getItem(position);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        DialogUtil.showDialogLoading(mContext, "");
        //准备数据
        Map<String, String> params = new HashMap<>();
        params.put("equip_para_id", String.valueOf(equId));
        Log.i(TAG, "equip_para_id:" + equId);
        params.put("startDate", StringUtil.getTime(new Date()));
//        params.put("startDate","2018-09-10 00:00:00");
        Log.i(TAG, "init----startDate:" + StringUtil.getTime(new Date()));
        doPost(params, Constant.QUEST_DEVICE_RUN_INFO);

    }

    //开始查找
    private void doPost(Map<String, String> params, String Url) {
        DialogUtil.showDialogLoading(mContext, "正在查找，请稍等...");
        OkhttpUtils.postAsyn(Url, params, new HttpCallback() {
            @Override
            public void onSuccess(String resultDesc) {
                super.onSuccess(resultDesc);
                LogUtil.d(TAG,resultDesc);
                Gson gson = new Gson();
                eopInfoBean = gson.fromJson(resultDesc, EquipmentOperInfoBean.class);
                if(eopInfoBean.getData()!=null&&eopInfoBean.getData().size()>0){
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
                    BaseXChart<LineChart> xchart = new LineXChart();
                    xchart.initXChart(lineChart);
                    xchart.showXChart(lineChart,xValues, chartDataMap, colors);
                    DialogUtil.hideDialogLoading();
                }else{
                    DialogUtil.hideDialogLoading();
                    ToastUtil.showText("未查找到运行数据！");
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

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.start_search_runing_btn:
                String time = input_time.getText().toString();
                if(time!=null&&!time.equals("")){
                    Map<String,String> prams = new HashMap<>();
                    prams.put("equip_para_id", String.valueOf(equId));
                    Log.i(TAG, "equip_para_id:" + equId);
                    prams.put("startDate",time);
                    Log.i(TAG, "startDate:" + time);
                    doPost(prams,Constant.QUEST_DEVICE_RUN_INFO);
                }else{
                    ToastUtil.showText("请输入时间！");
                }
                break;
            case R.id.start_push_runing_info:
                String info = input_info.getText().toString();
                if(info!=null&&!info.equals("")){
                    Map<String,String> parms = new HashMap();
                    parms.put("equip_para_id",equId+"");
                    parms.put("equip_operation_info",info.trim());
                    startPost(Constant.ADD_RUNNING_INFO,parms);
                }else{
                    ToastUtil.showText("请输入运行信息然后开始查询！");
                }
                break;
            case R.id.select_timer:

                Date curDate = new Date(System.currentTimeMillis());//获取当前时间
                SimpleDateFormat formatter_year = new SimpleDateFormat("yyyy ");
                String year_str = formatter_year.format(curDate);
                int year_int = (int) Double.parseDouble(year_str);


                SimpleDateFormat formatter_mouth = new SimpleDateFormat("MM ");
                String mouth_str = formatter_mouth.format(curDate);
                int mouth_int = (int) Double.parseDouble(mouth_str);

                SimpleDateFormat formatter_day = new SimpleDateFormat("dd ");
                String day_str = formatter_day.format(curDate);
                int day_int = (int) Double.parseDouble(day_str);

                Calendar selectedDate = Calendar.getInstance();//系统当前时间
                Calendar startDate = Calendar.getInstance();
                startDate.set(1900, 0, 1);
                Calendar endDate = Calendar.getInstance();
                endDate.set(year_int, mouth_int - 1, day_int);

                tmPicker = new TimePickerView.Builder(mContext, new TimePickerView.OnTimeSelectListener() {
                    @Override
                    public void onTimeSelect(Date date, View v) {
                       input_time.setText(StringUtil.getTime(date));
                    }
                }).setTextColorOut(Color.BLUE)//设置没有被选中项的颜色
                    .setContentSize(15)
                    .setDate(selectedDate)
                    .setLineSpacingMultiplier(1.5f)
                    .setTextXOffset(-10, 0,10, 0, 0, 0)//设置X轴倾斜角度[ -90 , 90°]
                    .setRangDate(startDate, endDate)
                    .setDecorView(null)
                    .build();
                tmPicker.show();
                break;
        }
    }
   //上传
    private void startPost(String url, Map<String,String> parms) {
        OkhttpUtils.postAsyn(url, parms, new HttpCallback() {
            @Override
            public void onSuccess(String resultDesc) {
                super.onSuccess(resultDesc);
                DialogUtil.hideDialogLoading();
                LogUtil.d(TAG,resultDesc);
                ToastUtil.showText("运行参数上传成功！");
            }

            @Override
            public void onFailure(int code, String message) {
                super.onFailure(code, message);
                DialogUtil.hideDialogLoading();
                ToastUtil.showText("服务器异常！！！");
            }
        });
    }
}
