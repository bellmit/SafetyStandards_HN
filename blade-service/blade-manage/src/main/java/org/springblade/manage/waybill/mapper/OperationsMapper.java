/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 */
package org.springblade.manage.waybill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.manage.waybill.entity.Operations;
import org.springblade.manage.waybill.page.OperationsPage;
import org.springblade.manage.waybill.vo.OperationsVO;

import java.util.List;

/**
 *  Mapper 接口
 */
public interface OperationsMapper extends BaseMapper<Operations> {

	/**
	 * 分页列表
	 * @param page
	 * @return
	 */
	List<OperationsVO> selectPageList(OperationsPage page);

	/**
	 * 分页统计
	 * @param page
	 * @return
	 */
	int selectTotal(OperationsPage page);

	OperationsVO selectDetail(String id);


}
