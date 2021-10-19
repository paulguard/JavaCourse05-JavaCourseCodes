package com.pxd.javacoursecodes.w11;

import com.pxd.javacoursecodes.w7.entity.Soh;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author by 平向东
 * @date 2021/10/19 15:54 Copyright 2021 北京交个朋友数码科技有限公司. All rights reserved.
 */
@Service
@Slf4j
public class SohServiceImpl implements SohService{

    @Override
    public boolean verifySoh(Soh soh) {

        log.info("进行审核处理,单号：{}",soh.getCode());

        return true;
    }
}
