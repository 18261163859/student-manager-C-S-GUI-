package com.smx.sm.utils;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;

import java.io.File;
import java.util.UUID;

/**
 * @ClassName AliOSSUtil
 * @Description TODO
 * @Author moses
 * @Date 2020/11/26
 **/
public class AliOSSUtil {
    /**
     *将本地file上传到阿里云指定的域名下，并用UUID重命名
     * @param file 待传文件
     * @return String 上传返回url
     */
    public static String ossUpload(File file){
        String bucketDomain="*********************";
        String  endpoint="*********************";
        String accessKeyId="*********************";
        String accessKeySecret="*********************";
        String bucketName="*********************";
        String fileDir="logo/";
        String  fileName=file.getName();
        String fileKey= UUID.randomUUID().toString()+fileName.substring(fileName.indexOf("."));
        OSS ossClient =new OSSClientBuilder().build(endpoint,accessKeyId,accessKeySecret);
        ossClient.putObject(bucketName,fileDir+fileKey,file);
        ossClient.shutdown();
        return bucketDomain+fileDir+fileKey;
    }

    public static void main(String[] args) {

    }
}
