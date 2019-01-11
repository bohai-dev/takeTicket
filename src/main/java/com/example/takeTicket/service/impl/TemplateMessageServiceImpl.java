package com.example.takeTicket.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.takeTicket.dao.CouponMapper;
import com.example.takeTicket.dao.CustUserMapper;
import com.example.takeTicket.dao.ShopMapper;
import com.example.takeTicket.domain.Coupon;
import com.example.takeTicket.domain.Shop;
import com.example.takeTicket.service.TemplateMessageService;
import com.example.takeTicket.util.Constants;
import com.example.takeTicket.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cxy on 2019/1/9
 */
@Service
public class TemplateMessageServiceImpl implements TemplateMessageService {

    @Autowired
    CustUserMapper userMapper;
    @Autowired
    CouponMapper couponMapper;
    @Autowired
    ShopMapper shopMapper;


    //优惠券兑换成功发送消息模板id
    private static final String EXCHANGE_COUPON_TEMPLATE_ID="Isug7eZ1Vl6GHkIyXgYXC2LM99xcVVK8La2zpTOcbA4";

    private static final String TEMPLATE_MESSAGE_URL="https://api.weixin.qq.com/cgi-bin/message/wxopen/template/send?access_token=";
    
    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateMessageServiceImpl.class);

    @Override
    public void sendExchSuccessMsg(String userId,String shopId,String couponId,String formId){
        //要跳转的小程序页面路径
        String page="pages/changeHistory/changeHistory";

        try {
            //获取access_token
            String accessToken=HttpUtil.get(Constants.SERVER_URL+"/access_token");
            String openId=userMapper.selectByPrimaryKey(userId).getOpenId();
            Shop shop=shopMapper.selectByPrimaryKey(shopId);

            String shopName=shop.getShopName();
            String shopAddress=shop.getShopAddress();
            Coupon coupon=couponMapper.selectByPrimaryKey(couponId);
            //优惠券类型 0：代金券 1：折扣券 2：赠品
            String couponType=coupon.getCouponType();
            String couponValue=coupon.getCouponType();

            JSONObject jsonObject=new JSONObject();
            jsonObject.put("touser",openId);
            jsonObject.put("template_id",EXCHANGE_COUPON_TEMPLATE_ID);
            jsonObject.put("page",page);
            jsonObject.put("form_id",formId);

             JSONObject dataJson=new JSONObject();
             //set shopName
             JSONObject keyword1Json=new JSONObject();
             keyword1Json.put("value",shopName);
             dataJson.put("keyword1",keyword1Json);

             //set shopAddress
            JSONObject keyword2Json=new JSONObject();
            keyword2Json.put("value",shopAddress);
            dataJson.put("keyword2",keyword2Json);

            //set remark
            String remark="您已成功兑换优惠券，记得使用哦！";
            JSONObject keyword3Json=new JSONObject();
            keyword3Json.put("value",remark);
            dataJson.put("keyword3",keyword3Json);

            jsonObject.put("data",dataJson);

            // jsonObject.put("emphasis_keyword","");    //模板需要放大的关键词，不填则默认无放大

            String result=HttpUtil.postJson(TEMPLATE_MESSAGE_URL+accessToken,jsonObject);
            LOGGER.info("发送模板消息:"+result);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
