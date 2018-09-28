package project.wy.com.myappdemo.bean;

import java.util.List;

/**
 * Created by lichee on 2018/9/28.
 */

public class DevicePramsInfo {

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * equip_para_unit :
         * equip_para_max : 0
         * equip_para_rate : 0
         * equip_para_min : 0
         * equip_para_isdeleted : 0
         * equip_para_name : ???????
         * equipment : null
         * equip_para_memo :
         * equip_para_id : 17
         */

        private String equip_para_unit;
        private int equip_para_max;
        private int equip_para_rate;
        private int equip_para_min;
        private int equip_para_isdeleted;
        private String equip_para_name;
        private Object equipment;
        private String equip_para_memo;
        private int equip_para_id;

        public String getEquip_para_unit() {
            return equip_para_unit;
        }

        public void setEquip_para_unit(String equip_para_unit) {
            this.equip_para_unit = equip_para_unit;
        }

        public int getEquip_para_max() {
            return equip_para_max;
        }

        public void setEquip_para_max(int equip_para_max) {
            this.equip_para_max = equip_para_max;
        }

        public int getEquip_para_rate() {
            return equip_para_rate;
        }

        public void setEquip_para_rate(int equip_para_rate) {
            this.equip_para_rate = equip_para_rate;
        }

        public int getEquip_para_min() {
            return equip_para_min;
        }

        public void setEquip_para_min(int equip_para_min) {
            this.equip_para_min = equip_para_min;
        }

        public int getEquip_para_isdeleted() {
            return equip_para_isdeleted;
        }

        public void setEquip_para_isdeleted(int equip_para_isdeleted) {
            this.equip_para_isdeleted = equip_para_isdeleted;
        }

        public String getEquip_para_name() {
            return equip_para_name;
        }

        public void setEquip_para_name(String equip_para_name) {
            this.equip_para_name = equip_para_name;
        }

        public Object getEquipment() {
            return equipment;
        }

        public void setEquipment(Object equipment) {
            this.equipment = equipment;
        }

        public String getEquip_para_memo() {
            return equip_para_memo;
        }

        public void setEquip_para_memo(String equip_para_memo) {
            this.equip_para_memo = equip_para_memo;
        }

        public int getEquip_para_id() {
            return equip_para_id;
        }

        public void setEquip_para_id(int equip_para_id) {
            this.equip_para_id = equip_para_id;
        }
    }
}
