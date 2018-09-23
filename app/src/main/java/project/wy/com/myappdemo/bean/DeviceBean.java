package project.wy.com.myappdemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lichee on 2018/9/23.
 */

public class DeviceBean implements Serializable{

    /**
     * list : [{"equip_mdate":20,"equip_isdeleted":0,"equip_name":"?????","equip_no":"?????","equip_udate":{"date":31,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535644800000,"day":5},"equip_state":0,"equip_tel":"13255555555","equip_id":7,"equip_atime":0,"equip_num":"?????","equip_ndate":{"date":7,"hours":0,"seconds":0,"month":8,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1536249600000,"day":5},"equip_snum":0,"file_id":null,"equip_manu":"?????","equip_pdate":{"date":24,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535040000000,"day":5},"equip_life":24,"equip_memo":"","equip_qrcode":"","equip_bfee":24,"user":null,"equip_room":null,"equip_type":null},{"equip_mdate":12,"equip_isdeleted":0,"equip_name":"??????","equip_no":"??????","equip_udate":{"date":31,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535644800000,"day":5},"equip_state":0,"equip_tel":"13255555555","equip_id":6,"equip_atime":0,"equip_num":"??????","equip_ndate":{"date":7,"hours":0,"seconds":0,"month":8,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1536249600000,"day":5},"equip_snum":0,"file_id":null,"equip_manu":"??????","equip_pdate":{"date":22,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534867200000,"day":3},"equip_life":20,"equip_memo":"","equip_qrcode":"","equip_bfee":32,"user":null,"equip_room":null,"equip_type":null},{"equip_mdate":20,"equip_isdeleted":0,"equip_name":"???????","equip_no":"???????","equip_udate":{"date":24,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535040000000,"day":5},"equip_state":0,"equip_tel":"13255555555","equip_id":5,"equip_atime":0,"equip_num":"???????","equip_ndate":{"date":31,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535644800000,"day":5},"equip_snum":0,"file_id":null,"equip_manu":"???????","equip_pdate":{"date":23,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534953600000,"day":4},"equip_life":20,"equip_memo":"","equip_qrcode":"","equip_bfee":20,"user":null,"equip_room":null,"equip_type":null},{"equip_mdate":20,"equip_isdeleted":0,"equip_name":"???????","equip_no":"???????","equip_udate":{"date":24,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535040000000,"day":5},"equip_state":0,"equip_tel":"13255555555","equip_id":4,"equip_atime":0,"equip_num":"???????","equip_ndate":{"date":1,"hours":0,"seconds":0,"month":8,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535731200000,"day":6},"equip_snum":0,"file_id":null,"equip_manu":"???????","equip_pdate":{"date":23,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534953600000,"day":4},"equip_life":20,"equip_memo":"???????","equip_qrcode":"","equip_bfee":2000,"user":null,"equip_room":null,"equip_type":null},{"equip_mdate":20,"equip_isdeleted":0,"equip_name":"????????","equip_no":"????????","equip_udate":{"date":24,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535040000000,"day":5},"equip_state":0,"equip_tel":"13255555555","equip_id":3,"equip_atime":0,"equip_num":"????????","equip_ndate":{"date":30,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535558400000,"day":4},"equip_snum":0,"file_id":null,"equip_manu":"????????","equip_pdate":{"date":23,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534953600000,"day":4},"equip_life":20,"equip_memo":"","equip_qrcode":"","equip_bfee":2000,"user":null,"equip_room":null,"equip_type":null},{"equip_mdate":20,"equip_isdeleted":0,"equip_name":"???????","equip_no":"???????","equip_udate":{"date":16,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534348800000,"day":4},"equip_state":0,"equip_tel":"13255555555","equip_id":2,"equip_atime":0,"equip_num":"???????","equip_ndate":{"date":30,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535558400000,"day":4},"equip_snum":20180505,"file_id":null,"equip_manu":"???????","equip_pdate":{"date":15,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534262400000,"day":3},"equip_life":20,"equip_memo":"???????","equip_qrcode":"","equip_bfee":2000,"user":null,"equip_room":null,"equip_type":null},{"equip_mdate":1,"equip_isdeleted":0,"equip_name":"???","equip_no":"???","equip_udate":{"date":17,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534435200000,"day":5},"equip_state":0,"equip_tel":"13255555555","equip_id":1,"equip_atime":0,"equip_num":"???","equip_ndate":{"date":1,"hours":0,"seconds":0,"month":8,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535731200000,"day":6},"equip_snum":20180505,"file_id":null,"equip_manu":"??","equip_pdate":{"date":16,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534348800000,"day":4},"equip_life":20,"equip_memo":"????????????","equip_qrcode":"","equip_bfee":20000,"user":null,"equip_room":null,"equip_type":null}]
     * totalPage : 1
     */

    private int totalPage;
    private List<ListBean> list;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }

    public static class ListBean implements Serializable{
        /**
         * equip_mdate : 20
         * equip_isdeleted : 0
         * equip_name : ?????
         * equip_no : ?????
         * equip_udate : {"date":31,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535644800000,"day":5}
         * equip_state : 0
         * equip_tel : 13255555555
         * equip_id : 7
         * equip_atime : 0
         * equip_num : ?????
         * equip_ndate : {"date":7,"hours":0,"seconds":0,"month":8,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1536249600000,"day":5}
         * equip_snum : 0
         * file_id : null
         * equip_manu : ?????
         * equip_pdate : {"date":24,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535040000000,"day":5}
         * equip_life : 24
         * equip_memo :
         * equip_qrcode :
         * equip_bfee : 24
         * user : null
         * equip_room : null
         * equip_type : null
         */

        private int equip_mdate;
        private int equip_isdeleted;
        private String equip_name;
        private String equip_no;
        private EquipUdateBean equip_udate;//
        private int equip_state;
        private String equip_tel;
        private int equip_id;
        private int equip_atime;
        private String equip_num;
        private EquipNdateBean equip_ndate;//
        private int equip_snum;
        private Object file_id;
        private String equip_manu;
        private EquipPdateBean equip_pdate;//
        private int equip_life;
        private String equip_memo;
        private String equip_qrcode;
        private int equip_bfee;
        private Object user;
        private Object equip_room;
        private Object equip_type;

        public int getEquip_mdate() {
            return equip_mdate;
        }

        public void setEquip_mdate(int equip_mdate) {
            this.equip_mdate = equip_mdate;
        }

        public int getEquip_isdeleted() {
            return equip_isdeleted;
        }

        public void setEquip_isdeleted(int equip_isdeleted) {
            this.equip_isdeleted = equip_isdeleted;
        }

        public String getEquip_name() {
            return equip_name;
        }

        public void setEquip_name(String equip_name) {
            this.equip_name = equip_name;
        }

        public String getEquip_no() {
            return equip_no;
        }

        public void setEquip_no(String equip_no) {
            this.equip_no = equip_no;
        }

        public EquipUdateBean getEquip_udate() {
            return equip_udate;
        }

        public void setEquip_udate(EquipUdateBean equip_udate) {
            this.equip_udate = equip_udate;
        }

        public int getEquip_state() {
            return equip_state;
        }

        public void setEquip_state(int equip_state) {
            this.equip_state = equip_state;
        }

        public String getEquip_tel() {
            return equip_tel;
        }

        public void setEquip_tel(String equip_tel) {
            this.equip_tel = equip_tel;
        }

        public int getEquip_id() {
            return equip_id;
        }

        public void setEquip_id(int equip_id) {
            this.equip_id = equip_id;
        }

        public int getEquip_atime() {
            return equip_atime;
        }

        public void setEquip_atime(int equip_atime) {
            this.equip_atime = equip_atime;
        }

        public String getEquip_num() {
            return equip_num;
        }

        public void setEquip_num(String equip_num) {
            this.equip_num = equip_num;
        }

        public EquipNdateBean getEquip_ndate() {
            return equip_ndate;
        }

        public void setEquip_ndate(EquipNdateBean equip_ndate) {
            this.equip_ndate = equip_ndate;
        }

        public int getEquip_snum() {
            return equip_snum;
        }

        public void setEquip_snum(int equip_snum) {
            this.equip_snum = equip_snum;
        }

        public Object getFile_id() {
            return file_id;
        }

        public void setFile_id(Object file_id) {
            this.file_id = file_id;
        }

        public String getEquip_manu() {
            return equip_manu;
        }

        public void setEquip_manu(String equip_manu) {
            this.equip_manu = equip_manu;
        }

        public EquipPdateBean getEquip_pdate() {
            return equip_pdate;
        }

        public void setEquip_pdate(EquipPdateBean equip_pdate) {
            this.equip_pdate = equip_pdate;
        }

        public int getEquip_life() {
            return equip_life;
        }

        public void setEquip_life(int equip_life) {
            this.equip_life = equip_life;
        }

        public String getEquip_memo() {
            return equip_memo;
        }

        public void setEquip_memo(String equip_memo) {
            this.equip_memo = equip_memo;
        }

        public String getEquip_qrcode() {
            return equip_qrcode;
        }

        public void setEquip_qrcode(String equip_qrcode) {
            this.equip_qrcode = equip_qrcode;
        }

        public int getEquip_bfee() {
            return equip_bfee;
        }

        public void setEquip_bfee(int equip_bfee) {
            this.equip_bfee = equip_bfee;
        }

        public Object getUser() {
            return user;
        }

        public void setUser(Object user) {
            this.user = user;
        }

        public Object getEquip_room() {
            return equip_room;
        }

        public void setEquip_room(Object equip_room) {
            this.equip_room = equip_room;
        }

        public Object getEquip_type() {
            return equip_type;
        }

        public void setEquip_type(Object equip_type) {
            this.equip_type = equip_type;
        }

        public static class EquipUdateBean implements Serializable {
            /**
             * date : 31
             * hours : 0
             * seconds : 0
             * month : 7
             * nanos : 0
             * timezoneOffset : -480
             * year : 118
             * minutes : 0
             * time : 1535644800000
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

        public static class EquipNdateBean implements Serializable{
            /**
             * date : 7
             * hours : 0
             * seconds : 0
             * month : 8
             * nanos : 0
             * timezoneOffset : -480
             * year : 118
             * minutes : 0
             * time : 1536249600000
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

        public static class EquipPdateBean implements Serializable{
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
    }
}
