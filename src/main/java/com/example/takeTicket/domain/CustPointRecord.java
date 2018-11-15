package com.example.takeTicket.domain;

import java.math.BigDecimal;
import java.util.Date;

public class CustPointRecord {
    private Long custId;

    private String shopId;

    private BigDecimal pointNumber;

    private BigDecimal pointSub;

    private Short pointState;

    private Date createTime;

    private Date updateTime;

    private String bakStr;

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

    public BigDecimal getPointNumber() {
        return pointNumber;
    }

    public void setPointNumber(BigDecimal pointNumber) {
        this.pointNumber = pointNumber;
    }

    public BigDecimal getPointSub() {
        return pointSub;
    }

    public void setPointSub(BigDecimal pointSub) {
        this.pointSub = pointSub;
    }

    public Short getPointState() {
        return pointState;
    }

    public void setPointState(Short pointState) {
        this.pointState = pointState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBakStr() {
        return bakStr;
    }

    public void setBakStr(String bakStr) {
        this.bakStr = bakStr == null ? null : bakStr.trim();
    }
}