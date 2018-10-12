package project.wy.com.myappdemo.bean;

import java.io.Serializable;

/**
 * Created by lichee on 2018/10/12.
 */

public class SubProBean implements Serializable{
    /**
     * alart : 9
     * ndate : 7
     * comp_name : 8
     * proj_name : 8
     * state : 1
     * comp_id : 8
     * proj_id : 8
     */

    private String alart;
    private String ndate;
    private String comp_name;
    private String proj_name;
    private String state;
    private String comp_id;
    private String proj_id;

    public String getAlart() {
        return alart;
    }

    public void setAlart(String alart) {
        this.alart = alart;
    }

    public String getNdate() {
        return ndate;
    }

    public void setNdate(String ndate) {
        this.ndate = ndate;
    }

    public String getComp_name() {
        return comp_name;
    }

    public void setComp_name(String comp_name) {
        this.comp_name = comp_name;
    }

    public String getProj_name() {
        return proj_name;
    }

    public void setProj_name(String proj_name) {
        this.proj_name = proj_name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getComp_id() {
        return comp_id;
    }

    public void setComp_id(String comp_id) {
        this.comp_id = comp_id;
    }

    public String getProj_id() {
        return proj_id;
    }

    public void setProj_id(String proj_id) {
        this.proj_id = proj_id;
    }

    @Override
    public String toString() {
        return "SubProBean{" +
                "alart='" + alart + '\'' +
                ", ndate='" + ndate + '\'' +
                ", comp_name='" + comp_name + '\'' +
                ", proj_name='" + proj_name + '\'' +
                ", state='" + state + '\'' +
                ", comp_id='" + comp_id + '\'' +
                ", proj_id='" + proj_id + '\'' +
                '}';
    }
}
