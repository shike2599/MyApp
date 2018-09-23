package project.wy.com.myappdemo.bean;

import java.io.Serializable;

/**
 * Created by lichee on 2018/9/23.
 */

public  class FileIdBean implements Serializable {
    /**
     * file_path : D:\Tomcat7.0\webapps\gywyext\picture\8b2187ecec4d28820180923110257542.jpg
     * file_isdelete : 0
     * file_ctime : {"date":23,"hours":23,"seconds":57,"month":8,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":2,"time":1537714977000,"day":0}
     * file_name : 8b2187ecec4d288.jpg
     * file_type : jpg
     * file_id : 3
     */

    private String file_path;
    private int file_isdelete;
    private FileCtimeBean file_ctime;
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

    public FileCtimeBean getFile_ctime() {
        return file_ctime;
    }

    public void setFile_ctime(FileCtimeBean file_ctime) {
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

    public static class FileCtimeBean implements Serializable{
        /**
         * date : 23
         * hours : 23
         * seconds : 57
         * month : 8
         * nanos : 0
         * timezoneOffset : -480
         * year : 118
         * minutes : 2
         * time : 1537714977000
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

