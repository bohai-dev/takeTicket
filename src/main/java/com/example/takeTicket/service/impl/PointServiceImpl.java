package com.example.takeTicket.service.impl;


import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.takeTicket.dao.CustCouponRecordMapper;
import com.example.takeTicket.dao.custPointRecordMapper;
import com.example.takeTicket.dao.getPointRecordMapper;
import com.example.takeTicket.domain.CustPointRecord;
import com.example.takeTicket.domain.GetPointRecord;
import com.example.takeTicket.service.PointService;

/**
 * Cteated by caoxx on 2018/11/6
 */
@Service
public class PointServiceImpl  implements PointService {

    @Autowired
    CustCouponRecordMapper custCouponRecordMapper;

    @Autowired
    custPointRecordMapper custPointRecordMapper;
    
    @Autowired
    getPointRecordMapper getPointRecordMapper;

	
	@Override
	public CustPointRecord getPoint(String custId, String shopId) {
		CustPointRecord custPointRecordRet = new CustPointRecord();
		custPointRecordRet = custPointRecordMapper.getPoint(new BigDecimal(custId), shopId);
		return custPointRecordRet;
	}


	@Override
	public void addPoint(String custId, String shopId, BigDecimal pointNum) {
		CustPointRecord custPointRecordRet = new CustPointRecord();
		custPointRecordRet = getPoint(custId,shopId);
		if("".equals(custPointRecordRet.getCustId())){
			//插入新数据
			custPointRecordRet.setCustId(Long.valueOf(custId));
			custPointRecordRet.setPointNumber(pointNum);
			custPointRecordRet.setShopId(shopId);
			Long i = (long) 0;
			custPointRecordRet.setPointState(i);
			custPointRecordMapper.insertSelective(custPointRecordRet);
		} else {
			//更新记录
			custPointRecordMapper.addPoint(new BigDecimal(custId), shopId, pointNum);
		}
		
		
	}


	@Override
	public void subPoint(String custId, String shopId, BigDecimal subPointNum) {
		
		//兑换时用，应该不可能存在记录没有的情况
		custPointRecordMapper.subPoint(new BigDecimal(custId), shopId, subPointNum);
		
	}


	@Override
	public void addPointInfo(GetPointRecord getPointRecord) {
		getPointRecordMapper.insertSelective(getPointRecord);
		
	}


	@Override
	public Integer checkPointInfo(GetPointRecord getPointRecord) {
		System.out.println("CustId():" + getPointRecord.getCustId() + "|ShopId():" + getPointRecord.getShopId() + "|ChildId():" + getPointRecord.getChildId());
		GetPointRecord getPointRecordret = new GetPointRecord();
		getPointRecordret = getPointRecordMapper.checkPointInfo(new BigDecimal(getPointRecord.getCustId()),getPointRecord.getShopId(),new BigDecimal(getPointRecord.getChildId()));
		Integer retInt = new Integer(0);
		
		if(null == getPointRecordret){
			//返回1为正确可以+1积分
			return 1;
		}
		
		return retInt;
	}


	@Override
	public Integer addCheckPointInfo(GetPointRecord getPointRecord) {
		
		if(checkPointInfo(getPointRecord) ==1 )
		{
		
			System.out.println("CustId():" + getPointRecord.getCustId() + "|ShopId():" + getPointRecord.getShopId() + "|ChildId():" + getPointRecord.getChildId());
			
			//明细加一
			getPointRecordMapper.insertSelective(getPointRecord);
			
			//先SELECT 如果没有则 insert
			CustPointRecord custPointRecord = new CustPointRecord();
			custPointRecord = custPointRecordMapper.getPoint(new BigDecimal(getPointRecord.getCustId()),getPointRecord.getShopId());
			
			if(null == custPointRecord){
				custPointRecord = new CustPointRecord();
				custPointRecord.setCustId(getPointRecord.getCustId());
				custPointRecord.setShopId(getPointRecord.getShopId());
				custPointRecord.setPointNumber(new BigDecimal(1));
				custPointRecord.setPointSub(new BigDecimal(0));
				custPointRecord.setCreateTime(new Date());
				Long i = (long) 0;
				custPointRecord.setPointState(i);
				custPointRecord.setBakStr("");
				
				
				custPointRecordMapper.insertSelective(custPointRecord);
			} else {
				//客户合计POINT+ 1
				custPointRecordMapper.addPoint(new BigDecimal(getPointRecord.getCustId()), getPointRecord.getShopId(), new BigDecimal(1));
			}
			
			
		}
		
	    
		int reti = getPointRecordMapper.selectPointNum(new BigDecimal(getPointRecord.getCustId()), getPointRecord.getShopId());
		
		return reti;
	}


	@Override
	public Integer selectPointNum(String custId, String shopId) {
		int reti = getPointRecordMapper.selectPointNum(new BigDecimal(custId), shopId);
		
		return reti;
	}

	

    
}
