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
    
    /**
     * 2019年v1.0.9新客户分享登入 启用新表
     * @param custId,shopId
     * @return
     * @throws CouponException
     */
    void insCustShareInfo(String custId,String shopId,String shareStyle) throws CouponException;
    
    /**
     * 2019年v1.0.9新客户转发状态更新
     * @param custId,shopId
     * @return
     * @throws CouponException
     */
    void updShareStatue(String shareStyle) throws CouponException;
    
    
    /**
     * 2019年v1.0.9新客户分享记录加分前的CHECK
     * @param custId,shopId
     * @return
     * @throws CouponException
     */
    String checkShareStatue(String custId,String shopId,String shareStyle) throws CouponException;
    
}
