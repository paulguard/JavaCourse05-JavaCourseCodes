package com.pxd.javacoursecodes.w8.service;

import com.pxd.javacoursecodes.w8.entity.Account;
import com.pxd.javacoursecodes.w8.entity.User;
import com.pxd.javacoursecodes.w8.mapper.AccountMapper;
import com.pxd.javacoursecodes.w8.mapper2.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class JTAServiceImpl implements JTAService{

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private UserMapper userMapper;

    @Transactional(transactionManager = "xatx", propagation = Propagation.REQUIRED, rollbackFor = { Exception.class })
    public void insert(){

        User user = new User();
        user.setName("paul");
        user.setStatus("Enabled");

        //按理说，这里应该是3326的端口的数据库
        userMapper.insert(user);

        Account account = new Account();
        account.setName("Geek Account");
        account.setStatus("Enabled");
        account.setMoney(1.33333D);

        //按理说，这里应该是3316的端口的数据库
        accountMapper.insert(account);

    }

}
