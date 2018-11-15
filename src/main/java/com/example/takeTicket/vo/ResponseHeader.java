package com.example.takeTicket.vo;

import com.example.takeTicket.exception.CouponErrorConstant;

public class ResponseHeader {

    private String errorCode = CouponErrorConstant.SUCCESS.getErrorCode();
    
    private String errorMsg=CouponErrorConstant.SUCCESS.getErrorMsg();


    public ResponseHeader() {
    }

    public ResponseHeader(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "ResponseHeader{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
