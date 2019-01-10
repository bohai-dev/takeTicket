package com.example.takeTicket.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by cxy on 2019/1/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Autowired
    TemplateMessageService templateMessageService;

    @Test
    public void sendTemplateMessage(){

        templateMessageService.sendExchSuccessMsg("28","00106","00778e40a","1547001251641");
    }
}
