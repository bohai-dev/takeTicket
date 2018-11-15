package com.example.takeTicket.exception;

/**
 * 优惠券异常类
 * @author caoxx
 *
 */
public class CouponException extends Exception {


    private final String errorCode;
    
    private final String errorMsg;

    public CouponException(CouponErrorConstant errorConstant) {
        this.errorCode=errorConstant.getErrorCode();
        this.errorMsg=errorConstant.getErrorMsg();
    }

    public CouponException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }


    @Override
    public String toString() {
        return "CouponException{" +
                "errorCode='" + errorCode + '\'' +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
