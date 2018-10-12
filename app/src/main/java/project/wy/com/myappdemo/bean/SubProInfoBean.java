package project.wy.com.myappdemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lichee on 2018/10/12.
 */

public class SubProInfoBean implements Serializable{

    private List<SubProBean> left;

    public List<SubProBean> getLeft() {
        return left;
    }

    public void setLeft(List<SubProBean> left) {
        this.left = left;
    }

}
