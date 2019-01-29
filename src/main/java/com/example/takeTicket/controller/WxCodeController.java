package com.example.takeTicket.controller;

import com.example.takeTicket.util.Constants;
import com.example.takeTicket.util.HttpUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by cxy on 2019/1/25
 */
@Controller
@RequestMapping("/qrcode")
public class WxCodeController {

    @RequestMapping("/getwxcode")
    public void getWxQRcode(@RequestParam("shopId") String shopId, @RequestParam(value = "width",defaultValue = "100") String width,
                            @RequestParam("userId") String userId, @RequestParam(value = "isForward",required = false,defaultValue = "0")String isForward,
                            HttpServletResponse httpServletResponse) {
        try {
        //获取access_token
        String accessToken=HttpUtil.get(Constants.SERVER_URL+"/access_token");
        System.out.println("取得token:"+accessToken);
        String codeUrl="https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token="+accessToken;
        Map<String,String> params=new HashMap<>();
        params.put("path","pages/storeDetail/storeDetail?params="+shopId+"&custId="+userId+"&isForward"+isForward);
        params.put("width",width);


            InputStream imageStream= HttpUtil.postStream(codeUrl,params);

            if (imageStream!=null){
                httpServletResponse.setContentType("image/jpg");
                OutputStream os = httpServletResponse.getOutputStream();
                int length = 0;
                byte[] buf = new byte[1024];

                while ((length = imageStream.read(buf)) > 0) {
                    os.write(buf, 0, length);
                }
                os.flush();
                os.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }



    }

}
