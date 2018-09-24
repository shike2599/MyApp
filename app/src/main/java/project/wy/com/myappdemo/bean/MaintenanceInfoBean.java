package project.wy.com.myappdemo.bean;

import java.util.List;

/**
 * Created by lichee on 2018/9/24.
 */

public class MaintenanceInfoBean {

    private List<ResultBean> result;

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * equip_main_date : {"date":12,"hours":0,"seconds":0,"month":1,"nanos":0,"timezoneOffset":-480,"year":116,"minutes":0,"time":1455206400000,"day":5}
         * equipment : null
         * equip_main_memo : 123
         * equip_main_time : 0
         * equip_main_worker :
         * equip_main_id : 1
         * equip_main_info : 123
         * equip_main_result : 123
         */

        private EquipMainDateBean equip_main_date;
        private Object equipment;
        private String equip_main_memo;
        private int equip_main_time;
        private String equip_main_worker;
        private int equip_main_id;
        private String equip_main_info;
        private int equip_main_result;

        public EquipMainDateBean getEquip_main_date() {
            return equip_main_date;
        }

        public void setEquip_main_date(EquipMainDateBean equip_main_date) {
            this.equip_main_date = equip_main_date;
        }

        public Object getEquipment() {
            return equipment;
        }

        public void setEquipment(Object equipment) {
            this.equipment = equipment;
        }

        public String getEquip_main_memo() {
            return equip_main_memo;
        }

        public void setEquip_main_memo(String equip_main_memo) {
            this.equip_main_memo = equip_main_memo;
        }

        public int getEquip_main_time() {
            return equip_main_time;
        }

        public void setEquip_main_time(int equip_main_time) {
            this.equip_main_time = equip_main_time;
        }

        public String getEquip_main_worker() {
            return equip_main_worker;
        }

        public void setEquip_main_worker(String equip_main_worker) {
            this.equip_main_worker = equip_main_worker;
        }

        public int getEquip_main_id() {
            return equip_main_id;
        }

        public void setEquip_main_id(int equip_main_id) {
            this.equip_main_id = equip_main_id;
        }

        public String getEquip_main_info() {
            return equip_main_info;
        }

        public void setEquip_main_info(String equip_main_info) {
            this.equip_main_info = equip_main_info;
        }

        public int getEquip_main_result() {
            return equip_main_result;
        }

        public void setEquip_main_result(int equip_main_result) {
            this.equip_main_result = equip_main_result;
        }

        public static class EquipMainDateBean {
            /**
             * date : 12
             * hours : 0
             * seconds : 0
             * month : 1
             * nanos : 0
             * timezoneOffset : -480
             * year : 116
             * minutes : 0
             * time : 1455206400000
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
    }
}
