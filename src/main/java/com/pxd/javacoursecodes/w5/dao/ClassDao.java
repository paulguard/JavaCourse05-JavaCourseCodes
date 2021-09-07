package com.pxd.javacoursecodes.w5.dao;

import java.util.List;
import com.pxd.javacoursecodes.w5.entity.Clazz;

public interface ClassDao {

    List<Clazz> getAll();

    int addClass(Clazz cls);

    int deleteClass(Long id);

    int updateClass(Clazz cls);

    List<Clazz> getClass(Long id);
}
