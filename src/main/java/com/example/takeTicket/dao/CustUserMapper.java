package com.example.takeTicket.dao;

import com.example.takeTicket.domain.CustUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface CustUserMapper {
    int deleteByPrimaryKey(String custId);

    int insert(CustUser record);

    int insertSelective(CustUser record);

    CustUser selectByPrimaryKey(String custId);

    int updateByPrimaryKeySelective(CustUser record);

    int updateByPrimaryKey(CustUser record);

    @Select("select * from CUST_USER where OPEN_ID=#{openId}")
    CustUser selectByOpenId(@Param("openId") String openId);

    @Select("select CUST_USER_SEQ.NEXTVAL from dual")
    String generateId();
}