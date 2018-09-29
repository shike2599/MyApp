package project.wy.com.myappdemo.bean;

import java.util.List;

/**
 * Created by lichee on 2018/9/29.
 */

public class LocalDeviceInfoBean {

    private List<EquipmentBean> equipment;
    private List<RoomBean> room;

    public List<EquipmentBean> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<EquipmentBean> equipment) {
        this.equipment = equipment;
    }

    public List<RoomBean> getRoom() {
        return room;
    }

    public void setRoom(List<RoomBean> room) {
        this.room = room;
    }

}
