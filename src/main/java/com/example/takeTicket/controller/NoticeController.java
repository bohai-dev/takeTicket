package com.example.takeTicket.controller;

import com.example.takeTicket.exception.CouponErrorConstant;
import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.util.Constants;
import com.example.takeTicket.util.HttpUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by cxy on 2019/3/27
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {

    @GetMapping
    public String selectNotice() throws CouponException{
        String noticeUrl=Constants.SERVER_URL+"/notice";
        try {
            String content=HttpUtil.get(noticeUrl);
            return content;
        } catch (Exception e) {
          //  e.printStackTrace();
            throw new CouponException(CouponErrorConstant.UNKNOW_EXCEPTION);
        }
    }
}
