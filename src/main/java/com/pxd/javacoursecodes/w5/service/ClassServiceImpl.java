package com.pxd.javacoursecodes.w5.service;

import com.pxd.javacoursecodes.w5.dao.ClassDao;
import com.pxd.javacoursecodes.w5.entity.Class;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Override
    public List<Class> getAll() {
        return classDao.getAll();
    }
}
