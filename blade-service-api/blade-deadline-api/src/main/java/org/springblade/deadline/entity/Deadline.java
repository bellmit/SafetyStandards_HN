package org.springblade.deadline.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @program: SpringBlade
 * @author: 呵呵哒
 **/
@Data
@TableName("deadline")
public class Deadline implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Integer id;
	/**
	 * 计算机唯一id
	 */
	private String mainboard;
	/**
	 * 最后时间
	 */
	private LocalDateTime deadline;
}
