package com.pxd.javacoursecodes.w5.service;

import com.pxd.javacoursecodes.w5.dao.SchoolDao;
import com.pxd.javacoursecodes.w5.entity.School;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolDao schoolDao;

    @Override
    public List<School> selectAll() {
        return schoolDao.selectAll();
    }
}
