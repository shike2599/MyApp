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
     public static final String ADD_WARNING_INFO = "http://116.62.186.91:8080/gywyext/moblieAdd/addAlarm.do";//添加提示信息
     public static final String QUEST_COMP_INFO = " http://116.62.186.91:8080/gywyext/systemProject/getCompanyInfo.do";//公司信息

    public static final String  QUEST_PRO_INFO = "http://116.62.186.91:8080/gywyext/systemProject/getProjectInfo.do?";//项目信息
    public static final String  ADD_RUNNING_INFO= "http://116.62.186.91:8080/gywyext/moblieAdd/addOpeartion.do";//手动输入项目信息
    public static final String  QUEST_MAINTEN_INFO = "http://116.62.186.91:8080/gywyext/moblieAdd/getmaintenance.do";//维保信息
    public static final String  QUEST_MAINTEN_BYID_INFO = "http://116.62.186.91:8080/gywyext/moblieAdd/getMaintenanceById.do";//维保信息

    public static final String QUEST_SUB_PRO_INFO = "http://116.62.186.91:8080/gywyext/moblieAdd/getInitLeft.do";

    public static final String  QUEST_DEVCE_PRAMS_INFO = "http://116.62.186.91:8080/gywyext/moblieAdd/getParaById.do";//获取设备特征参数信息
    public static final String  QUEST_DEVCE_BY_PROJ = "http://116.62.186.91:8080/gywyext/moblieAdd/selectBaseInfoByProj.do";//获取项目拿到设备信息
    public static final String  QUEST_DEVCE_BY_NAME_OR_EID  = "http://116.62.186.91:8080/gywyext/moblieAdd/selectEquipByName.do";//根据设备id或名称拿到设备信息
    public static final String  ACCESSTOKE = "at.30044dhi5s2d15d08mw7z74bc4ns7f2e-26j1yzulkw-07sz3po-5vnhl0hnd";//萤石云toke
    public static final String  APP_KEY = "ca8ff88d26034fa69dd42af5e333fcc9";//萤石云toke
    public static final String  QUEST_AlARM_BY_PROID = "http://116.62.186.91:8080/gywyext/moblieAdd/selectAlarmByA.do";//根据项目拿到报警信息
    public static final String  QUEST_OVERMAINT_BY_PROID = "http://116.62.186.91:8080/gywyext/moblieAdd/selectEquipmentByN.do";
    public static final String  QUEST_HEASTA_BY_PROID = "http://116.62.186.91:8080/gywyext/moblieAdd/selectEquipmentByS.do";
    public static final String  QUEST_WARNING_NES_BY_PROID = "http://116.62.186.91:8080/gywyext/alarmLog/getAlarmListByPage.do";//根据项目获取报警信息

}
