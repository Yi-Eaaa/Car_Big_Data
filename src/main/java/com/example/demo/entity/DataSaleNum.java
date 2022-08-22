package com.example.demo.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author dylen
 * @since 2022-08-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class DataSaleNum implements Serializable {

    private static final long serialVersionUID = 1L;

    private String carname;

    private String province;

    private Double minprice;

    private Double maxprice;

    private Integer saleCnt;


}
