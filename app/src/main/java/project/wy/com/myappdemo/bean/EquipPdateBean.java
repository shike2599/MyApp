package project.wy.com.myappdemo.bean;

import java.io.Serializable;

/**
 * Created by lichee on 2018/9/23.
 */

public  class EquipPdateBean implements Serializable {
    /**
     * date : 24
     * hours : 0
     * seconds : 0
     * month : 7
     * nanos : 0
     * timezoneOffset : -480
     * year : 118
     * minutes : 0
     * time : 1535040000000
     * day : 5
     */

    private int date;
    private int hours;
    private int seconds;
    private int month;
    private int nanos;
    private int timezoneOffset;
    private int year;
    private int minutes;
    private long time;
    private int day;

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getNanos() {
        return nanos;
    }

    public void setNanos(int nanos) {
        this.nanos = nanos;
    }

    public int getTimezoneOffset() {
        return timezoneOffset;
    }

    public void setTimezoneOffset(int timezoneOffset) {
        this.timezoneOffset = timezoneOffset;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMinutes() {
        return minutes;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }
}