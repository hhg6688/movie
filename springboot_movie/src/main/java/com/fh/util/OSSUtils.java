package com.fh.util;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class OSSUtils {

    public static String uploadFile(MultipartFile image) throws IOException {
        //获取文件名
        String originalFilename = image.getOriginalFilename();

        String uuid = UUID.randomUUID().toString();
        String filePath=uuid+originalFilename;

        InputStream inputStream = image.getInputStream();

        String endpoint = "http://oss-cn-qingdao.aliyuncs.com";
        String endpointpath = "oss-cn-qingdao.aliyuncs.com";
        String accessKeyId = "LTAI4Fzk48Ah3cDFcTQqznp5";
        String accessKeySecret = "dJDLbirhKGSXimTuge3b6e8th0e9uX";
        String bucketName="1908a-huang";

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 创建PutObjectRequest对象。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName,filePath,inputStream);
        // 上传文件。
        PutObjectResult putObjectResult = ossClient.putObject(putObjectRequest);
        // 关闭OSSClient。
        ossClient.shutdown();
        return "http://"+bucketName+"."+endpointpath+"/"+filePath;
    }
}
