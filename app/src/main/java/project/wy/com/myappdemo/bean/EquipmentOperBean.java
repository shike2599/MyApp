package project.wy.com.myappdemo.bean;

import java.io.Serializable;

/**
 * Created by lichee on 2018/9/23.
 */

public  class EquipmentOperBean implements Serializable{
    /**
     * equip_oper_id : 6739
     * equip_oper_time : 2018-09-12 21:16:00
     * equip_oper_info : 768.0
     * equip_para_id : 3
     */
    private int equip_oper_id;
    private String equip_oper_time;
    private String equip_oper_info;
    private int equip_para_id;

    public int getEquip_oper_id() {
        return equip_oper_id;
    }

    public void setEquip_oper_id(int equip_oper_id) {
        this.equip_oper_id = equip_oper_id;
    }

    public String getEquip_oper_time() {
        return equip_oper_time;
    }

    public void setEquip_oper_time(String equip_oper_time) {
        this.equip_oper_time = equip_oper_time;
    }

    public String getEquip_oper_info() {
        return equip_oper_info;
    }

    public void setEquip_oper_info(String equip_oper_info) {
        this.equip_oper_info = equip_oper_info;
    }

    public int getEquip_para_id() {
        return equip_para_id;
    }

    public void setEquip_para_id(int equip_para_id) {
        this.equip_para_id = equip_para_id;
    }
}