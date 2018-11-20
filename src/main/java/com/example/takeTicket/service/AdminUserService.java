package com.example.takeTicket.service;

import com.example.takeTicket.domain.AdminUser;
import com.example.takeTicket.domain.Shop;
import com.example.takeTicket.exception.CouponException;

/**
 * Created by cxy on 2018/11/19
 */
public interface AdminUserService {
    //查询用户
    AdminUser selectUser(AdminUser adminUser);

    /**
     *登录成功返回店铺名称
     * @param adminUser
     * @return
     */
    Shop login(AdminUser adminUser) throws CouponException;
}
