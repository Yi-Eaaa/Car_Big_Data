package com.carbigdata.entity;

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
 * @author hongyi
 * @since 2022-08-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SaleDay implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * æŒ‰å¤©æ±‡æ€»é”€é‡æ•°æ®id
     */
    @TableId(value = "sale_day_id")
    private Integer saleDayId;

    /**
     * æ±‡æ€»é”€é‡æ—¥
     */
    private Integer saleDay;

    /**
     * æ±‡æ€»é”€é‡æœˆä»½
     */
    private Integer saleMonthId;

    /**
     * æ±‡æ€»é”€é‡å¹´ä»½
     */
    private Integer saleYearId;

    /**
     * æ±‡æ€»é”€é‡è½¦åž‹
     */
    private Integer saleCarNameId;

    /**
     * æ±‡æ€»é”€é‡
     */
    private Integer saleTotalNum;

    /**
     * æ±‡æ€»é”€å”®é¢
     */
    private Double saleTotalMoney;


}
