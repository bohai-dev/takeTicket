package com.example.takeTicket.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.takeTicket.domain.SpecialDishes;

public interface SpecialDishesMapper {
    int deleteByPrimaryKey(String dishId);

    int insert(SpecialDishes record);

    int insertSelective(SpecialDishes record);

    SpecialDishes selectByPrimaryKey(String dishId);

    int updateByPrimaryKeySelective(SpecialDishes record);

    int updateByPrimaryKey(SpecialDishes record);
    
    @Select("select * from SPECIAL_DISHES where SHOP_ID = #{shopId} and IS_DELETE = '0'")
    List<SpecialDishes> getSpecialDishes(@Param("shopId")String shopId);
}