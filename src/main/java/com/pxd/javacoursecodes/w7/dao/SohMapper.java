package com.pxd.javacoursecodes.w7.dao;

import com.pxd.javacoursecodes.w7.entity.Soh;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Mapper
public interface SohMapper {

    int addSingleSoh(Soh soh);

    int addSingleSohBatch(@Param("list") List<Soh> list);
}
