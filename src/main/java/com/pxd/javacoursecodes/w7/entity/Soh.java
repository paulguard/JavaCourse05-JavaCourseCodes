package com.pxd.javacoursecodes.w7.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Soh extends BaseEntity {

    private Date orderTime;

    private String code;

    private String status;

    private String buyerName;

    private String buyerProvince;

    private String buyerCity;

    private String buyerCounty;

    private String buyerDetailAddr;

    private String sellerName;

    private String sellerProvince;

    private String sellerCity;

    private String sellerCounty;

    private String sellerDetailAddr;

    private Long deleteVersion;

    private Date deleteTime;

    private Long version;

    private Long userId;

}
