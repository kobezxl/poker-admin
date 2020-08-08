package com.cn.poker.admin.modules.generator.utils;


import com.cn.poker.admin.PokerAdminApplication;
import com.cn.poker.admin.common.utils.FileUtil;
import com.cn.poker.admin.common.utils.SFtpUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.apache.log4j.Logger;

/**
 * 图片上传工具类
 *
 */
public class UploadUtils {
	
	private final static Logger log = Logger.getLogger(UploadUtils.class);
	
	/**
	 * 图片上传
	 * @param upLoadPath 图片服务器路径
	 * @param uplodUrl 图片服务器url
	 * @param file 图片
	 * @return
	 */
	public static String upload(String upLoadPath,String uplodUrl,MultipartFile file) {
		log.info("开始图片上传公共方法");
		try {
			//获得文件对象
			String result = FileUtil.isImage(file.getInputStream());
			//判断是否为图片
			if ("unknown".equals(result) && StringUtils.isNotBlank(result)) {
				return "-1";
			}

	        //获取图片信息
	        String fileName = file.getOriginalFilename();// 获取文件名
	        log.info("上传的文件名为：" + fileName);
	        String suffixName = fileName.substring(fileName.lastIndexOf("."));// 获取文件的后缀名
	        log.info("上传的后缀名为：" + suffixName);
	        String filePath = "";//图片目录
	        fileName = System.currentTimeMillis() + suffixName;
	        
	        //上传到服务器
	        boolean uploadResult = PokerAdminApplication.ac.getBean(SFtpUtils.class).uploadFile(upLoadPath, filePath, fileName, file.getInputStream());
            if(!uploadResult){
            	log.info("图片上传到服务器失败>>>" + filePath + fileName);
                return "-1";
            }
            
            //拼接url
            String url = uplodUrl + fileName;
            log.info("图片上传公共方法结束");
            return url;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "-1";
	}
	
}
