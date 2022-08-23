package com.example.demo.entity;

import java.time.LocalDate;
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
 * @since 2022-08-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class CarParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 参数所属汽车id
     */
    @TableId(value = "sys_para_car_id")
    private String sysParaCarId;

    /**
     * 汽车最小离地间隙
     */
    private Double sysParaMinclearance;

    /**
     * 汽车最高车速
     */
    private Double sysParaMaxspeed;

    private Double sysParaAcc;

    /**
     * 汽车扭矩
     */
    private Double sysParaTorque;

    /**
     * 汽车功率
     */
    private Double sysParaPower;

    /**
     * 汽车百公里能耗
     */
    private Double sysParaKmEnergy;

    private Double sysParaKmEnergyReport;

    /**
     * 汽车车型类型
     */
    private String sysParaType;

    /**
     * 汽车生产厂家
     */
    private String sysParaManufactor;

    /**
     * 汽车动力类型
     */
    private String sysParaPowerType;

    /**
     * 汽车生产年份
     */
    private LocalDate sysParaProductiveYear;

    /**
     * 汽车型号/名称
     */
    private String sysParaCarName;
    /**
     * 汽车人气指数
     */
    private Integer sysParaPopularity;
    /**
     * 汽车厂商指导价格
     */
    private Double sysParaGuidePrice;
    /**
     * 汽车成交最低价格
     */
    private Double sysParaMinPrice;


}
