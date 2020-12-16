/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package org.springblade.anbiao.guanlijigouherenyuan.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.AllArgsConstructor;
import org.springblade.anbiao.guanlijigouherenyuan.entity.Departmentpost;
import org.springblade.anbiao.guanlijigouherenyuan.mapper.DepartmentpostMapper;
import org.springblade.anbiao.guanlijigouherenyuan.page.DepartmentpostPage;
import org.springblade.anbiao.guanlijigouherenyuan.service.IDepartmentpostService;
import org.springblade.anbiao.guanlijigouherenyuan.vo.DepartmentpostVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  服务实现类
 */
@Service
@AllArgsConstructor
public class DepartmentpostServiceImpl extends ServiceImpl<DepartmentpostMapper, Departmentpost> implements IDepartmentpostService {


	private DepartmentpostMapper departmentpostMapper;

	@Override
	public DepartmentpostPage<DepartmentpostVO> selectPageQuery(DepartmentpostPage page) {
		Integer total = departmentpostMapper.selectTotal(page);
		Integer pagetotal = 0;
		if (total > 0) {
			if(total%page.getSize()==0){
				pagetotal = total / page.getSize();
			}else {
				pagetotal = total / page.getSize() + 1;
			}
		}
		if (pagetotal < page.getCurrent()) {
			return page;
		} else {
			page.setPageTotal(pagetotal);
			Integer offsetNo = 0;
			if (page.getCurrent() > 1) {
				offsetNo = page.getSize() * (page.getCurrent() - 1);
			}
			page.setTotal(total);
			page.setOffsetNo(offsetNo);
			List<DepartmentpostVO> list = departmentpostMapper.selectPageQuery(page);
			return (DepartmentpostPage<DepartmentpostVO>) page.setRecords(list);
		}
	}

	@Override
	public boolean deletepost(String id) {
		return departmentpostMapper.deletepost(id);
	}

	@Override
	public Departmentpost selectByPostId(String deptId) {
		return departmentpostMapper.selectByPostId(deptId);
	}

	@Override
	public boolean updateByPostId(Departmentpost Departmentpost) {
		return departmentpostMapper.updateByPostId(Departmentpost);
	}
}
