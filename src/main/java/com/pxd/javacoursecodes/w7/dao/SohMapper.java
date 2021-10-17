package com.pxd.javacoursecodes.w7.dao;

import com.pxd.javacoursecodes.w7.entity.Soh;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper
//@Repository
public interface SohMapper {

    int addSingleSoh(Soh soh);

    int addSingleSohBatch(@Param("list") List<Soh> list);

    Soh getById(@Param("id") Long id);

    int deleteById(@Param("id") Long id);

    int updateCode(Soh soh);
}
