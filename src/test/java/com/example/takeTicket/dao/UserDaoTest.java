package com.example.takeTicket.dao;

import com.example.takeTicket.domain.CustUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * Created by cxy on 2018/11/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {

    @Autowired
    CustUserMapper userMapper;

    @Test
    public void insertTest(){
        CustUser newUser=new CustUser();
        String userId=userMapper.generateId();
        newUser.setCustId(userId);
        newUser.setOpenId("111");
        newUser.setSessionKey("2222");
        newUser.setCreatedAt(new Date());
        newUser.setUpdatedAt(new Date());

        userMapper.insertSelective(newUser);
    }
}
