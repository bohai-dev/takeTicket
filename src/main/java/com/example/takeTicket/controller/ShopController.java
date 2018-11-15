package com.example.takeTicket.controller;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.takeTicket.domain.Coupon;
import com.example.takeTicket.domain.Shop;
import com.example.takeTicket.exception.MilkTeaException;
import com.example.takeTicket.service.ShopService;
import com.example.takeTicket.util.HttpUtil;
import com.example.takeTicket.vo.ResponseBody;
import com.example.takeTicket.vo.ResponseHeader;


@Controller
@RequestMapping("/shopInfo")
public class ShopController {

	@Autowired
	ShopService shopService;
	

	//按照分类及热点查询
    @RequestMapping(value="/selectbyconditions", method = RequestMethod.GET)
    public ResponseBody<JSONObject> selectByConditions(@RequestParam("classId") String classId,@RequestParam("isHot") String isHot) throws MilkTeaException{



		Logger logger = LoggerFactory.getLogger(UserLoginController.class);
		ResponseBody<JSONObject> responseBody = new ResponseBody<JSONObject>();
		JSONObject jsonObject = new JSONObject();
		String path = "http://localhost:8088/selectbyconditions"; 

		try {

			HttpUtil HttpUtil = new HttpUtil();
			Map<String,String> mapParam = new HashMap<String,String>();
			if(!"".equals(classId)){
				mapParam.put("classId", classId);
			} else {
				mapParam.put("isHot", isHot);
			}
			String retStr = HttpUtil.post(path, mapParam);
			System.out.println(retStr);
			jsonObject = JSON.parseObject(retStr);
	        responseBody.setData(jsonObject);
			
          
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        
		return responseBody;
    }
    
    //按照模糊字符串查询店铺名
    @RequestMapping(value="/likeShopStr", method = RequestMethod.GET)
    public ResponseBody<List<Shop>> likeShopStr(@RequestParam("shopStrYOUHUI") String shopStr) throws MilkTeaException{

    	ResponseBody<List<Shop>> responseBody = new ResponseBody<>();
    	responseBody.setData(shopService.likeShopStr(shopStr));
    	
    	return responseBody;
    	
    	
    }
    
    //按照店铺名查找优惠
    @RequestMapping(value="/getShopIdfindCoupon", method = RequestMethod.GET)
    public ResponseBody<List<Coupon>> getShopIdfindCoupon(@RequestParam("shopId") String shopId) throws MilkTeaException{

    	ResponseBody<List<Coupon>> responseBody = new ResponseBody<>();
    	responseBody.setData(shopService.getShopIdfindCoupon(shopId));
    	
    	return responseBody;
    	
    	
    }
    
    //店铺游览次数+num
    @RequestMapping(value="/addScanTime", method = RequestMethod.GET)
    public ResponseHeader addScanTime(@RequestParam("shopId") String shopId,@RequestParam("scanNum") BigDecimal scanNum) throws MilkTeaException{

    	ResponseHeader responseHeader = new ResponseHeader();
    	shopService.addScanTime(shopId,scanNum);
    	
    	return responseHeader;
    	
    	
    }


}
