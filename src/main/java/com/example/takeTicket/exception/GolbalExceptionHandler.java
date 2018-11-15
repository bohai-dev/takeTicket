package com.example.takeTicket.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.takeTicket.vo.ResponseHeader;



/**
 * 全局异常处理类
 * @author caoxx
 *
 */
@ControllerAdvice
public class GolbalExceptionHandler {

    /** logger */
    private static final Logger LOGGER = LoggerFactory.getLogger(GolbalExceptionHandler.class);
    
    @ExceptionHandler(value = CouponException.class)
    @ResponseBody
    public ResponseHeader jsonErrorHandler(HttpServletRequest req, CouponException e) {
        ResponseHeader header = new ResponseHeader();
        header.setErrorCode(e.getErrorCode());
        header.setErrorMsg(e.getErrorMsg());

        LOGGER.error(header.toString());
        return header;
    }

}
