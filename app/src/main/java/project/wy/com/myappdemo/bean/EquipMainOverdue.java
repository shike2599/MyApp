package project.wy.com.myappdemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lichee on 2018/10/11.
 */

public class EquipMainOverdue implements Serializable{

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable{
        /**
         * equip_id : 1
         * equip_name : ???
         * equip_memo : ????????????
         */

        private int equip_id;
        private String equip_name;
        private String equip_memo;

        public int getEquip_id() {
            return equip_id;
        }

        public void setEquip_id(int equip_id) {
            this.equip_id = equip_id;
        }

        public String getEquip_name() {
            return equip_name;
        }

        public void setEquip_name(String equip_name) {
            this.equip_name = equip_name;
        }

        public String getEquip_memo() {
            return equip_memo;
        }

        public void setEquip_memo(String equip_memo) {
            this.equip_memo = equip_memo;
        }
    }
}
