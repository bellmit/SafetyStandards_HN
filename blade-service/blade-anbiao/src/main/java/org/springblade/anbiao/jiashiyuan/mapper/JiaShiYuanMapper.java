package org.springblade.anbiao.jiashiyuan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springblade.anbiao.cheliangguanli.entity.Vehicle;
import org.springblade.anbiao.jiashiyuan.entity.JiaShiYuan;
import org.springblade.anbiao.jiashiyuan.page.JiaShiYuanPage;
import org.springblade.anbiao.jiashiyuan.vo.JiaShiYuanVO;

import java.util.List;

/**
 * Created by you on 2019/4/23.
 */
public interface JiaShiYuanMapper extends BaseMapper<JiaShiYuan> {

	boolean insertJSY(JiaShiYuan jiaShiYuan);

	boolean updateDel(String id);

	/**
	 * 自定义分页
	 * @param
	 * @return
	 */
	List<JiaShiYuanVO> selectPageList(JiaShiYuanPage jiaShiYuanPage);
	/**
	 * 统计
	 * @param
	 * @return
	 */
	int selectTotal(JiaShiYuanPage jiaShiYuanPage);

	JiaShiYuanVO selectByIds(String id);

	/**
	 * @Description: 根据身份证号查询
	 * @Param: cardNo
	 * @return: org.springblade.anbiao.jiashiyuan.vo.JiaShiYuanVO
	 * @Author: elvis
	 * @Date: 2020-06-23
	 */
	JiaShiYuanVO selectByCardNo(String cardNo);

	/**
	 * 根据驾驶员ID查询绑定车辆
	 * @param jiashiyuanid
	 * @return
	 */
	List<Vehicle> selectByCar(String jiashiyuanid);

	/**
	 * /初始化登录密码
	 * @param password
	 * @param id
	 * @return
	 */
	boolean updatePassWord(String password,String id);

	/**
	 *查询驾驶员绑定车辆
	 * @param jiaShiYuanPage
	 * @return
	 */
	List<JiaShiYuanVO> selectJVList(JiaShiYuanPage jiaShiYuanPage);
	int selectJVTotal(JiaShiYuanPage jiaShiYuanPage);
}
