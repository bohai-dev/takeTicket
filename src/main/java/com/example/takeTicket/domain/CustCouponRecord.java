package com.example.takeTicket.domain;

import java.math.BigDecimal;
import java.util.Date;

public class CustCouponRecord {
    private String custCouponId;

    private Long custId;

    private String shopId;

    private String couponId;

    private BigDecimal spendPoint;

    private Integer couponState;

    private Date createTime;

    private String bakStr;

    private Date updateTime;

    public String getCustCouponId() {
        return custCouponId;
    }

    public void setCustCouponId(String custCouponId) {
        this.custCouponId = custCouponId == null ? null : custCouponId.trim();
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
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
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
        this.bakStr = bakStr == null ? null : bakStr.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}