package com.pxd.javacoursecodes.w7.entity;

import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {

    private Long id;

    private Date createTime;

    private Date updateTime;

    private Long creatorId;

    private Long updatorId;

}
