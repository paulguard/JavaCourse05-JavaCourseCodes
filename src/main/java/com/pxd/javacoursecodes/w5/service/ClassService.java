package com.pxd.javacoursecodes.w5.service;

import com.pxd.javacoursecodes.w5.entity.Clazz;

import java.util.List;

public interface ClassService {

    List<Clazz> getAll();

    List<Clazz> getClass(Long id);

    int deleteClass(Long id);

    int updateClass(Clazz clazz);
}
