package com.example.takeTicket.service.impl;


import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import com.aliyun.oss.model.CompleteMultipartUploadResult;
import com.aliyun.oss.model.UploadFileRequest;
import com.aliyun.oss.model.UploadFileResult;
import com.example.takeTicket.dao.CouponMapper;
import com.example.takeTicket.dao.CustCouponRecordMapper;
import com.example.takeTicket.dao.custPointRecordMapper;
import com.example.takeTicket.domain.Coupon;
import com.example.takeTicket.domain.CustCouponRecord;
import com.example.takeTicket.exception.CouponErrorConstant;
import com.example.takeTicket.exception.CouponException;
import com.example.takeTicket.service.ChangeCouponService;
import com.example.takeTicket.util.QrCode;

/**
 * Cteated by caoxx on 2018/11/6
 */
@Service
public class ChangeCouponServiceImpl  implements ChangeCouponService {
	
	private static String endpoint = "http://oss-cn-shanghai.aliyuncs.com";

    private static String accessKeyId = "LTAIJsHDuEGbjkTy";

    private static String accessKeySecret = "ggk7r1WoKRSofcJmgzrql3nsuLvHrn";
    
    private static String bucketName = "qrcodeqs";

    @Autowired
    CouponMapper couponMapper;

    @Autowired
    CustCouponRecordMapper custCouponRecordMapper;
    
    @Autowired
    custPointRecordMapper custPointRecordMapper;

	@Override
	public CustCouponRecord custChangeCoupon(String custId, String shopId, String couponId) throws CouponException {
		CustCouponRecord custCouponRecordRet = new CustCouponRecord();
		
		//得到唯一SEQ
		int reti = custCouponRecordMapper.selCustCouponIDSeq();
		String custCouponId = "U" + String.format("%09d", reti);
		custCouponRecordRet.setCustCouponId(custCouponId);
		custCouponRecordRet.setCustId(Long.valueOf(custId));
		custCouponRecordRet.setShopId(shopId);
		custCouponRecordRet.setCouponId(couponId);
		custCouponRecordRet.setCreateTime(new Date());
		custCouponRecordRet.setCouponState(0);
		
		Coupon coupon = couponMapper.selectByPrimaryKey(couponId);
		
		BigDecimal spendPoint = new BigDecimal(0);
		spendPoint = BigDecimal.valueOf(coupon.getExchangeTimes());
		String qrCodePngPath = "";
		//生成二维码图片
		try {
			qrCodePngPath = QrCode.qrCodeEncode(custCouponId);
		} catch (Exception e) {
			throw new CouponException(CouponErrorConstant.QRCODE_PNG_ERROR);
		}
		
		//OSS 上传PNG文件
		
		String qrCodeUrl = uploadOSS(custCouponId + ".png",qrCodePngPath);
		
		custCouponRecordRet.setBakStr(qrCodeUrl);
				
		custCouponRecordRet.setSpendPoint(spendPoint);
		
		custCouponRecordMapper.insertSelective(custCouponRecordRet);
		
		//用户积分扣除
		custPointRecordMapper.subPoint(custId, shopId, spendPoint);
		
		
		
		return custCouponRecordRet;
	}


	String uploadOSS(String key,String uploadFile) {
   	 
   	 OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        String retStr = "";

        try {

            UploadFileRequest uploadFileRequest = new UploadFileRequest(bucketName, key);

            // The local file to upload---it must exist.

            uploadFileRequest.setUploadFile(uploadFile);

            // Sets the concurrent upload task number to 5.

            uploadFileRequest.setTaskNum(5);

            // Sets the part size to 1MB.

            uploadFileRequest.setPartSize(1024 * 1024 * 1);

            // Enables the checkpoint file. By default it's off.

            uploadFileRequest.setEnableCheckpoint(true);

            

            UploadFileResult uploadResult = ossClient.uploadFile(uploadFileRequest);

            

            CompleteMultipartUploadResult multipartUploadResult = 

                    uploadResult.getMultipartUploadResult();

            System.out.println(multipartUploadResult.getETag());
            
            retStr = multipartUploadResult.getLocation();

            

        } catch (OSSException oe) {

            System.out.println("Caught an OSSException, which means your request made it to OSS, "

                    + "but was rejected with an error response for some reason.");

            System.out.println("Error Message: " + oe.getErrorCode());

            System.out.println("Error Code:       " + oe.getErrorCode());

            System.out.println("Request ID:      " + oe.getRequestId());

            System.out.println("Host ID:           " + oe.getHostId());

        } catch (ClientException ce) {

            System.out.println("Caught an ClientException, which means the client encountered "

                    + "a serious internal problem while trying to communicate with OSS, "

                    + "such as not being able to access the network.");

            System.out.println("Error Message: " + ce.getMessage());

        } catch (Throwable e) {

            e.printStackTrace();

        } finally {

            ossClient.shutdown();

        }
		return retStr;
   
   }
	


    
}
