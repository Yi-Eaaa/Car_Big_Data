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
public class SaleArea implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 按地区汇总销量数据
     */
    @TableId(value = "sale_area_id")
    private Integer saleAreaId;

    /**
     * 汇总销量地区
     */
    private String saleAreaName;

    /**
     * 汇总销量车型
     */
    private Integer saleCarNameId;

    /**
     * 汇总销量
     */
    private Integer saleTotalNum;

    /**
     * 汇总销售额
     */
    private Double saleTotalMoney;


}