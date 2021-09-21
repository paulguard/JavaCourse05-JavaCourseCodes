package com.pxd.javacoursecodes.w7.service;

import com.pxd.javacoursecodes.w7.dao.SohMapper;
import com.pxd.javacoursecodes.w7.entity.Soh;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SohServiceImpl implements SohService {

    @Resource
    private SohMapper sohMapper;

    //@ReadOnly(name = DataSourceNames.SECOND)
    @Override
    public Soh getById(Long id) {
        return sohMapper.getById(id);
    }
}
