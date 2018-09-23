package project.wy.com.myappdemo.bean;

import java.util.List;

/**
 * Created by lichee on 2018/9/24.
 */

public class ProjectInfoBean {

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * proj_isdeleted : 0
         * proj_num : 2000
         * proj_memo : ??????
         * proj_rank :
         * proj_addr : ??????
         * proj_name : ??????
         * company : {"comp_rank":"","comp_isdeleted":0,"comp_addr":"??????","comp_name":"???????","comp_memo":"????????","comp_num":100,"comp_id":1,"user":null}
         * proj_id : 8
         * user : null
         */

        private int proj_isdeleted;
        private int proj_num;
        private String proj_memo;
        private String proj_rank;
        private String proj_addr;
        private String proj_name;
        private CompanyBean company;
        private int proj_id;
        private Object user;

        public int getProj_isdeleted() {
            return proj_isdeleted;
        }

        public void setProj_isdeleted(int proj_isdeleted) {
            this.proj_isdeleted = proj_isdeleted;
        }

        public int getProj_num() {
            return proj_num;
        }

        public void setProj_num(int proj_num) {
            this.proj_num = proj_num;
        }

        public String getProj_memo() {
            return proj_memo;
        }

        public void setProj_memo(String proj_memo) {
            this.proj_memo = proj_memo;
        }

        public String getProj_rank() {
            return proj_rank;
        }

        public void setProj_rank(String proj_rank) {
            this.proj_rank = proj_rank;
        }

        public String getProj_addr() {
            return proj_addr;
        }

        public void setProj_addr(String proj_addr) {
            this.proj_addr = proj_addr;
        }

        public String getProj_name() {
            return proj_name;
        }

        public void setProj_name(String proj_name) {
            this.proj_name = proj_name;
        }

        public CompanyBean getCompany() {
            return company;
        }

        public void setCompany(CompanyBean company) {
            this.company = company;
        }

        public int getProj_id() {
            return proj_id;
        }

        public void setProj_id(int proj_id) {
            this.proj_id = proj_id;
        }

        public Object getUser() {
            return user;
        }

        public void setUser(Object user) {
            this.user = user;
        }

        public static class CompanyBean {
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
}
