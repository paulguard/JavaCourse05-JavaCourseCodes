package com.pxd.javacoursecodes.w8.mapper2;

import com.pxd.javacoursecodes.w8.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {

    int insert(User user);

}
