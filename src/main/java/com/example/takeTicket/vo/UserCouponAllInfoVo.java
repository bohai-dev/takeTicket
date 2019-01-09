package com.example.takeTicket.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by cxy on 2018/11/19
 */

public class UserCouponAllInfoVo {
	// CUST_COUPON_RECORD 表
	private String custCouponId;

    private Long custId;

    private String shopId;

    private String couponId;

    private BigDecimal spendPoint;

    private Integer couponState;

    private Date createTime;

    private String bakStr;

    @JsonFormat(pattern="yyyy年MM月dd日")
    private Date updateTime;
    
    //COUPON 表
    
    private String couponType;

    private String couponValue;

    private String backupColumn1;

    private String backupColumn2;

    private String isDelete;

    private Long exchangeTimes;
    
    private String shopName;

	public String getCustCouponId() {
		return custCouponId;
	}

	public void setCustCouponId(String custCouponId) {
		this.custCouponId = custCouponId;
	}

	public Long getCustId() {
		return custId;
	}

	public void setCustId(Long custId) {
		this.custId = custId;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public BigDecimal getSpendPoint() {
		return spendPoint;
	}

	public void setSpendPoint(BigDecimal spendPoint) {
		this.spendPoint = spendPoint;
	}

	public Integer getCouponState() {
		return couponState;
	}

	public void setCouponState(Integer couponState) {
		this.couponState = couponState;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBakStr() {
		return bakStr;
	}

	public void setBakStr(String bakStr) {
		this.bakStr = bakStr;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public String getCouponValue() {
		return couponValue;
	}

	public void setCouponValue(String couponValue) {
		this.couponValue = couponValue;
	}

	public String getBackupColumn1() {
		return backupColumn1;
	}

	public void setBackupColumn1(String backupColumn1) {
		this.backupColumn1 = backupColumn1;
	}

	public String getBackupColumn2() {
		return backupColumn2;
	}

	public void setBackupColumn2(String backupColumn2) {
		this.backupColumn2 = backupColumn2;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public Long getExchangeTimes() {
		return exchangeTimes;
	}

	public void setExchangeTimes(Long exchangeTimes) {
		this.exchangeTimes = exchangeTimes;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
    
    
}
