package com.pxd.javacoursecodes.w5.dao;

import com.pxd.javacoursecodes.w5.entity.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> selectAll() {
        System.out.println("select All Students!");
        return new ArrayList<>();
    }
}
