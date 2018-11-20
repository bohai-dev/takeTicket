package com.example.takeTicket.service.impl;

import com.example.takeTicket.dao.AdminUserMapper;
import com.example.takeTicket.dao.ShopMapper;
import com.example.takeTicket.domain.AdminUser;
import com.example.takeTicket.domain.Shop;
import com.example.takeTicket.exception.CouponErrorConstant;
import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cxy on 2018/11/6
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    AdminUserMapper userMapper;

    @Autowired
    ShopMapper shopMapper;

    @Override
    public AdminUser selectUser(AdminUser adminUser) {

        AdminUser user=userMapper.selectByNamePwd(adminUser.getUserName(),adminUser.getUserPwd());

        return user;

    }


    @Override
    public Shop login(AdminUser adminUser) throws CouponException{
        AdminUser user=userMapper.selectByNamePwd(adminUser.getUserName(),adminUser.getUserPwd());
        if (user==null){
            throw new CouponException(CouponErrorConstant.ADMIN_LOGIN_ERROR);
        }

        Shop shop=shopMapper.selectByAdminUserId(user.getUserId());

        return shop;

    }
}
