package com.example.takeTicket.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.takeTicket.dao.CustUserMapper;
import com.example.takeTicket.domain.CustUser;
import com.example.takeTicket.exception.CouponErrorConstant;
import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.service.CustUserService;
import com.example.takeTicket.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by cxy on 2018/11/14
 * 用户service
 */
@Service
public class CustUserServiceImpl  implements CustUserService {

    public static final String APPID="wx7ec0f9fe81204830";
    public static final String SECRET="62ae1d4ed9ccee3d7a6c45f46bb0c05f";

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(CustUserServiceImpl.class);

    @Autowired
    CustUserMapper userMapper;

    @Override
    public String login(String code) throws CouponException {

        LOGGER.info("code="+code);

        StringBuilder htmlUrl=new StringBuilder( "https://api.weixin.qq.com/sns/jscode2session?grant_type=authorization_code&");
        htmlUrl.append("appid="+APPID+"&");
        htmlUrl.append("secret="+SECRET+"&");
        htmlUrl.append("js_code="+code);

        String userId="";

        try {
            String  httpResult=HttpUtil.get(htmlUrl.toString());
            JSONObject jsonObject=JSON.parseObject(httpResult);

            String errCode=jsonObject.getString("errcode");
            if (errCode!=null){
                String errMsg=jsonObject.getString("errmsg");
                LOGGER.error("获取openId出错:errCode="+errCode+",errMsg="+errMsg);
                throw new CouponException(CouponErrorConstant.LOGIN_WEIXIN_ERROR);
            }
            String sessionKey=jsonObject.getString("session_key"); //会话密钥
            String openId=jsonObject.getString("openid");  //用户在微信平台的唯一标识
            //根据openId查询数据库是否有该用户
            CustUser custUser=userMapper.selectByOpenId(openId);

            if (custUser==null){
                //新用户,插入记录
                CustUser newUser=new CustUser();
                userId=userMapper.generateId();
                newUser.setCustId(userId);
                newUser.setOpenId(openId);
                newUser.setSessionKey(sessionKey);
                newUser.setCreatedAt(new Date());
                newUser.setUpdatedAt(new Date());

                userMapper.insertSelective(newUser);

            }else{
                //老用户，更新 sessionKey
                CustUser updateUser=new CustUser();
                updateUser.setCustId(custUser.getCustId());
                updateUser.setSessionKey(sessionKey);
                updateUser.setUpdatedAt(new Date());

                userMapper.updateByPrimaryKeySelective(updateUser);

                userId=custUser.getCustId();

            }


        } catch (Exception e) {
            LOGGER.error("微信登录发生错误:"+e.toString());
            throw new CouponException(CouponErrorConstant.LOGIN_WEIXIN_ERROR);
        }
        return userId;
    }
}
