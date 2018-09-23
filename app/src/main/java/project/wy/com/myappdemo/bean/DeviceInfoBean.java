package project.wy.com.myappdemo.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by lichee on 2018/9/23.
 */

public class DeviceInfoBean implements Serializable{

    /**
     * list : [{"equip_mdate":20,"equip_isdeleted":0,"equip_name":"?????","equip_no":"?????","equip_udate":{"date":31,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535644800000,"day":5},"equip_state":0,"equip_tel":"13255555555","equip_id":7,"equip_atime":0,"equip_num":"?????","equip_ndate":{"date":7,"hours":0,"seconds":0,"month":8,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1536249600000,"day":5},"equip_snum":0,"file_id":null,"equip_manu":"?????","equip_pdate":{"date":24,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535040000000,"day":5},"equip_life":24,"equip_memo":"","equip_qrcode":"","equip_bfee":24,"user":null,"equip_room":null,"equip_type":null},{"equip_mdate":12,"equip_isdeleted":0,"equip_name":"??????","equip_no":"??????","equip_udate":{"date":31,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535644800000,"day":5},"equip_state":0,"equip_tel":"13255555555","equip_id":6,"equip_atime":0,"equip_num":"??????","equip_ndate":{"date":7,"hours":0,"seconds":0,"month":8,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1536249600000,"day":5},"equip_snum":0,"file_id":null,"equip_manu":"??????","equip_pdate":{"date":22,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534867200000,"day":3},"equip_life":20,"equip_memo":"","equip_qrcode":"","equip_bfee":32,"user":null,"equip_room":null,"equip_type":null},{"equip_mdate":20,"equip_isdeleted":0,"equip_name":"???????","equip_no":"???????","equip_udate":{"date":24,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535040000000,"day":5},"equip_state":0,"equip_tel":"13255555555","equip_id":5,"equip_atime":0,"equip_num":"???????","equip_ndate":{"date":31,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535644800000,"day":5},"equip_snum":0,"file_id":null,"equip_manu":"???????","equip_pdate":{"date":23,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534953600000,"day":4},"equip_life":20,"equip_memo":"","equip_qrcode":"","equip_bfee":20,"user":null,"equip_room":null,"equip_type":null},{"equip_mdate":20,"equip_isdeleted":0,"equip_name":"???????","equip_no":"???????","equip_udate":{"date":24,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535040000000,"day":5},"equip_state":0,"equip_tel":"13255555555","equip_id":4,"equip_atime":0,"equip_num":"???????","equip_ndate":{"date":1,"hours":0,"seconds":0,"month":8,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535731200000,"day":6},"equip_snum":0,"file_id":null,"equip_manu":"???????","equip_pdate":{"date":23,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534953600000,"day":4},"equip_life":20,"equip_memo":"???????","equip_qrcode":"","equip_bfee":2000,"user":null,"equip_room":null,"equip_type":null},{"equip_mdate":20,"equip_isdeleted":0,"equip_name":"????????","equip_no":"????????","equip_udate":{"date":24,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535040000000,"day":5},"equip_state":0,"equip_tel":"13255555555","equip_id":3,"equip_atime":0,"equip_num":"????????","equip_ndate":{"date":30,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535558400000,"day":4},"equip_snum":0,"file_id":null,"equip_manu":"????????","equip_pdate":{"date":23,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534953600000,"day":4},"equip_life":20,"equip_memo":"","equip_qrcode":"","equip_bfee":2000,"user":null,"equip_room":null,"equip_type":null},{"equip_mdate":20,"equip_isdeleted":0,"equip_name":"???????","equip_no":"???????","equip_udate":{"date":16,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534348800000,"day":4},"equip_state":0,"equip_tel":"13255555555","equip_id":2,"equip_atime":0,"equip_num":"???????","equip_ndate":{"date":30,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535558400000,"day":4},"equip_snum":20180505,"file_id":null,"equip_manu":"???????","equip_pdate":{"date":15,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534262400000,"day":3},"equip_life":20,"equip_memo":"???????","equip_qrcode":"","equip_bfee":2000,"user":null,"equip_room":null,"equip_type":null},{"equip_mdate":1,"equip_isdeleted":0,"equip_name":"???","equip_no":"???","equip_udate":{"date":17,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534435200000,"day":5},"equip_state":0,"equip_tel":"13255555555","equip_id":1,"equip_atime":0,"equip_num":"???","equip_ndate":{"date":1,"hours":0,"seconds":0,"month":8,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1535731200000,"day":6},"equip_snum":20180505,"file_id":null,"equip_manu":"??","equip_pdate":{"date":16,"hours":0,"seconds":0,"month":7,"nanos":0,"timezoneOffset":-480,"year":118,"minutes":0,"time":1534348800000,"day":4},"equip_life":20,"equip_memo":"????????????","equip_qrcode":"","equip_bfee":20000,"user":null,"equip_room":null,"equip_type":null}]
     * totalPage : 1
     */

    private int totalPage;
    private List<EquipmentBean> list;

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<EquipmentBean> getList() {
        return list;
    }

    public void setList(List<EquipmentBean> list) {
        this.list = list;
    }


}
