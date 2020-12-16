package org.springblade.common.enumconstant;

import org.apache.poi.ss.formula.functions.T;

/**
 * @description: doc模块数据常量
 * @projectName SafetyStandards
 * @date 2019/9/249:31
 */
public interface EnmuDoc {

    /**
     * @description: 标准化文档公用模板文件替换路径
     * @projectName SafetyStandards
     * @date 2019/9/249:31
     */
    enum MubanReplacePath{
        /**
         * 危货标准化模板替换路径
         */
        WEIHUO_PATH("WEIHUO_PATH", 1,"安全管理平台\\道路危险货物运输企业安全标准化资料", "危险货物模板文件替换路径"),
        /**
         *普货标准化模板替换路径
         */
        PUHUO_PATH("PUHUO_PATH", 2, "安全管理平台\\道路旅客运输企业安全标准化资料", "普通货物模板文件替换路径"),
        /**
         *客运标准化模板替换路径
         */
        KEYUN_PATH("KEYUN_PATH", 3, "安全管理平台\\道路普通货物运输企业安全标准化资料", "客运模板文件替换路径");

        private MubanReplacePath(String id, Integer value, String path ,String desc) {
            this.id = id;
            this.value = value;
            this.path= path;
            this.desc = desc;
        }
        /**
         * 常量id
         */
        public final String id;
        /**
         * 运营类型
         */
        public final Integer value;
        /**
         * 模板替换路径
         */
        public final String path;
        /**
         * 字典名称
         */
        public final String desc;

        public final static String enumId = "MubanReplacePath";
        public final static String enumDesc = "标准化模板文件替换路径";

        public static MubanReplacePath getByValue(Integer value){
            MubanReplacePath[] enums = MubanReplacePath.values();
            for (MubanReplacePath anEnum : enums) {
                if(anEnum.value.equals(value)){
                    return anEnum;
                }
            }
            return null;
        }

    }
}
