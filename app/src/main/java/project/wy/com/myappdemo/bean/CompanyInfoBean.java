package project.wy.com.myappdemo.bean;

import java.util.List;

/**
 * Created by lichee on 2018/9/23.
 */

public class CompanyInfoBean {

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * comp_rank :
         * comp_isdeleted : 0
         * comp_addr : ??????
         * comp_name : ???????
         * comp_memo : ????????
         * comp_num : 100
         * comp_id : 1
         * user : null
         */

        private String comp_rank;
        private int comp_isdeleted;
        private String comp_addr;
        private String comp_name;
        private String comp_memo;
        private int comp_num;
        private int comp_id;
        private Object user;

        public String getComp_rank() {
            return comp_rank;
        }

        public void setComp_rank(String comp_rank) {
            this.comp_rank = comp_rank;
        }

        public int getComp_isdeleted() {
            return comp_isdeleted;
        }

        public void setComp_isdeleted(int comp_isdeleted) {
            this.comp_isdeleted = comp_isdeleted;
        }

        public String getComp_addr() {
            return comp_addr;
        }

        public void setComp_addr(String comp_addr) {
            this.comp_addr = comp_addr;
        }

        public String getComp_name() {
            return comp_name;
        }

        public void setComp_name(String comp_name) {
            this.comp_name = comp_name;
        }

        public String getComp_memo() {
            return comp_memo;
        }

        public void setComp_memo(String comp_memo) {
            this.comp_memo = comp_memo;
        }

        public int getComp_num() {
            return comp_num;
        }

        public void setComp_num(int comp_num) {
            this.comp_num = comp_num;
        }

        public int getComp_id() {
            return comp_id;
        }

        public void setComp_id(int comp_id) {
            this.comp_id = comp_id;
        }

        public Object getUser() {
            return user;
        }

        public void setUser(Object user) {
            this.user = user;
        }
    }
}
