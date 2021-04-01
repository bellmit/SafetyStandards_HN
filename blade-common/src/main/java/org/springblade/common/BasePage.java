package org.springblade.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Collections;
import java.util.List;

/**
 * 基础分页类
 *
 * @program: SafetyStandards
 * @description: BasePage
 * @author: hyp
 * @create2021-04-25 14:00
 **/
@ApiModel(value = "BasePage对象", description = "BasePage对象")
public class BasePage<T> {
    static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "实体列表")
    private List<T> records;
    @ApiModelProperty(value = "第几页", required = true)
    private Integer current;
    @ApiModelProperty(value = "每页显示数", required = true)
    private Integer size;
    @ApiModelProperty(value = "总数")
    private Integer total;
    @ApiModelProperty(value = "总页数")
    private Integer pageTotal;
    @ApiModelProperty(value = "偏移量")
    private Integer offsetNo;
    @ApiModelProperty(value = "正序/倒序")
    private Integer order;
    @ApiModelProperty(value = "排序字段")
    private String orderColumn;

    public BasePage() {
        this.records = Collections.emptyList();
        this.current = 1;
        this.size = 10;
        this.total = 0;
        this.pageTotal = 0;
        this.offsetNo = 0;
    }

    public List<T> getRecords() {
        return this.records;
    }

    public BasePage<T> setRecords(List<T> records) {
        this.records = records;
        return this;
    }

    public Integer getCurrent() {
        return this.current;
    }

    public BasePage<T> setCurrent(Integer current) {
        this.current = current;
        return this;
    }

    public Integer getSize() {
        return this.size;
    }

    public BasePage<T> setSize(Integer size) {
        this.size = size;
        return this;
    }

    public Integer getTotal() {
        return this.total;
    }

    public BasePage<T> setTotal(Integer total) {
        this.total = total;
        return this;
    }

    public Integer getPageTotal() {
        return this.pageTotal;
    }

    public BasePage<T> setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
        return this;
    }

    public Integer getOffsetNo() {
        return this.offsetNo;
    }

    public BasePage<T> setOffsetNo(Integer offsetNo) {
        this.offsetNo = offsetNo;
        return this;
    }

    public Integer getOrder() {
        return this.order;
    }

    public BasePage<T> setOrder(Integer order) {
        this.order = order;
        return this;
    }

    public String getOrderColumn() {
        return this.orderColumn;
    }

    public BasePage<T> setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
        return this;
    }

}
