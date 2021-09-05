package com.pxd.javacoursecodes.w5.dao;

import com.pxd.javacoursecodes.w5.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> selectAll();

}
