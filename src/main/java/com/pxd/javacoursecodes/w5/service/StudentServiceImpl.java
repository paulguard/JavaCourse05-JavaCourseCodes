package com.pxd.javacoursecodes.w5.service;

import com.pxd.javacoursecodes.w5.dao.StudentDao;
import com.pxd.javacoursecodes.w5.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Student的两个Bean:Service和Dao用Annotation来声明
 */
@Service
public class StudentServiceImpl implements StudentService {

    // 用了Annotation的方式装配
    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> selectAll() {
        return studentDao.selectAll();
    }
}
