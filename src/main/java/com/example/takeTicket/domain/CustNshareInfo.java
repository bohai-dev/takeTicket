package com.example.takeTicket.domain;

import java.util.Date;

public class CustNshareInfo {
    private Long custId;

    private String shopId;

    private String shareStyle;

    private String controlFlg;

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

    public String getShareStyle() {
        return shareStyle;
    }

    public void setShareStyle(String shareStyle) {
        this.shareStyle = shareStyle == null ? null : shareStyle.trim();
    }

    public String getControlFlg() {
        return controlFlg;
    }

    public void setControlFlg(String controlFlg) {
        this.controlFlg = controlFlg == null ? null : controlFlg.trim();
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