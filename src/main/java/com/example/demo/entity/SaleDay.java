package com.example.demo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dylen
 * @since 2022-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SaleDay implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 按天汇总销量数据id
     */
    @TableId(value = "sale_day_id")
    private Integer saleDayId;

    /**
     * 汇总销量日
     */
    private Integer saleDay;

    /**
     * 汇总销量月份
     */
    private Integer saleMonthId;

    /**
     * 汇总销量年份
     */
    private Integer saleYearId;

    /**
     * 汇总销量车型
     */
    private String saleCarNameId;

    /**
     * 汇总销量
     */
    private Integer saleTotalNum;

    /**
     * 汇总销售额
     */
    private Double saleTotalMoney;


}
