package project.wy.com.myappdemo.bean;

import java.io.Serializable;

/**
 * Created by lichee on 2019/7/30.
 */

public  class EquipParaBean implements Serializable{
    /**
     * equip_para_unit :
     * equip_para_max : 0
     * equip_para_rate : 0
     * equip_para_min : 0
     * equip_para_isdeleted : 0
     * equip_para_name : ??????
     * equipment : {"equip_mdate":500,"flag":0,"equip_isdeleted":0,"equip_name":"??????????","equip_no":"DT","equip_udate":{"date":17,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534435200000,"day":5},"equip_state":10,"equip_tel":"13509163555","equip_id":13,"equip_atime":0,"equip_num":"DT","equip_ndate":{"date":30,"hours":17,"seconds":18,"month":6,"nanos":0,"timezoneOffset":-480,"year":119,"minutes":8,"time":1564477698000,"day":2},"equip_snum":1121013710,"file_id":{"file_path":"D:\\Tomcat7.0\\webapps\\gywyext\\picture\\20181014091421643.jpg","file_isdelete":0,"file_ctime":{"date":14,"hours":21,"seconds":21,"month":9,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":14,"time":1539522861000,"day":0},"file_name":"????.jpg","file_type":"jpg","file_id":8},"equip_manu":"","equip_pdate":{"date":16,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534348800000,"day":4},"equip_life":0,"equip_memo":"","equip_qrcode":"","equip_bfee":0,"user":{"user_isdeleted":0,"user_email":"1525412547@163.com","role":{"role_name":"???","role_id":1,"role_isdeleted":0,"role_permission":"{\"systemleft_per\":[1,1,1,1,1],\"comp_per\":[1,1,1,0,0],\"proj_per\":[1,1,1,0,0],\"room_per\":[1,1,1,0,0],\"user_per\":[1,1,1,1,0],\"role_per\":[1,1,1,0,0],\"equip_per\":[1,1,1,0,0],\"cam_per\":[1,1,1,0,0]}"},"user_acct":"admin","user_id":1,"user_tel":"15623125452","user_name":"???","user_pwd":"E10ADC3949BA59ABBE56E057F20F883E"},"equip_room":{"equip_room_id":3,"equip_room_name":"??????","equip_room_isdeleted":0,"equip_room_site":"","project":{"proj_isdeleted":0,"proj_num":2000,"proj_memo":"[113.3,24.3]","proj_rank":"5","proj_addr":"??????","proj_name":"??????","company":{"comp_rank":"","comp_isdeleted":0,"comp_addr":"??????","comp_name":"???????","comp_memo":"????????","comp_num":100,"comp_id":1,"user":null},"proj_gate":"00000001","proj_id":2,"user":null},"equip_room_memo":""},"equip_type":"??"}
     * equip_para_memo : ????????????
     * equip_para_id : 33
     */

    private String equip_para_unit;
    private float equip_para_max;
    private float equip_para_rate;
    private float equip_para_min;
    private int equip_para_isdeleted;
    private String equip_para_name;
    private EquipmentBeanX equipment;
    private String equip_para_memo;
    private int equip_para_id;

    public String getEquip_para_unit() {
        return equip_para_unit;
    }

    public void setEquip_para_unit(String equip_para_unit) {
        this.equip_para_unit = equip_para_unit;
    }

    public float getEquip_para_max() {
        return equip_para_max;
    }

    public void setEquip_para_max(int equip_para_max) {
        this.equip_para_max = equip_para_max;
    }

    public float getEquip_para_rate() {
        return equip_para_rate;
    }

    public void setEquip_para_rate(int equip_para_rate) {
        this.equip_para_rate = equip_para_rate;
    }

    public float getEquip_para_min() {
        return equip_para_min;
    }

    public void setEquip_para_min(int equip_para_min) {
        this.equip_para_min = equip_para_min;
    }

    public int getEquip_para_isdeleted() {
        return equip_para_isdeleted;
    }

    public void setEquip_para_isdeleted(int equip_para_isdeleted) {
        this.equip_para_isdeleted = equip_para_isdeleted;
    }

    public String getEquip_para_name() {
        return equip_para_name;
    }

    public void setEquip_para_name(String equip_para_name) {
        this.equip_para_name = equip_para_name;
    }

    public EquipmentBeanX getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentBeanX equipment) {
        this.equipment = equipment;
    }

    public String getEquip_para_memo() {
        return equip_para_memo;
    }

    public void setEquip_para_memo(String equip_para_memo) {
        this.equip_para_memo = equip_para_memo;
    }

    public int getEquip_para_id() {
        return equip_para_id;
    }

    public void setEquip_para_id(int equip_para_id) {
        this.equip_para_id = equip_para_id;
    }

    public static class EquipmentBeanX implements Serializable{
        /**
         * equip_mdate : 500
         * flag : 0
         * equip_isdeleted : 0
         * equip_name : ??????????
         * equip_no : DT
         * equip_udate : {"date":17,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534435200000,"day":5}
         * equip_state : 10
         * equip_tel : 13509163555
         * equip_id : 13
         * equip_atime : 0
         * equip_num : DT
         * equip_ndate : {"date":30,"hours":17,"seconds":18,"month":6,"nanos":0,"timezoneOffset":-480,"year":119,"minutes":8,"time":1564477698000,"day":2}
         * equip_snum : 1121013710
         * file_id : {"file_path":"D:\\Tomcat7.0\\webapps\\gywyext\\picture\\20181014091421643.jpg","file_isdelete":0,"file_ctime":{"date":14,"hours":21,"seconds":21,"month":9,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":14,"time":1539522861000,"day":0},"file_name":"????.jpg","file_type":"jpg","file_id":8}
         * equip_manu :
         * equip_pdate : {"date":16,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534348800000,"day":4}
         * equip_life : 0
         * equip_memo :
         * equip_qrcode :
         * equip_bfee : 0
         * user : {"user_isdeleted":0,"user_email":"1525412547@163.com","role":{"role_name":"???","role_id":1,"role_isdeleted":0,"role_permission":"{\"systemleft_per\":[1,1,1,1,1],\"comp_per\":[1,1,1,0,0],\"proj_per\":[1,1,1,0,0],\"room_per\":[1,1,1,0,0],\"user_per\":[1,1,1,1,0],\"role_per\":[1,1,1,0,0],\"equip_per\":[1,1,1,0,0],\"cam_per\":[1,1,1,0,0]}"},"user_acct":"admin","user_id":1,"user_tel":"15623125452","user_name":"???","user_pwd":"E10ADC3949BA59ABBE56E057F20F883E"}
         * equip_room : {"equip_room_id":3,"equip_room_name":"??????","equip_room_isdeleted":0,"equip_room_site":"","project":{"proj_isdeleted":0,"proj_num":2000,"proj_memo":"[113.3,24.3]","proj_rank":"5","proj_addr":"??????","proj_name":"??????","company":{"comp_rank":"","comp_isdeleted":0,"comp_addr":"??????","comp_name":"???????","comp_memo":"????????","comp_num":100,"comp_id":1,"user":null},"proj_gate":"00000001","proj_id":2,"user":null},"equip_room_memo":""}
         * equip_type : ??
         */

        private int equip_mdate;
        private int flag;
        private int equip_isdeleted;
        private String equip_name;
        private String equip_no;
        private EquipUdateBeanX equip_udate;
        private int equip_state;
        private String equip_tel;
        private int equip_id;
        private int equip_atime;
        private String equip_num;
        private EquipNdateBeanX equip_ndate;
        private int equip_snum;
        private FileIdBeanX file_id;
        private String equip_manu;
        private EquipPdateBeanX equip_pdate;
        private int equip_life;
        private String equip_memo;
        private String equip_qrcode;
        private int equip_bfee;
        private UserBeanX user;
        private EquipRoomBeanX equip_room;
        private String equip_type;

        public int getEquip_mdate() {
            return equip_mdate;
        }

        public void setEquip_mdate(int equip_mdate) {
            this.equip_mdate = equip_mdate;
        }

        public int getFlag() {
            return flag;
        }

        public void setFlag(int flag) {
            this.flag = flag;
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

        public EquipUdateBeanX getEquip_udate() {
            return equip_udate;
        }

        public void setEquip_udate(EquipUdateBeanX equip_udate) {
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

        public EquipNdateBeanX getEquip_ndate() {
            return equip_ndate;
        }

        public void setEquip_ndate(EquipNdateBeanX equip_ndate) {
            this.equip_ndate = equip_ndate;
        }

        public int getEquip_snum() {
            return equip_snum;
        }

        public void setEquip_snum(int equip_snum) {
            this.equip_snum = equip_snum;
        }

        public FileIdBeanX getFile_id() {
            return file_id;
        }

        public void setFile_id(FileIdBeanX file_id) {
            this.file_id = file_id;
        }

        public String getEquip_manu() {
            return equip_manu;
        }

        public void setEquip_manu(String equip_manu) {
            this.equip_manu = equip_manu;
        }

        public EquipPdateBeanX getEquip_pdate() {
            return equip_pdate;
        }

        public void setEquip_pdate(EquipPdateBeanX equip_pdate) {
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

        public UserBeanX getUser() {
            return user;
        }

        public void setUser(UserBeanX user) {
            this.user = user;
        }

        public EquipRoomBeanX getEquip_room() {
            return equip_room;
        }

        public void setEquip_room(EquipRoomBeanX equip_room) {
            this.equip_room = equip_room;
        }

        public String getEquip_type() {
            return equip_type;
        }

        public void setEquip_type(String equip_type) {
            this.equip_type = equip_type;
        }

        public static class EquipUdateBeanX implements Serializable {
            /**
             * date : 17
             * hours : 0
             * seconds : 0
             * month : 7
             * nanos : 0
             * timezoneOffset : -480
             * year : 118
             * minutes : 0
             * time : 1534435200000
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

        public static class EquipNdateBeanX {
            /**
             * date : 30
             * hours : 17
             * seconds : 18
             * month : 6
             * nanos : 0
             * timezoneOffset : -480
             * year : 119
             * minutes : 8
             * time : 1564477698000
             * day : 2
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

        public static class FileIdBeanX {
            /**
             * file_path : D:\Tomcat7.0\webapps\gywyext\picture\20181014091421643.jpg
             * file_isdelete : 0
             * file_ctime : {"date":14,"hours":21,"seconds":21,"month":9,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":14,"time":1539522861000,"day":0}
             * file_name : ????.jpg
             * file_type : jpg
             * file_id : 8
             */

            private String file_path;
            private int file_isdelete;
            private FileCtimeBeanX file_ctime;
            private String file_name;
            private String file_type;
            private int file_id;

            public String getFile_path() {
                return file_path;
            }

            public void setFile_path(String file_path) {
                this.file_path = file_path;
            }

            public int getFile_isdelete() {
                return file_isdelete;
            }

            public void setFile_isdelete(int file_isdelete) {
                this.file_isdelete = file_isdelete;
            }

            public FileCtimeBeanX getFile_ctime() {
                return file_ctime;
            }

            public void setFile_ctime(FileCtimeBeanX file_ctime) {
                this.file_ctime = file_ctime;
            }

            public String getFile_name() {
                return file_name;
            }

            public void setFile_name(String file_name) {
                this.file_name = file_name;
            }

            public String getFile_type() {
                return file_type;
            }

            public void setFile_type(String file_type) {
                this.file_type = file_type;
            }

            public int getFile_id() {
                return file_id;
            }

            public void setFile_id(int file_id) {
                this.file_id = file_id;
            }

            public static class FileCtimeBeanX {
                /**
                 * date : 14
                 * hours : 21
                 * seconds : 21
                 * month : 9
                 * nanos : 0
                 * timezoneOffset : -480
                 * year : 118
                 * minutes : 14
                 * time : 1539522861000
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

        public static class EquipPdateBeanX {
            /**
             * date : 16
             * hours : 0
             * seconds : 0
             * month : 7
             * nanos : 0
             * timezoneOffset : -480
             * year : 118
             * minutes : 0
             * time : 1534348800000
             * day : 4
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

        public static class UserBeanX {
            /**
             * user_isdeleted : 0
             * user_email : 1525412547@163.com
             * role : {"role_name":"???","role_id":1,"role_isdeleted":0,"role_permission":"{\"systemleft_per\":[1,1,1,1,1],\"comp_per\":[1,1,1,0,0],\"proj_per\":[1,1,1,0,0],\"room_per\":[1,1,1,0,0],\"user_per\":[1,1,1,1,0],\"role_per\":[1,1,1,0,0],\"equip_per\":[1,1,1,0,0],\"cam_per\":[1,1,1,0,0]}"}
             * user_acct : admin
             * user_id : 1
             * user_tel : 15623125452
             * user_name : ???
             * user_pwd : E10ADC3949BA59ABBE56E057F20F883E
             */

            private int user_isdeleted;
            private String user_email;
            private RoleBeanX role;
            private String user_acct;
            private int user_id;
            private String user_tel;
            private String user_name;
            private String user_pwd;

            public int getUser_isdeleted() {
                return user_isdeleted;
            }

            public void setUser_isdeleted(int user_isdeleted) {
                this.user_isdeleted = user_isdeleted;
            }

            public String getUser_email() {
                return user_email;
            }

            public void setUser_email(String user_email) {
                this.user_email = user_email;
            }

            public RoleBeanX getRole() {
                return role;
            }

            public void setRole(RoleBeanX role) {
                this.role = role;
            }

            public String getUser_acct() {
                return user_acct;
            }

            public void setUser_acct(String user_acct) {
                this.user_acct = user_acct;
            }

            public int getUser_id() {
                return user_id;
            }

            public void setUser_id(int user_id) {
                this.user_id = user_id;
            }

            public String getUser_tel() {
                return user_tel;
            }

            public void setUser_tel(String user_tel) {
                this.user_tel = user_tel;
            }

            public String getUser_name() {
                return user_name;
            }

            public void setUser_name(String user_name) {
                this.user_name = user_name;
            }

            public String getUser_pwd() {
                return user_pwd;
            }

            public void setUser_pwd(String user_pwd) {
                this.user_pwd = user_pwd;
            }

            public static class RoleBeanX {
                /**
                 * role_name : ???
                 * role_id : 1
                 * role_isdeleted : 0
                 * role_permission : {"systemleft_per":[1,1,1,1,1],"comp_per":[1,1,1,0,0],"proj_per":[1,1,1,0,0],"room_per":[1,1,1,0,0],"user_per":[1,1,1,1,0],"role_per":[1,1,1,0,0],"equip_per":[1,1,1,0,0],"cam_per":[1,1,1,0,0]}
                 */

                private String role_name;
                private int role_id;
                private int role_isdeleted;
                private String role_permission;

                public String getRole_name() {
                    return role_name;
                }

                public void setRole_name(String role_name) {
                    this.role_name = role_name;
                }

                public int getRole_id() {
                    return role_id;
                }

                public void setRole_id(int role_id) {
                    this.role_id = role_id;
                }

                public int getRole_isdeleted() {
                    return role_isdeleted;
                }

                public void setRole_isdeleted(int role_isdeleted) {
                    this.role_isdeleted = role_isdeleted;
                }

                public String getRole_permission() {
                    return role_permission;
                }

                public void setRole_permission(String role_permission) {
                    this.role_permission = role_permission;
                }
            }
        }

        public static class EquipRoomBeanX {
            /**
             * equip_room_id : 3
             * equip_room_name : ??????
             * equip_room_isdeleted : 0
             * equip_room_site :
             * project : {"proj_isdeleted":0,"proj_num":2000,"proj_memo":"[113.3,24.3]","proj_rank":"5","proj_addr":"??????","proj_name":"??????","company":{"comp_rank":"","comp_isdeleted":0,"comp_addr":"??????","comp_name":"???????","comp_memo":"????????","comp_num":100,"comp_id":1,"user":null},"proj_gate":"00000001","proj_id":2,"user":null}
             * equip_room_memo :
             */

            private int equip_room_id;
            private String equip_room_name;
            private int equip_room_isdeleted;
            private String equip_room_site;
            private ProjectBeanX project;
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

            public String getEquip_room_site() {
                return equip_room_site;
            }

            public void setEquip_room_site(String equip_room_site) {
                this.equip_room_site = equip_room_site;
            }

            public ProjectBeanX getProject() {
                return project;
            }

            public void setProject(ProjectBeanX project) {
                this.project = project;
            }

            public String getEquip_room_memo() {
                return equip_room_memo;
            }

            public void setEquip_room_memo(String equip_room_memo) {
                this.equip_room_memo = equip_room_memo;
            }

            public static class ProjectBeanX {
                /**
                 * proj_isdeleted : 0
                 * proj_num : 2000
                 * proj_memo : [113.3,24.3]
                 * proj_rank : 5
                 * proj_addr : ??????
                 * proj_name : ??????
                 * company : {"comp_rank":"","comp_isdeleted":0,"comp_addr":"??????","comp_name":"???????","comp_memo":"????????","comp_num":100,"comp_id":1,"user":null}
                 * proj_gate : 00000001
                 * proj_id : 2
                 * user : null
                 */

                private int proj_isdeleted;
                private int proj_num;
                private String proj_memo;
                private String proj_rank;
                private String proj_addr;
                private String proj_name;
                private CompanyBeanX company;
                private String proj_gate;
                private int proj_id;
                private Object user;

                public int getProj_isdeleted() {
                    return proj_isdeleted;
                }

                public void setProj_isdeleted(int proj_isdeleted) {
                    this.proj_isdeleted = proj_isdeleted;
                }

                public int getProj_num() {
                    return proj_num;
                }

                public void setProj_num(int proj_num) {
                    this.proj_num = proj_num;
                }

                public String getProj_memo() {
                    return proj_memo;
                }

                public void setProj_memo(String proj_memo) {
                    this.proj_memo = proj_memo;
                }

                public String getProj_rank() {
                    return proj_rank;
                }

                public void setProj_rank(String proj_rank) {
                    this.proj_rank = proj_rank;
                }

                public String getProj_addr() {
                    return proj_addr;
                }

                public void setProj_addr(String proj_addr) {
                    this.proj_addr = proj_addr;
                }

                public String getProj_name() {
                    return proj_name;
                }

                public void setProj_name(String proj_name) {
                    this.proj_name = proj_name;
                }

                public CompanyBeanX getCompany() {
                    return company;
                }

                public void setCompany(CompanyBeanX company) {
                    this.company = company;
                }

                public String getProj_gate() {
                    return proj_gate;
                }

                public void setProj_gate(String proj_gate) {
                    this.proj_gate = proj_gate;
                }

                public int getProj_id() {
                    return proj_id;
                }

                public void setProj_id(int proj_id) {
                    this.proj_id = proj_id;
                }

                public Object getUser() {
                    return user;
                }

                public void setUser(Object user) {
                    this.user = user;
                }

                public static class CompanyBeanX {
                    /**
                     * comp_rank :
                     * comp_isdeleted : 0
                     * comp_addr : ??????
                     * comp_name : ???????
                     * comp_memo : ????????
                     * comp_num : 100
                     * comp_id : 1
                     * user : null
                     */

                    private String comp_rank;
                    private int comp_isdeleted;
                    private String comp_addr;
                    private String comp_name;
                    private String comp_memo;
                    private int comp_num;
                    private int comp_id;
                    private Object user;

                    public String getComp_rank() {
                        return comp_rank;
                    }

                    public void setComp_rank(String comp_rank) {
                        this.comp_rank = comp_rank;
                    }

                    public int getComp_isdeleted() {
                        return comp_isdeleted;
                    }

                    public void setComp_isdeleted(int comp_isdeleted) {
                        this.comp_isdeleted = comp_isdeleted;
                    }

                    public String getComp_addr() {
                        return comp_addr;
                    }

                    public void setComp_addr(String comp_addr) {
                        this.comp_addr = comp_addr;
                    }

                    public String getComp_name() {
                        return comp_name;
                    }

                    public void setComp_name(String comp_name) {
                        this.comp_name = comp_name;
                    }

                    public String getComp_memo() {
                        return comp_memo;
                    }

                    public void setComp_memo(String comp_memo) {
                        this.comp_memo = comp_memo;
                    }

                    public int getComp_num() {
                        return comp_num;
                    }

                    public void setComp_num(int comp_num) {
                        this.comp_num = comp_num;
                    }

                    public int getComp_id() {
                        return comp_id;
                    }

                    public void setComp_id(int comp_id) {
                        this.comp_id = comp_id;
                    }

                    public Object getUser() {
                        return user;
                    }

                    public void setUser(Object user) {
                        this.user = user;
                    }
                }
            }
        }
    }
}