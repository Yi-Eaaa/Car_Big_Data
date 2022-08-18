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
public class SaleArea implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * æŒ‰åœ°åŒºæ±‡æ€»é”€é‡æ•°æ®
     */
    @TableId(value = "sale_area_id")
    private Integer saleAreaId;

    /**
     * æ±‡æ€»é”€é‡åœ°åŒº
     */
    private String saleAreaName;

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
