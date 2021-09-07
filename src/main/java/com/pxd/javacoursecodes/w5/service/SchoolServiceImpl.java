package com.pxd.javacoursecodes.w5.service;

import com.example.pxdstarter.service.DataService;
import com.pxd.javacoursecodes.w5.dao.SchoolDao;
import com.pxd.javacoursecodes.w5.entity.School;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.List;

public class SchoolServiceImpl implements SchoolService {

    @Autowired
    private SchoolDao schoolDao;

    @Resource
    private DataService dataService;

    @Override
    public List<School> selectAll() {
        return schoolDao.selectAll();
    }

    @Override
    public String getSchoolName() {
        return dataService.getSchoolName();
    }
}
