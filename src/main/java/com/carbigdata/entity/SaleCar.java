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
public class SaleCar implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sale_car_name_id")
    private Integer saleCarNameId;

    private String saleCarName;

    private Integer saleTotalNum;

    private Double saleTotalMoney;

}
