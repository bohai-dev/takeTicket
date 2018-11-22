package com.example.takeTicket.controller;


import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.takeTicket.domain.CustPointRecord;
import com.example.takeTicket.domain.GetPointRecord;
import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.service.PointService;
import com.example.takeTicket.vo.GetPointRecordVo;
import com.example.takeTicket.vo.ResponseBody;
import com.example.takeTicket.vo.ResponseHeader;







@RestController
@RequestMapping("/UserPoint")
public class UserPointController {

	@Autowired
	PointService pointService;
	

	//据客户ID和商铺ID查该商铺的积分
    @RequestMapping(value="/getPoint", method = RequestMethod.GET)
    public ResponseBody<CustPointRecord> getPoint(@RequestParam("custId") String custId,@RequestParam("shopId") String shopId) throws CouponException {

		Logger logger = LoggerFactory.getLogger(CustUserController.class);
		ResponseBody<CustPointRecord> responseBody = new ResponseBody<CustPointRecord>();
		responseBody.setData(pointService.getPoint(custId, shopId));
		
        
		return responseBody;
    }
    
    
    //据客户ID和商铺ID增加商铺的积分
    @RequestMapping(value="/addPoint", method = RequestMethod.GET)
    public ResponseHeader addPoint(@RequestParam("custId") String custId,@RequestParam("shopId") String shopId,@RequestParam("pointNum") BigDecimal pointNum) throws CouponException {

		Logger logger = LoggerFactory.getLogger(CustUserController.class);
		ResponseHeader responseHeader = new ResponseHeader();
		pointService.addPoint(custId, shopId,pointNum);
		
        
		return responseHeader;
    }
    
    //据客户ID和商铺ID减少商铺的积分
    @RequestMapping(value="/subPoint", method = RequestMethod.GET)
    public ResponseHeader subPoint(@RequestParam("custId") String custId,@RequestParam("shopId") String shopId,@RequestParam("subPointNum") BigDecimal subPointNum) throws CouponException {

		Logger logger = LoggerFactory.getLogger(CustUserController.class);
		ResponseHeader responseHeader = new ResponseHeader();
		pointService.subPoint(custId, shopId,subPointNum);
		
        
		return responseHeader;
    }
    
    //记录客户积分明细
    @RequestMapping(value="/addPointInfo", method = RequestMethod.POST)
    public ResponseHeader addPointInfo(@RequestBody GetPointRecordVo getPointRecordVo) throws CouponException {

		Logger logger = LoggerFactory.getLogger(CustUserController.class);
		
		GetPointRecord getPointRecord = new GetPointRecord();
		getPointRecord.setCustId(Long.valueOf(getPointRecordVo.getCustId()));
		getPointRecord.setShopId(getPointRecordVo.getShopId());
		getPointRecord.setChildId(Long.valueOf(getPointRecordVo.getChildId()));
		getPointRecord.setRecordFlg(Short.valueOf(getPointRecordVo.getRecordFlg()));
		getPointRecord.setCreateTime(new Date());
		getPointRecord.setBakStr(getPointRecordVo.getBakStr());
		
		
		
		ResponseHeader responseHeader = new ResponseHeader();
		pointService.addPointInfo(getPointRecord);
		
        
		return responseHeader;
    }
    
    //判断是否是重复客户登入，重复客户登入时不应该积分
    @RequestMapping(value="/checkPointInfo", method = RequestMethod.GET)
    public ResponseBody<Integer> checkPointInfo(@RequestParam("custId") String custId,@RequestParam("shopId") String shopId,@RequestParam("childId") String childId) throws CouponException {
		Logger logger = LoggerFactory.getLogger(CustUserController.class);
		
		
		GetPointRecord getPointRecord = new GetPointRecord();
		getPointRecord.setCustId(Long.valueOf(custId));
		getPointRecord.setShopId(shopId);
		getPointRecord.setChildId(Long.valueOf(childId));
		Short i = 0;
		getPointRecord.setRecordFlg(i);
		getPointRecord.setCreateTime(new Date());
		getPointRecord.setBakStr("");
		
		
		ResponseBody<Integer> ret = new ResponseBody<Integer>();
		ret.setData(pointService.checkPointInfo(getPointRecord));
		
		//返回1为正确可以+1积分
		return ret;
    }
    
    //增加客户登入时积分入库明细
    @RequestMapping(value="/addCheckPointInfo", method = RequestMethod.GET)
    public ResponseBody<Integer> addCheckPointInfo(@RequestParam("custId") String custId,@RequestParam("shopId") String shopId,@RequestParam("childId") String childId) throws CouponException {
		Logger logger = LoggerFactory.getLogger(CustUserController.class);
		
		
		GetPointRecord getPointRecord = new GetPointRecord();
		getPointRecord.setCustId(Long.valueOf(custId));
		getPointRecord.setShopId(shopId);
		getPointRecord.setChildId(Long.valueOf(childId));
		Short i = 0;
		getPointRecord.setRecordFlg(i);
		getPointRecord.setCreateTime(new Date());
		getPointRecord.setBakStr("");
		
		ResponseHeader responseHeader = new ResponseHeader();
		
		ResponseBody<Integer> ret = new ResponseBody<Integer>();
		ret.setData(pointService.addCheckPointInfo(getPointRecord));
		
		
		return ret;
    }
    
    // 查询成功分享次数
    @RequestMapping(value="/selectPointNum", method = RequestMethod.GET)
    public ResponseBody<Integer> selectPointNum(@RequestParam("custId") String custId,@RequestParam("shopId") String shopId) throws CouponException {
		Logger logger = LoggerFactory.getLogger(CustUserController.class);
		
		
		ResponseBody<Integer> ret = new ResponseBody<Integer>();
		ret.setData(pointService.selectPointNum(custId,shopId));
		
		
		return ret;
    }
    
    


}
