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
import com.example.takeTicket.vo.CustCanExchangeCouponVo;
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
    
    // 客户可兑换优惠一览
    @RequestMapping(value="/getCustCanExchangeCouponList", method = RequestMethod.GET)
    public ResponseBody<List<CustCanExchangeCouponVo>> getCustCanExchangeCouponList(@RequestParam("custId") String custId) throws CouponException {
    	Logger logger = LoggerFactory.getLogger(CustUserController.class);
    	ResponseBody<List<CustCanExchangeCouponVo>> ResponseBodyret = new ResponseBody<>();
    	ResponseBodyret.setData(custShareService.getCustCanExchangeCouponList(custId));
    	
		return ResponseBodyret;
    	
    }
    
    // 客户分享记录插入，给朋友的是01 ，保存长图发朋友圈的是05
    @RequestMapping(value="/insCustShareInfo", method = RequestMethod.GET)
    public ResponseHeader insCustShareInfo(@RequestParam("custId") String custId,@RequestParam("shopId") String shopId,@RequestParam("shareStyle") String shareStyle) throws CouponException {
    	Logger logger = LoggerFactory.getLogger(CustUserController.class);
    	ResponseHeader responseHeader = new ResponseHeader();
    	custShareService.insCustShareInfo(custId, shopId,shareStyle);
    	
		return responseHeader;
    	
    }
    
    // 客户分享记录更新，‘1’为无效
    @RequestMapping(value="/updShareStatue", method = RequestMethod.GET)
    public ResponseHeader updShareStatue(@RequestParam("shareStyle") String shareStyle) throws CouponException {
    	Logger logger = LoggerFactory.getLogger(CustUserController.class);
    	ResponseHeader responseHeader = new ResponseHeader();
    	custShareService.updShareStatue(shareStyle);
    	
		return responseHeader;
    	
    }
    
    // 客户分享记录加分前的CHECK
    @RequestMapping(value="/checkShareStatue", method = RequestMethod.GET)
    public ResponseBody<String> checkShareStatue(@RequestParam("custId") String custId,@RequestParam("shopId") String shopId,@RequestParam("shareStyle") String shareStyle) throws CouponException {
    	Logger logger = LoggerFactory.getLogger(CustUserController.class);
    	ResponseBody<String> ResponseBodyret = new ResponseBody<String>();
    	ResponseBodyret.setData(custShareService.checkShareStatue(custId, shopId,shareStyle));
    	
		return ResponseBodyret;
    	
    }


}
