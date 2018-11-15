package com.example.takeTicket.service;

import com.example.takeTicket.exception.CouponException;

/**
 * Cteated by cxy on 2018/11/14
 */
public interface CustUserService {

    String login(String code) throws CouponException;
}
