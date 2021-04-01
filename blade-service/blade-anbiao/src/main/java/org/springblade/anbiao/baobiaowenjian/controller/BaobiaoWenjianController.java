/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springblade.anbiao.baobiaowenjian.controller;

import io.swagger.annotations.*;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.baobiaowenjian.entity.ReportFileParse;
import org.springblade.anbiao.baobiaowenjian.page.BaobiaoWenjianPage;
import org.springblade.anbiao.baobiaowenjian.service.IBaobiaoMuluService;
import org.springblade.anbiao.baobiaowenjian.service.IBaobiaoWenjianService;
import org.springblade.anbiao.baobiaowenjian.vo.BaobiaoMuluVO;
import org.springblade.anbiao.baobiaowenjian.vo.BaobiaoWenjianVO;
import org.springblade.anbiao.baobiaowenjian.vo.DateScopeUtil;
import org.springblade.core.boot.ctrl.BladeController;
import org.springblade.core.log.annotation.ApiLog;
import org.springblade.core.tool.api.R;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 控制器
 * @author 呵呵哒
 */
@RestController
@AllArgsConstructor
@RequestMapping("/anbiao/baobiaowenjian")
@Api(value = "报告文件", tags = "报告文件接口")
public class BaobiaoWenjianController extends BladeController {

    private IBaobiaoMuluService baobiaoMuluService;

    private IBaobiaoWenjianService baobiaoWenjianService;

    private ReportFileParse fileParse;

    /**
     * 根据报告性质获取文件列表
     */
    @PostMapping("/fileList")
	@ApiLog("报告文件-列表-报告")
    @ApiOperation(value = "列表-报告", notes = "传入baobiaoWenjianPage", position = 1)
    public R<BaobiaoWenjianPage<BaobiaoMuluVO>> fileList(@RequestBody BaobiaoWenjianPage baobiaoWenjianPage) {
        baobiaoWenjianPage.setOrderColumn("countdate");
        String countdate = baobiaoWenjianPage.getCountDate();
        int year = 0;
        int week = 0;
        int month = 0;
        if (baobiaoWenjianPage.getProperty() == 2) {
            String[] s = countdate.split("-");
            year = Integer.parseInt(s[0]);
            week = Integer.parseInt(s[1]);
            countdate = DateScopeUtil.getFirstDayOfWeek(year, week);
            baobiaoWenjianPage.setCountDate(countdate);
        }
        if (baobiaoWenjianPage.getProperty() == 3) {
            String[] s = countdate.split("-");
            year = Integer.parseInt(s[0]);
            month = Integer.parseInt(s[1]);
            countdate = DateScopeUtil.getFirstDayOfMonth(year, month);
            baobiaoWenjianPage.setCountDate(countdate);
        }
		//排序条件
		if(baobiaoWenjianPage.getOrderColumns()==null){
			baobiaoWenjianPage.setOrderColumn("countenddate");
		}else{
			baobiaoWenjianPage.setOrderColumn(baobiaoWenjianPage.getOrderColumns());
		}
        BaobiaoWenjianPage<BaobiaoMuluVO> list = baobiaoMuluService.selectBaogaoPage(baobiaoWenjianPage);
        return R.data(list);
    }

    /**
     * 根据报告id获取报告附件列表
     */
    @PostMapping("/fujianList")
	@ApiLog("报告文件-列表-附件")
    @ApiOperation(value = "列表-附件", notes = "报告id", position = 2)
    public R<List<BaobiaoWenjianVO>> fujianList(@ApiParam(value = "id", required = true) @RequestParam Integer id) {
        List<BaobiaoWenjianVO> list = baobiaoWenjianService.fujianList(id);
        return R.data(list);
    }

    /**
     * 文件对应图片预览
     * @param id
     * @param fileType
     * @author: 呵呵哒
     */
    @PostMapping("/preview")
	@ApiLog("报告文件-图片预览-文件")
    @ApiOperation(value = "图片预览-文件", notes = "传入id,fileType(1pdf预览，2图片预览)", position = 3)
    public R<BaobiaoWenjianVO> preview(@ApiParam(value = "id", required = true) @RequestParam Integer id,
                                       @ApiParam(value = "预览文件类型1或2", required = true) @RequestParam Integer fileType) {
        if (fileType != 1 && fileType != 2 && fileType != 4) {
            return R.fail("该文件不存在对应的预览格式资源！");
        }
        BaobiaoWenjianVO baobiaoWenjianVO = baobiaoWenjianService.selectPicPath(id, fileType);
        if (baobiaoWenjianVO == null) {
            return R.data(baobiaoWenjianVO, "该文件不存在对应的预览图片资源");
        }
        if (fileType == 1 || fileType == 4) {
            return R.data(baobiaoWenjianVO);
        } else {
            List<String> list = new ArrayList<String>();
            String pic = fileParse.getPath(baobiaoWenjianVO.getPath());
            File file = new File(pic);
            File[] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                if (files[i].isFile()) {
                    try {
//                        String base64 = CommonUtil.encodeBase64File(files[i].getAbsolutePath());
//                        list.add(base64);
                        list.add(fileParse.pathToUrl(files[i].getPath()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
			/**
			 * 文件标号排序 1 2 3 4 5 6 7 8 9
			 */
			Collections.sort(list, new Comparator<String>(){
				@Override
				public int compare(String o1, String o2) {
					Integer i1 = Integer.valueOf(o1.substring(o1.lastIndexOf("/")+1, o1.lastIndexOf(".")));
					Integer i2 = Integer.valueOf(o2.substring(o2.lastIndexOf("/")+1, o2.lastIndexOf(".")));

					if(i1>i2){
						return 1;
					}else if(i1<i2){
						return -1;
					}else{
						return 0;
					}
				}

			});
            baobiaoWenjianVO.setImgList(list);
            int i  = baobiaoWenjianService.updatePreviewRecordById(id);
            return R.data(baobiaoWenjianVO);
        }
    }

}
