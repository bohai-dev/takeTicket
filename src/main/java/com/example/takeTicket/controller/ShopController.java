package com.example.takeTicket.controller;


import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.takeTicket.domain.Coupon;
import com.example.takeTicket.domain.Shop;
import com.example.takeTicket.exception.CouponErrorConstant;
import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.service.ShopService;
import com.example.takeTicket.util.HttpUtil;
import com.example.takeTicket.vo.ResponseBody;
import com.example.takeTicket.vo.ResponseHeader;
import com.example.takeTicket.vo.Shop2Vo;



@RestController
@RequestMapping("/shopInfo")
public class ShopController {

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(ShopController.class);
	
	@Autowired
	ShopService shopService;

	

	//按照分类及热点查询
    @RequestMapping(value="/selectbyconditions", method = RequestMethod.GET)
    public JSONObject selectByConditions(@RequestParam(value = "classId",required = false) String classId,@RequestParam(value = "isHot",required = false) String isHot) throws CouponException {
		LOGGER.info("classId="+classId+",isHot="+isHot);

		String httpUrl = "http://127.0.0.1:8088/export/shop/selectbyconditions";
		Map<String,String> params=new HashMap<>();
		if (StringUtils.isNotBlank(classId)){
			params.put("classId",classId);
		}
		if (StringUtils.isNotBlank(isHot)){
			params.put("isHot",isHot);
		}

		try {
			String result=HttpUtil.post(httpUrl,params);
			//ResponseBody<JSONObject> responseBody = new ResponseBody<JSONObject>();
			JSONObject jsonObject=JSON.parseObject(result);

			//responseBody.setData(jsonObject);

			return  jsonObject;
		} catch (Exception e) {
			e.printStackTrace();
			throw new CouponException(CouponErrorConstant.UNKNOW_EXCEPTION);

		}





    }
    
    //按照模糊字符串查询店铺名
    @RequestMapping(value="/likeShopStr", method = RequestMethod.GET)
    public ResponseBody<List<Shop>> likeShopStr(@RequestParam("shopStr") String shopStr) throws CouponException {

    	ResponseBody<List<Shop>> responseBody = new ResponseBody<>();
    	responseBody.setData(shopService.likeShopStr(shopStr));
    	
    	return responseBody;
    	
    	
    }
    
    //按照店铺ID
    @RequestMapping(value="/getShopInfo", method = RequestMethod.GET)
    public ResponseBody<Shop2Vo> getShopInfo(@RequestParam("shopId") String shopId) throws CouponException {

    	ResponseBody<Shop2Vo> responseBody = new ResponseBody<>();
    	responseBody.setData(shopService.getShopInfo(shopId));
    	
    	return responseBody;
    	
    	
    }
    
    //按照店铺名查找优惠
    @RequestMapping(value="/getShopIdfindCoupon", method = RequestMethod.GET)
    public ResponseBody<List<Coupon>> getShopIdfindCoupon(@RequestParam("shopId") String shopId) throws CouponException {

    	ResponseBody<List<Coupon>> responseBody = new ResponseBody<>();
    	responseBody.setData(shopService.getShopIdfindCoupon(shopId));
    	
    	return responseBody;
    	
    	
    }
    
    //店铺游览次数+num
    @RequestMapping(value="/addScanTime", method = RequestMethod.GET)
    public ResponseHeader addScanTime(@RequestParam("shopId") String shopId,@RequestParam("scanNum") BigDecimal scanNum) throws CouponException {

    	ResponseHeader responseHeader = new ResponseHeader();
    	shopService.addScanTime(shopId,scanNum);
    	
    	return responseHeader;
    	
    	
    }
    
    //根据地区查商铺
    @RequestMapping(value="/getShopConditions", method = RequestMethod.GET)
    public ResponseBody<List<Shop>> getShopConditions(@RequestParam("shopArea") String shopArea,@RequestParam("classId") String classId,@RequestParam("couponType") String couponType) throws CouponException {

    	ResponseBody<List<Shop>> responseBody = new ResponseBody<>();
    	responseBody.setData(shopService.getShopConditions(shopArea,classId,couponType));
    	
    	return responseBody;
    	
    	
    }


}
