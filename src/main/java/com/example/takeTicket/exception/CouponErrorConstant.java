package com.example.takeTicket.exception;

/**
 * 错误信息
 * @author caoxx
 *
 */
public enum CouponErrorConstant {
    
    SUCCESS("0000", "ok"),

    LOGIN_WEIXIN_ERROR("0001","微信登录异常"),
    QRCODE_PNG_ERROR("0001","二维码生成PNG图片错误"),

    


    UNKNOW_EXCEPTION("1000", "程序内部异常" );
    
    final String errorCode;
    
    final String errorMsg;
    

    
    private CouponErrorConstant(String errorCode , String errorMsg){
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
