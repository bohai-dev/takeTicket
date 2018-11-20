package com.example.takeTicket.util;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

/**
 * Cteated by cxy on 2018/9/19
 */
public class QrCode {

	/**
     * 生成二维码图片保存目录下
     * @param map
     * @param beanClass
     * @return
     * @throws Exception
     */
    public static String qrCodeEncode(String codeStr) throws Exception {
        String retPathStr = "";
        String filePath = "C://qrCode//";
        String fileName = codeStr + ".png";
        retPathStr = filePath + fileName;
        JSONObject json = new JSONObject();
        json.put("Code", codeStr);
        json.put("author", "Creativefun Technology");
        String content = json.toString();// 内容
        int width = 200; // 图像宽度
        int height = 200; // 图像高度
        String format = "png";// 图像类型
        Map<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, height, hints);// 生成矩阵
        Path path = FileSystems.getDefault().getPath(filePath, fileName);
        File file = new File(filePath + fileName);
        MatrixToImageWriter.writeToFile(bitMatrix, format, file);// 输出图像
        
		return retPathStr;
    	
    	
    }



}
