package org.springblade.anbiao.cheliangziping.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import org.apache.ibatis.annotations.Param;
import org.springblade.anbiao.cheliangziping.entity.ZipinZhouQI;
import org.springblade.anbiao.cheliangziping.entity.Zipingjieguocongbiao;

import java.util.List;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/9/222:53
 */
public interface Zipingjianchajieguocongbiao extends BaseMapper<Zipingjieguocongbiao> {
	 int  InsertAllcongbiao( List<Zipingjieguocongbiao> list);
	 Integer delete(String id);
	 Integer updatetable(@Param("list") List<Zipingjieguocongbiao> zipingjieguocongbiao);
	 List<String>  selectallByID(String  id);
	 List<ZipinZhouQI> zhouqi();
}
