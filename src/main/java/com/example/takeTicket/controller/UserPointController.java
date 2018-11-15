package com.example.takeTicket.controller;


import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.takeTicket.domain.CustPointRecord;
import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.service.PointService;
import com.example.takeTicket.vo.ResponseBody;
import com.example.takeTicket.vo.ResponseHeader;


@Controller
@RequestMapping("/UserPoint")
public class UserPointController {

	@Autowired
	PointService pointService;
	

	//据客户ID和商铺ID查改商铺的积分
    @RequestMapping(value="/getPoint", method = RequestMethod.GET)
    public ResponseBody<CustPointRecord> getPoint(@RequestParam("custId") String custId,@RequestParam("shopId") String shopId) throws CouponException {

		Logger logger = LoggerFactory.getLogger(CustUserController.class);
		ResponseBody<CustPointRecord> responseBody = new ResponseBody<CustPointRecord>();
		responseBody.setData(pointService.getPoint(custId, shopId));
		
        
		return responseBody;
    }
    
    
    //据客户ID和商铺ID查改商铺的积分
    @RequestMapping(value="/addPoint", method = RequestMethod.GET)
    public ResponseHeader addPoint(@RequestParam("custId") String custId,@RequestParam("shopId") String shopId,@RequestParam("pointNum") BigDecimal pointNum) throws CouponException {

		Logger logger = LoggerFactory.getLogger(CustUserController.class);
		ResponseHeader responseHeader = new ResponseHeader();
		pointService.addPoint(custId, shopId,pointNum);
		
        
		return responseHeader;
    }
    
    //据客户ID和商铺ID查改商铺的积分
    @RequestMapping(value="/subPoint", method = RequestMethod.GET)
    public ResponseHeader subPoint(@RequestParam("custId") String custId,@RequestParam("shopId") String shopId,@RequestParam("subPointNum") BigDecimal subPointNum) throws CouponException {

		Logger logger = LoggerFactory.getLogger(CustUserController.class);
		ResponseHeader responseHeader = new ResponseHeader();
		pointService.subPoint(custId, shopId,subPointNum);
		
        
		return responseHeader;
    }
    
   


}
