package com.pxd.javacoursecodes.w5.service;

import com.pxd.javacoursecodes.w5.dao.ClassDao;
import com.pxd.javacoursecodes.w5.entity.Clazz;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClassDao classDao;

    @Override
    public List<Clazz> getAll() {
        return classDao.getAll();
    }

    @Override
    public List<Clazz> getClass(Long id) {
        return classDao.getClass(id);
    }

    @Override
    public int deleteClass(Long id) {
        return classDao.deleteClass(id);
    }

    @Override
    public int updateClass(Clazz clazz){
        return classDao.updateClass(clazz);
    }


}
