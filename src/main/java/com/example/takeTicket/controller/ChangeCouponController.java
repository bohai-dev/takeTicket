package com.example.takeTicket.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.takeTicket.domain.CustCouponRecord;
import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.service.ChangeCouponService;
import com.example.takeTicket.vo.ResponseBody;



@RestController
@RequestMapping("/changeCoupon")
public class ChangeCouponController {

	/** logger */
	private static final Logger LOGGER = LoggerFactory.getLogger(ChangeCouponController.class);
	
	@Autowired
	ChangeCouponService changeCouponService;

    
    //客户兑换优惠券
    @RequestMapping(value="/custChangeCoupon", method = RequestMethod.GET)
    public ResponseBody<CustCouponRecord> custChangeCoupon(@RequestParam("custId") String custId,@RequestParam("shopId") String shopId,
														   @RequestParam("couponId") String couponId,@RequestParam("formId") String formId) throws CouponException {

    	ResponseBody<CustCouponRecord> responseBody = new ResponseBody<>();
    	responseBody.setData(changeCouponService.custChangeCoupon(custId,shopId,couponId,formId));
    	
    	return responseBody;
    	
    	
    }
    
   


}
