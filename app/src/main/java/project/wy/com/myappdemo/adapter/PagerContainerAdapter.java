package project.wy.com.myappdemo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import project.wy.com.myappdemo.R;
import project.wy.com.myappdemo.bean.CompanyBean;
import project.wy.com.myappdemo.bean.CompanyInfoBean;

/**
 * Created by lichee on 2018/9/28.
 */

public class PagerContainerAdapter extends PagerAdapter {

    private Context mContext;
    private CompanyInfoBean mCompanyInfoBean;

    public PagerContainerAdapter(Context context) {
        mContext = context;
    }

    public void setData(CompanyInfoBean companyInfoBean){
        this.mCompanyInfoBean = companyInfoBean;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_company_info,null);
        CompanyBean companyBean = mCompanyInfoBean.getResult().get(position);
        TextView comp_name = view.findViewById(R.id.comp_name);
        comp_name.setText(companyBean.getComp_name()+"");
        TextView comp_rank = view.findViewById(R.id.comp_rank);
        comp_rank.setText(companyBean.getComp_rank()+"");
        TextView comp_num = view.findViewById(R.id.comp_num);
        comp_num.setText(companyBean.getComp_num()+"");
        TextView comp_addr = view.findViewById(R.id.comp_addr);
        comp_addr.setText(companyBean.getComp_addr()+"");
        TextView comp_memo = view.findViewById(R.id.comp_memo);
        comp_memo.setText(companyBean.getComp_memo()+"");
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        if(mCompanyInfoBean != null && mCompanyInfoBean.getResult() != null) {
            return mCompanyInfoBean.getResult().size();
        }
        return 0;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }
}
