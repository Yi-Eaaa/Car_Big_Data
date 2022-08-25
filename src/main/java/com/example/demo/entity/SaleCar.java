package com.example.demo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.sql.rowset.serial.SerialStruct;

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
public class SaleCar implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "sale_car_name_id")
    private Integer saleCarNameId;
    private String saleCarDate;
    private String saleCarData;


}
