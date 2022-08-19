package com.carbigdata.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author hongyi
 * @since 2022-08-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SaleMonth implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 按月汇总销量数据id
     */
    private Integer saleMonthId;

    /**
     * 汇总销量月份
     */
    private Integer saleMonth;

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
