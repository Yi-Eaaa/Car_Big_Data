package com.carbigdata.entity;

import java.time.LocalDate;
import java.io.Serializable;
import java.util.Date;

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
public class CarParameter implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * å‚æ•°æ‰€å±žæ±½è½¦id
     */
    @TableId(value="sys_para_car_id")
    private String sysParaCarId;

    /**
     * æ±½è½¦æœ€å°ç¦»åœ°é—´éš™
     */
    private Double sysParaMinclearance;

    /**
     * æ±½è½¦æœ€é«˜è½¦é€Ÿ
     */
    private Double sysParaMaxspeed;

    /**
     * æ±½è½¦æ‰­çŸ©
     */
    private Double sysParaTorque;

    /**
     * æ±½è½¦åŠŸçŽ‡
     */
    private Double sysParaPower;

    /**
     * æ±½è½¦ç™¾å…¬é‡Œèƒ½è€—
     */
    private Double sysParaKmEnergy;

    /**
     * æ±½è½¦è½¦åž‹ç±»åž‹
     */
    private String sysParaType;

    /**
     * æ±½è½¦ç”Ÿäº§åŽ‚å®¶
     */
    private String sysParaManufactor;

    /**
     * æ±½è½¦åŠ¨åŠ›ç±»åž‹
     */
    private String sysParaPowerType;

    /**
     * æ±½è½¦ç”Ÿäº§å¹´ä»½
     */
    private Date sysParaProductiveYear;

    /**
     * æ±½è½¦åž‹å·/åç§°
     */
    private String sysParaCarName;


}
