package project.wy.com.myappdemo.untils;

/**
 * @Description 常量配置
 * @Author 一花一世界
 */

public class Constant {

    public static final String LOG_TAG = "logTag";

//    public static final String APP_KEY = "9e1ddc430a01b3f58299d95ced43da89";

    public static final int SUCCESS = 0X101;
    public static final int FAILURE = 0X102;

    public static final String QUEST_ALL_DEVICE = "http://116.62.186.91:8080/gywyext/equipEquipment/getEquipmentListByPage.do"; //根据页数获取设备信息
    public static final String QUEST_DEVICE_RUN_INFO = "http://116.62.186.91:8080/gywyext/equipRealInfo/getEquipRealDataByTime.do"; //根据设备id查找设备运行信息
    public static final String QUEST_DEVICE_PRAMS = "http://116.62.186.91:8080/gywyext/equipRealInfo/getEquipPara.do";//根据设备id查找设备特征参数
    public static final String QUEST_DEVICE_STATE = "http://116.62.186.91:8080/gywyext/equipRealInfo/getEquipRealData.do";//根据设备参数id获取实时数据
     public static final String QUEST_DEVICE_INFO = "http://116.62.186.91:8080/gywyext/equipEquipment/selectEquipmentById.do";//根据id获取设备信息
     public static final String ADD_WARNING_INFO = "http://116.62.186.91:8080/gywyext/moblieAdd/addAlarm.do";//根据id获取设备信息
     public static final String QUEST_COMP_INFO = " http://116.62.186.91:8080/gywyext/systemProject/getCompanyInfo.do";//公司信息

    public static final String  QUEST_PRO_INFO = "http://116.62.186.91:8080/gywyext/systemProject/getProjectInfo.do?";//项目信息
}
