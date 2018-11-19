package com.example.takeTicket.service.impl;

import com.example.takeTicket.dao.CouponMapper;
import com.example.takeTicket.dao.CustCouponRecordMapper;
import com.example.takeTicket.domain.Coupon;
import com.example.takeTicket.domain.CustCouponRecord;
import com.example.takeTicket.exception.CouponErrorConstant;
import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.service.UserCouponService;
import com.example.takeTicket.vo.ResponseBody;
import com.example.takeTicket.vo.UserCoupon;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by cxy on 2018/11/19
 */
@Service
public class UserCouponServiceImpl implements UserCouponService {

    @Autowired
    CustCouponRecordMapper  custCouponMapper;

    @Autowired
    CouponMapper couponMapper;

    @Override
    public void destroyCoupon(String userCouponId) throws CouponException{
        CustCouponRecord custCoupon=custCouponMapper.selectByPrimaryKey(userCouponId);
        if (custCoupon==null){
            throw new CouponException(CouponErrorConstant.COUPON_NOT_EXISTS_ERROR);
        }
        if (custCoupon.getCouponState()==1){ //优惠券已被使用
            throw new CouponException(CouponErrorConstant.COUPON_USED_ERROR);
        }

        //更新状态
        CustCouponRecord newCustCoupon=new CustCouponRecord();
        newCustCoupon.setCustCouponId(userCouponId);
        newCustCoupon.setCouponState(1);
        newCustCoupon.setUpdateTime(new Date());

        custCouponMapper.updateByPrimaryKeySelective(newCustCoupon);

    }

    /**
     * 查询优惠券信息
     * @param userCouponId
     * @return
     * @throws CouponException
     */
    @Override
    public UserCoupon selectById(String userCouponId) throws CouponException{


        CustCouponRecord custCoupon=custCouponMapper.selectByPrimaryKey(userCouponId);
        if (custCoupon==null){
            throw new CouponException(CouponErrorConstant.COUPON_NOT_EXISTS_ERROR);
        }
        UserCoupon userCoupon=new UserCoupon();
        BeanUtils.copyProperties(custCoupon,userCoupon);
        String couponId=custCoupon.getCouponId();
        Coupon coupon=couponMapper.selectByPrimaryKey(couponId);
        userCoupon.setCouponType(coupon.getCouponType());
        userCoupon.setCouponValue(coupon.getCouponValue());



        return userCoupon;
    }
}
