package org.springblade.anbiao.cheliangziping.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springblade.anbiao.cheliangziping.vo.ZipinjianchaneirongMubanVO;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Lh
 * @description: TODO
 * @projectName SafetyStandards
 * @date 2019/9/322:54
 */
@Data
@ApiModel(value = "Zipinjiancha", description = "Zipinjiancha")
public class Zipinjiancha {

	@TableId(value = "id")
	private String 	  id;
	@ApiModelProperty(value = "标题")
	private String	  biaoti;
	@ApiModelProperty(value = "运营类型")
	private String 	  yunyingleixing;
	@ApiModelProperty(value = "合格率")
	private double	  hegelv;
	@ApiModelProperty(value = "自检周期")
	private String zijianzhouqi;
	@ApiModelProperty(value = "完结状态")
	private  Integer  isWanjie;
	@ApiModelProperty(value = "完结状态")
	private  String  isWanjieshow;
	@ApiModelProperty(value = "备注")
	private String   beizhu;
	@ApiModelProperty(value = "deptid")
	private Integer  deptId;
	@ApiModelProperty(value = "操作时间")
	private LocalDateTime caozuoshijian;
	@ApiModelProperty(value = "操作人")
	private String   caozuoren;
	@ApiModelProperty(value = "自检时间")
	private LocalDateTime  zijianshijian;
	@ApiModelProperty(value = "是否完结 0 未完结可编辑 1 完结不可编辑")
	private Integer wanjie;
	@ApiModelProperty(value = "table数据")
	private List<ZipinjianchaneirongMubanVO> list;
	@ApiModelProperty(value = "企业名称")
	private String deptName;
	@ApiModelProperty(value = "自评检查详情")
	private ZipinjiachaXiangQing zipinjiachaXiangQing;
	@ApiModelProperty(value = "完结时间")
	private  LocalDateTime wanjieshijian;
	@ApiModelProperty("报告时间")
	private String  baogaoshijian;
	@ApiModelProperty("zhouqi_count")
	private Integer  zhouqiCount;
}
