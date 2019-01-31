package com.example.takeTicket.service;

import java.util.List;

import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.vo.CustCanExchangeCouponVo;
import com.example.takeTicket.vo.Shop3Vo;

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
    List<Shop3Vo> getCustShareList(String custId) throws CouponException;
    
    /**
     * 客户可兑换优惠一览
     * @param custId,shopId
     * @return
     * @throws CouponException
     */
    List<CustCanExchangeCouponVo> getCustCanExchangeCouponList(String custId) throws CouponException;
}
