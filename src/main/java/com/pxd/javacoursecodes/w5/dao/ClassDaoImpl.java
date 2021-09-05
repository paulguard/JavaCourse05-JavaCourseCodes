package com.pxd.javacoursecodes.w5.dao;

import java.util.ArrayList;
import java.util.List;
import com.pxd.javacoursecodes.w5.entity.Class;

public class ClassDaoImpl implements ClassDao {

    @Override
    public List<Class> getAll() {
        System.out.println("select all class!");
        return new ArrayList<>();
    }
}
