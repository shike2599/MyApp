package project.wy.com.myappdemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lichee on 2018/10/11.
 */

public class AlarmLogInfo implements Serializable{

    private List<ListBean> list;

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable{
        /**
         * alarm_log_id : 1
         * alarm_log_info : something
         * alarm_log_date : {"date":23,"hours":12,"seconds":30,"month":8,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":8,"time":1537675710000,"day":0}
         * alarm_log_memo :
         * equip_name : ???
         */

        private int alarm_log_id;
        private String alarm_log_info;
        private AlarmLogDateBean alarm_log_date;
        private String alarm_log_memo;
        private String equip_name;

        public int getAlarm_log_id() {
            return alarm_log_id;
        }

        public void setAlarm_log_id(int alarm_log_id) {
            this.alarm_log_id = alarm_log_id;
        }

        public String getAlarm_log_info() {
            return alarm_log_info;
        }

        public void setAlarm_log_info(String alarm_log_info) {
            this.alarm_log_info = alarm_log_info;
        }

        public AlarmLogDateBean getAlarm_log_date() {
            return alarm_log_date;
        }

        public void setAlarm_log_date(AlarmLogDateBean alarm_log_date) {
            this.alarm_log_date = alarm_log_date;
        }

        public String getAlarm_log_memo() {
            return alarm_log_memo;
        }

        public void setAlarm_log_memo(String alarm_log_memo) {
            this.alarm_log_memo = alarm_log_memo;
        }

        public String getEquip_name() {
            return equip_name;
        }

        public void setEquip_name(String equip_name) {
            this.equip_name = equip_name;
        }

        public static class AlarmLogDateBean {
            /**
             * date : 23
             * hours : 12
             * seconds : 30
             * month : 8
             * nanos : 0
             * timezoneOffset : -480
             * year : 118
             * minutes : 8
             * time : 1537675710000
             * day : 0
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
    }
}
