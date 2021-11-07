package com.pxd.javacoursecodes.w13.mq;

import java.util.HashMap;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author by 平向东
 * @date 2021/11/8 0:28 Copyright 2021 北京交个朋友数码科技有限公司. All rights reserved.
 */
@AllArgsConstructor
@Data
public class PmqMessage<T> {

    private HashMap<String,Object> headers;

    private T body;

}
