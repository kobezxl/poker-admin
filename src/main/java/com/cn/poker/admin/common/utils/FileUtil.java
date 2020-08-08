package com.cn.poker.admin.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * @desc 文件上传类
 */
public class FileUtil {

    /**
     * 文件上传
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if(!targetFile.exists()){
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath+fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    /**
     * 删除文件
     * @param filePathAndName
     */
    public static void delFile(String filePathAndName) throws Exception {
        String filePath = filePathAndName;
        filePath = filePath.toString();
        File myDelFile = new File(filePath);
        myDelFile.delete();
    }

    public static void copyFile(String oldPath, String newPath) throws Exception {
             int  byteread  =  0;
            File  oldfile  =  new  File(oldPath);
            if  (oldfile.exists()) {  //文件存在时
                InputStream inStream = new FileInputStream(oldPath);  //读入原文件
                FileOutputStream fs = new FileOutputStream(newPath);
                byte[] buffer = new byte[1444];
//               int  length;
                while ((byteread = inStream.read(buffer)) != -1) {
//                   bytesum  +=  byteread;  //字节数  文件大小
//                   System.out.println(bytesum);
                    fs.write(buffer, 0, byteread);
                }
                inStream.close();
            }
    }

    public static void moveFile(String oldPath, String newPath) throws Exception{
        copyFile(oldPath, newPath);
        delFile(oldPath);
    }

    /**
     * 获取文件名后缀
     * @param fileName
     * @return
     * @throws Exception
     */
    public static String getFileSuff(String fileName) throws Exception{
        String[] fileNames = StringUtils.split(fileName, ".");
        if(fileNames.length > 0){
            return fileNames[fileNames.length - 1];
        }
        return "";
    }
    
    public static final String TYPE_JPG = "jpg";
    public static final String TYPE_GIF = "gif";
    public static final String TYPE_PNG = "png";
    public static final String TYPE_BMP = "bmp";
    public static final String TYPE_UNKNOWN = "unknown";
    
    /**
     * byte数组转换成16进制字符串
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src){    
           StringBuilder stringBuilder = new StringBuilder();    
           if (src == null || src.length <= 0) {    
               return null;    
           }    
           for (int i = 0; i < src.length; i++) {    
               int v = src[i] & 0xFF;    
               String hv = Integer.toHexString(v);    
               if (hv.length() < 2) {    
                   stringBuilder.append(0);    
               }    
               stringBuilder.append(hv);    
           }    
           return stringBuilder.toString();    
       }

    /**
     * 根据文件流判断图片类型
     * @param fis
     * @return jpg/png/gif/bmp
     */
    public static String isImage(InputStream fis) {
        //读取文件的前几个字节来判断图片格式
        byte[] b = new byte[4];
        try {
            fis.read(b, 0, b.length);
            String type = bytesToHexString(b).toUpperCase();
            if (type.contains("FFD8FF")) {
                return TYPE_JPG;
            } else if (type.contains("89504E47")) {
                return TYPE_PNG;
            } else if (type.contains("47494638")) {
                return TYPE_GIF;
            } else if (type.contains("424D")) {
                return TYPE_BMP;
            }else{
                return TYPE_UNKNOWN;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
    
}
