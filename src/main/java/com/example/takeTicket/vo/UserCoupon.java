package com.example.takeTicket.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by cxy on 2018/11/19
 */

public class UserCoupon {
    private String custCouponId;

    private Long custId;

    private String shopId;

    private String couponId;

    private BigDecimal spendPoint;

    private Integer couponState;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String bakStr;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private String couponType;

    private String couponValue;


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

    @Override
    public String toString() {
        return "UserCoupon{" +
                "custCouponId='" + custCouponId + '\'' +
                ", custId=" + custId +
                ", shopId='" + shopId + '\'' +
                ", couponId='" + couponId + '\'' +
                ", spendPoint=" + spendPoint +
                ", couponState=" + couponState +
                ", createTime=" + createTime +
                ", bakStr='" + bakStr + '\'' +
                ", updateTime=" + updateTime +
                ", couponType='" + couponType + '\'' +
                ", couponValue='" + couponValue + '\'' +
                '}';
    }
}
