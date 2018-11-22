package com.example.takeTicket.domain;

import java.util.Date;

public class CustShareInfo {
    private Long custId;

    private String shopId;

    private Date shareTime;

    private String bakStr;

    private String bakFlg;

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

    public Date getShareTime() {
        return shareTime;
    }

    public void setShareTime(Date shareTime) {
        this.shareTime = shareTime;
    }

    public String getBakStr() {
        return bakStr;
    }

    public void setBakStr(String bakStr) {
        this.bakStr = bakStr == null ? null : bakStr.trim();
    }

    public String getBakFlg() {
        return bakFlg;
    }

    public void setBakFlg(String bakFlg) {
        this.bakFlg = bakFlg == null ? null : bakFlg.trim();
    }
}