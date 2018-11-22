package com.example.takeTicket.service;

import java.util.List;

import com.example.takeTicket.domain.Shop;
import com.example.takeTicket.exception.CouponException;

/**
 * Created by cxy on 2018/11/19
 */
public interface CustShareService {

    
    /**
     * 客户分享登入
     * @param custId,shopId
     * @return
     * @throws CouponException
     */
    void custShareInfo(String custId,String shopId) throws CouponException;
    
    /**
     * 客户分享记录列表
     * @param custId,shopId
     * @return
     * @throws CouponException
     */
    List<Shop> getCustShareList(String custId) throws CouponException;
}
