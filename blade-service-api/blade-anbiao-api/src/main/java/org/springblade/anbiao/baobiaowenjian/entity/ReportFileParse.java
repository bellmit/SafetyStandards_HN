package org.springblade.anbiao.baobiaowenjian.entity;

import cn.hutool.core.util.StrUtil;
import lombok.AllArgsConstructor;
import org.springblade.common.configurationBean.FileServer;
import org.springframework.stereotype.Component;

/**
 * 文件读取，解析路径
 *
 * @ClassName ReportFileParse
 * @Author hyp
 * @CreateDate 2019-05-22
 **/
@AllArgsConstructor
@Component
public class ReportFileParse {

    private FileServer fileServer;

    /**
     * 获取物理路径path
     *
     * @param path 路径
     * @author: hyp
     * @date: 2019/5/22 10:00
     * @return: java.lang.String
     */
    public String getPath(String path) {
        return fileServer.getPathPrefix() + path;
    }

    /**
     * 物理路径转url
     *
     * @param path
     * @author: hyp
     * @date: 2019/5/22 10:00
     * @return: java.lang.String
     */
    public String pathToUrl(String path) {
        return StrUtil.replace(StrUtil.replace(path, fileServer.getPathPrefix(), fileServer.getUrlPrefix()), "\\", "/");
    }
}
