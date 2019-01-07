package com.example.takeTicket.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.service.CustShareService;
import com.example.takeTicket.vo.ResponseBody;
import com.example.takeTicket.vo.ResponseHeader;
import com.example.takeTicket.vo.Shop3Vo;







@RestController
@RequestMapping("/custShare")
public class CustShareController {

	@Autowired
	CustShareService custShareService;
	    
    // 客户分享登入
    @RequestMapping(value="/custShareInfo", method = RequestMethod.GET)
    public ResponseHeader custShareInfo(@RequestParam("custId") String custId,@RequestParam("shopId") String shopId) throws CouponException {
    	Logger logger = LoggerFactory.getLogger(CustUserController.class);
    	ResponseHeader responseHeader = new ResponseHeader();
    	custShareService.custShareInfo(custId, shopId);
    	
		return responseHeader;
    	
    }
    
 // 客户分享记录列表
    @RequestMapping(value="/getCustShareList", method = RequestMethod.GET)
    public ResponseBody<List<Shop3Vo>> getCustShareList(@RequestParam("custId") String custId) throws CouponException {
    	Logger logger = LoggerFactory.getLogger(CustUserController.class);
    	ResponseBody<List<Shop3Vo>> ResponseBodyret = new ResponseBody<>();
    	ResponseBodyret.setData(custShareService.getCustShareList(custId));
    	
		return ResponseBodyret;
    	
    }
   


}
