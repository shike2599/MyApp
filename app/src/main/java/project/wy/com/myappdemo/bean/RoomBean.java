package project.wy.com.myappdemo.bean;

import java.io.Serializable;

/**
 * Created by lichee on 2018/9/29.
 */

public  class RoomBean implements Serializable{
    /**
     * equip_room_id : 1
     * equip_room_name : ???
     * equip_room_isdeleted : 0
     * project : null
     * equip_room_memo :
     */

    private int equip_room_id;
    private String equip_room_name;
    private int equip_room_isdeleted;
    private Object project;
    private String equip_room_memo;

    public int getEquip_room_id() {
        return equip_room_id;
    }

    public void setEquip_room_id(int equip_room_id) {
        this.equip_room_id = equip_room_id;
    }

    public String getEquip_room_name() {
        return equip_room_name;
    }

    public void setEquip_room_name(String equip_room_name) {
        this.equip_room_name = equip_room_name;
    }

    public int getEquip_room_isdeleted() {
        return equip_room_isdeleted;
    }

    public void setEquip_room_isdeleted(int equip_room_isdeleted) {
        this.equip_room_isdeleted = equip_room_isdeleted;
    }

    public Object getProject() {
        return project;
    }

    public void setProject(Object project) {
        this.project = project;
    }

    public String getEquip_room_memo() {
        return equip_room_memo;
    }

    public void setEquip_room_memo(String equip_room_memo) {
        this.equip_room_memo = equip_room_memo;
    }
}