package com.example.takeTicket.service;

import com.example.takeTicket.domain.AdminUser;
import com.example.takeTicket.exception.CouponException;

/**
 * Created by cxy on 2018/11/19
 */
public interface AdminUserService {
    //查询用户
    AdminUser selectUser(AdminUser adminUser);
}
