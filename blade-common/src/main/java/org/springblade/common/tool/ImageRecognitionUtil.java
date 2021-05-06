/**
 * Copyright (C), 2015-2021
 * FileName: ImageRecognitionUtil
 * Author:   呵呵哒
 * Date:     2021/3/24 10:42
 * Description:
 */
package org.springblade.common.tool;

//import org.springblade.core.tool.api.R;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 呵呵哒
 * @创建人 hyp
 * @创建时间 2021/3/24
 * @描述
 */
public class ImageRecognitionUtil {

	/**
	 * 百度卡片识别
	 * @param file 对象
	 * @param type 识别类型
	 * @return
	 * @throws Exception
	 */
//	public static R baiduOcr(MultipartFile file, Integer type) throws Exception {
//		R rs = new R();
//		if (file == null || file.isEmpty()) {
//			throw new Exception("文件为空");
//		}
//		if (type == null) {
//			throw new Exception("识别类型为空");
//		}
//		Map<String, Object> map = new HashMap<>();
//		// 身份证
//		if (type == 1) {
//			BaiduOcrUtil.IdCard idCard = BaiduOcrUtil.idCard(file.getBytes());
//			if (idCard.getCode() == 200) {
//				map.put("idcard", idCard);
//				rs.setData(idCard);
//				rs.setCode(200);
//			} else {
//				rs.setCode(500);
//				rs.setMsg(idCard.getErrorMsg());
//			}
//		} else if (type == 2) {
//			try {
//				BaiduOcrUtil.DriverLicence driverLicence = BaiduOcrUtil.driverLicence(file.getBytes());
//
//				if (driverLicence.getCode() == 200) {
//					map.put("driverLicence", driverLicence);
//					rs.setCode(200);
//					rs.setData(driverLicence);
//				} else {
//					rs.setCode(500);
//					rs.setMsg(driverLicence.getErrorMsg());
//				}
//			} catch (Exception e) {
//				rs.setCode(500);
//				rs.setData(e);
//				rs.setMsg("识别错误");
//			}
//		}
//		return rs;
//	}


}
