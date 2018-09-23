package project.wy.com.myappdemo.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.base.BaseFragment;
import project.wy.com.myappdemo.bean.CompanyInfoBean;
import project.wy.com.myappdemo.bean.EquipmentBean;
import project.wy.com.myappdemo.bean.ProjectInfoBean;
import project.wy.com.myappdemo.http.HttpCallback;
import project.wy.com.myappdemo.untils.Constant;
import project.wy.com.myappdemo.untils.DialogUtil;
import project.wy.com.myappdemo.untils.LogUtil;
import project.wy.com.myappdemo.untils.OkhttpUtils;
import project.wy.com.myappdemo.untils.ToastUtil;

public class UserFragment extends BaseFragment {
    private static final String TAG = UserFragment.class.getSimpleName();
    private TextView comp_id,comp_name,comp_rank,comp_num,comp_isdeleted,user_id,
                      comp_addr,comp_memo;
    private TextView proj_name,proj_id,pro_comp_id,proj_rank,proj_isdeleted,pro_user_id,
            proj_num,proj_addr,pro_comp_memo;

    private CompanyInfoBean companyInfoBean;
    private Spinner comp_spiner;
    private Spinner pro_spinner;

    private ArrayAdapter<String> adapter_Spinner_comp;
    private ArrayAdapter<String> adapter_Spinner_project;

//    private String comp_id_seach;
    private CompanyInfoBean.ResultBean resultBean;
    private ProjectInfoBean projectInfoBean;
    private ProjectInfoBean.ResultBean resultBean_pro;
    @Override
    protected View initView() {
        View view = View.inflate(mContext, R.layout.user_fragmente_layout, null);
        comp_id = view.findViewById(R.id.comp_id);
        comp_name = view.findViewById(R.id.comp_name);
        comp_rank = view.findViewById(R.id.comp_rank);
        comp_num = view.findViewById(R.id.comp_num);
        comp_isdeleted = view.findViewById(R.id.comp_isdeleted);
        user_id = view.findViewById(R.id.user_id);
        comp_addr = view.findViewById(R.id.comp_addr);
        comp_memo = view.findViewById(R.id.comp_memo);
         //公司下来列表
        comp_spiner = view.findViewById(R.id.comp_spinner);
        //项目
        pro_spinner = view.findViewById(R.id.pro_spinner);

        proj_name = view.findViewById(R.id.proj_name);
        proj_id = view.findViewById(R.id.proj_id);
        pro_comp_id = view.findViewById(R.id.pro_comp_id);
        proj_rank = view.findViewById(R.id.proj_rank);
        proj_isdeleted = view.findViewById(R.id.proj_isdeleted);
        pro_user_id = view.findViewById(R.id.pro_user_id);
        proj_num = view.findViewById(R.id.proj_num);
        proj_addr = view.findViewById(R.id.proj_addr);
        pro_comp_memo = view.findViewById(R.id.pro_comp_memo);
        return view;
    }

    @Override
    protected void initData() {
        super.initData();
        //查找公司信息
        doPost(Constant.QUEST_COMP_INFO,null,"comp");
        DialogUtil.showDialogLoading(mContext,null);
    }
    private void doPost(String url, final Map<String,String> parms, final String type){
        OkhttpUtils.postAsyn(url, parms, new HttpCallback() {
            @Override
            public void onSuccess(String resultDesc) {
                super.onSuccess(resultDesc);
                LogUtil.d(TAG,resultDesc);
                DialogUtil.hideDialogLoading();
                if(type.equals("comp")){
                    Gson gson = new Gson();
                    companyInfoBean = gson.fromJson(resultDesc, CompanyInfoBean.class);
                    adapter_Spinner_comp = new ArrayAdapter<>(mContext,android.R.layout.simple_spinner_item,getDeviceBeanList());
                    adapter_Spinner_comp.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    comp_spiner.setAdapter(adapter_Spinner_comp);
                    comp_spiner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            resultBean = companyInfoBean.getResult().get(position);
                            String comp_id_seach = resultBean.getComp_id()+"";
                            setshowTextComp("comp");
                            Map<String,String> map = new HashMap<>();
                            map.put("company_id",comp_id_seach);
                            doPost(Constant.QUEST_PRO_INFO,map,"pro");
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    comp_spiner.setSelection(0);
                }else{
                    Gson gson = new Gson();
                    projectInfoBean = gson.fromJson(resultDesc, ProjectInfoBean.class);
                    adapter_Spinner_project = new ArrayAdapter<>(mContext,android.R.layout.simple_spinner_item,getProjectList());
                    adapter_Spinner_project.setDropDownViewResource(android.R.layout.simple_spinner_item);
                    pro_spinner.setAdapter(adapter_Spinner_project);
                    pro_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            resultBean_pro = projectInfoBean.getResult().get(position);
                            setshowTextComp("pro");
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                    pro_spinner.setSelection(0);
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

     //公司列表
    public  List<String> getDeviceBeanList() {
        List<String> id_list = new ArrayList<>();
        if (companyInfoBean != null) {
            for (CompanyInfoBean.ResultBean resultBean : companyInfoBean.getResult()) {
                id_list.add(resultBean.getComp_name());
            }
        }
        return id_list;
    }

    //项目列表
    public  List<String> getProjectList() {
        List<String> id_list = new ArrayList<>();
        if (projectInfoBean != null) {
            for (ProjectInfoBean.ResultBean resultBean : projectInfoBean.getResult()) {
                id_list.add(resultBean.getProj_name());
            }
        }
        return id_list;
    }
    //公司信息
    private void setshowTextComp(String type){
        if(type.equals("comp")){
            if(companyInfoBean != null){
                comp_id.setText(resultBean.getComp_id()+"");
                comp_name.setText(resultBean.getComp_name());
                comp_rank.setText(resultBean.getComp_rank());
                comp_num.setText(resultBean.getComp_num()+"");
                if(resultBean.getComp_isdeleted() == 0){
                    comp_isdeleted.setText("存在");
                }else if(resultBean.getComp_isdeleted() == 1){
                    comp_isdeleted.setText("删除");
                }
                if(resultBean.getUser() == null){
                    user_id.setText("");
                }else{
                    user_id.setText(resultBean.getUser()+"");
                }
                comp_addr.setText(resultBean.getComp_addr());
                comp_memo.setText(resultBean.getComp_memo());

            }
        }else{
            if(projectInfoBean != null){
                proj_id.setText(resultBean_pro.getProj_id()+"");
                proj_name.setText(resultBean_pro.getProj_name());
                proj_addr.setText(resultBean_pro.getProj_addr());
                proj_num.setText(resultBean_pro.getProj_num()+"");

                if(resultBean_pro.getProj_isdeleted() == 0){
                    proj_isdeleted.setText("存在");
                }else if(resultBean_pro.getProj_isdeleted() == 1){
                    proj_isdeleted.setText("删除");
                }
               ProjectInfoBean.ResultBean.CompanyBean companyBean = resultBean_pro.getCompany();
                if(companyBean.getUser() == null){
                    pro_user_id.setText("");
                }else{
                    pro_user_id.setText(companyBean.getUser()+"");
                }
                proj_rank.setText(resultBean_pro.getProj_rank());
                pro_comp_memo.setText(resultBean_pro.getProj_memo());
                pro_comp_id.setText(companyBean.getComp_id()+"");
            }
        }

    }
}
