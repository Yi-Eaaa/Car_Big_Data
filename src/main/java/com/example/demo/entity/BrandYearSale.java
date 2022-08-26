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
 * @since 2022-08-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class BrandYearSale implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sys_para_car_id")
    private Integer id;

    private String brandName;

    private Integer saleYear;

    private Integer saleNum;


}
