package com.pxd.javacoursecodes.w8.mapper;

import com.pxd.javacoursecodes.w8.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface AccountMapper {

    int insert(Account account);

}
