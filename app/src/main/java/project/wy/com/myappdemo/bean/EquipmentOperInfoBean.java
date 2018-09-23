package project.wy.com.myappdemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lichee on 2018/9/23.
 */

public class EquipmentOperInfoBean implements Serializable{

    private List<EquipmentOperBean> data;

    public List<EquipmentOperBean> getData() {
        return data;
    }

    public void setData(List<EquipmentOperBean> data) {
        this.data = data;
    }

}
