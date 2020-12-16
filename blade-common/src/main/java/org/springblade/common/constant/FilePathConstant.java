package org.springblade.common.constant;

/**
 * 安标文件物理路径以及相关常量
 *
 * @ClassName FilePathConstant
 * @Author 呵呵哒
 **/
public interface FilePathConstant {

    /**
     * 递归路径存取 默认上级id
     */
    Integer DEFAULT_PARENT_ID = 0;

    /**
     * 递归路径存取 默认层级
     */
    String DEFAULT_TIER = "0";

    /**
     * 模板单位名称
     */
    String MUBAN_DEPT_NAME = "安全管理平台";

    /**
     * 文件存取根目录路径
     */
//    String ROOT_PATH = "D:\\anbiao3.0\\FileManagement\\webapps\\FileManager\\static\\SafetyStandards\\";
    //String ROOT_PATH = "D:\\apache-tomcat-7.0.82\\webapps\\FileManager\\static\\SafetyStandards\\";
//	String ROOT_PATH = "SafetyStandards\\";

    /**
     * url前缀
     */
//    String ROOT_URL = "http://202.100.168.150:8203/FileManager/static/SafetyStandards/";
    //String ROOT_URL = "http://192.168.18.131:8080/FileManager/static/SafetyStandards/";
//	String ROOT_URL = "SafetyStandards/";

    /**
     * 标准化模板临时文件路径
     */
    String UPLOAD_TEMP_PATH = "SafetyStandards\\标准化相关文件\\临时文件\\";

    /**
     * 标准母模板文件路径
     */
    String TEMPLATE_PATH =  "SafetyStandards\\标准化相关文件\\母模板文件\\";

    /**
     * 标准化子(企业)模板文件路径
     */
    String SUBTEMPLATE_PATH =  "SafetyStandards\\标准化相关文件\\子模板文件\\";


    /**
     * 标准化子(企业)pdf文件路径
     */
    String SUBTEMPLATE_FORMAL_PATH =  "SafetyStandards\\标准化相关文件\\正式文件\\";

    /**
     * 标准化子(企业)pdf文件路径
     */
    String SUBTEMPLATE_PDF_PATH =  "SafetyStandards\\标准化相关文件\\pdf文件\\";


    /**
     * 标准化子(企业)图片文件路径
     */
    String SUBTEMPLATE_IMG_PATH =  "SafetyStandards\\标准化相关文件\\图片文件\\";

    /**
     * 应急处置图片路径
     */
    String EMERGENCYPDF_PATH =  "SafetyStandards\\应急处置文件\\PDF\\";

    String EMERGENCYPIC_PATH =  "SafetyStandards\\应急处置文件\\PIC\\";

    String EMERGENCYWORLD_PATH = "SafetyStandards\\应急处置文件\\WORLD\\";

	/**
	 *图片/附件url路径
	 */
	String EnclosureUrl="AttachFiles/";
	/**
	 * @Description: 附件存放在附件服务下
	 * @Author: 呵呵哒
	 * *
	 * E:\IdeaWordSpace\FileManagement\webapps\FileManager\static\AttachFiles\
	 */
	String ENCLOSURE_PATH="AttachFiles\\";
	/**
     * 文件存取根目录路径
     */
    String REPORTFILE_PATH = "D:\\anbiao3.0\\FileManagement\\webapps\\FileManager\\static\\baogaowenjian\\";
//	String REPORTFILE_PATH = "D:\\baogaowenjian\\";

    /**
     * url前缀
     */
    String REPORTFILE_URL = "http://202.100.168.150:8203/FileManager/static/baogaowenjian/";

	String QYWJ_PATH = "SafetyStandards\\企业文件\\正式文件\\";
	String QYWJ_PDF_PATH = "SafetyStandards\\企业文件\\pdf文件\\";
	String QYWJ_IMG_PATH = "SafetyStandards\\企业文件\\图片文件\\";


	String SPF_PATH = "SafetyStandards\\安全生产档案\\正式文件\\";
	String SPF_PDF_PATH = "SafetyStandards\\安全生产档案\\pdf文件\\";
	String SPF_IMG_PATH = "SafetyStandards\\安全生产档案\\图片文件\\";
	String SPF_TMP_PATH = "SafetyStandards\\安全生产档案\\模板\\";

}
