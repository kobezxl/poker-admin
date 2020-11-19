package com.cn.poker.admin.modules.picture.service.impl;

import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.common.utils.CommonUtils;
import com.cn.poker.admin.modules.generator.utils.UploadUtils;
import com.cn.poker.admin.modules.picture.entity.PictureReceive;
import com.cn.poker.admin.modules.picture.entity.RichText;
import com.cn.poker.admin.modules.picture.entity.SysPrictureConfig;
import com.cn.poker.admin.modules.picture.service.SysPictureService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Map;

@Service("sysPictureService")
public class SysPictureServiceImpl implements SysPictureService {
	
	private final static Logger log = Logger.getLogger(SysPictureServiceImpl.class);
	
//	@Value("${upload.pictureIP}")
//	private String pictureIP;
	
	@Autowired
	private SysPrictureConfig sysPrictureConfig;


	/**
	 * 富文本图片上传
	 */
	@Override
	public RichText uploadUrl(MultipartFile file) {
		log.info("开始富文本图片上传");
		String uploadPath = sysPrictureConfig.getUploadMap().get("cmsArticlePath");
//		String uploadUrl = pictureIP + sysPrictureConfig.getUploadMap().get("cmsArticleUrl");
		String uploadUrl =  sysPrictureConfig.getUploadMap().get("cmsArticleUrl");
		log.info("调用图片上传工具方法");
		String url = UploadUtils.upload(uploadPath, uploadUrl, file);
		log.info("图片上传返回结果URL:" + url);
		RichText response = new RichText();
		if(url == null||url.equals("")) {
			response.setErrno(500);
			return response;
		}
		response.setErrno(0);
		ArrayList<String> urlList = new ArrayList();
		urlList.add(url);
		response.setData(urlList);
		return response;
	}

	/**
	 * 上传图片
	 * @param pictureReceive
	 * @return
	 */
	@Override
	public R uploadPicture(PictureReceive pictureReceive) {
		log.info("开始图片上传");

		//通过类名属性获得path和url
		Map<String,String> uploadMap = sysPrictureConfig.getUploadMap();
		String typeName = pictureReceive.getTypeName();
		String uploadPath = uploadMap.get(typeName+"Path");
		String uploadUrl = uploadMap.get(typeName+"Url");

		//调用图片上传的工具方法
		String url = UploadUtils.upload(uploadPath, uploadUrl, pictureReceive.getFile());
		if(url.equals("-1")) {
			return CommonUtils.msg(CommonUtils.ERROR);
		}
		log.info("上传图片服务器成功,展示路径：" + url);
		return CommonUtils.msg(url);
	}

}
