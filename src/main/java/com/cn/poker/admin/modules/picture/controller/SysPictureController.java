package com.cn.poker.admin.modules.picture.controller;

import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.common.exception.RRException;
import com.cn.poker.admin.modules.picture.entity.PictureReceive;
import com.cn.poker.admin.modules.picture.entity.RichText;
import com.cn.poker.admin.modules.picture.entity.SysPictureEntity;
import com.cn.poker.admin.modules.picture.service.SysPictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公共图片上传
 */
@RestController
@RequestMapping("/sys/picture")
public class SysPictureController {
	
	@Autowired
	private SysPictureService sysPictureService;

	
	/**
	 * 上传文件
	 */
	@RequestMapping("/uploadUrl")
	@ResponseBody
	public RichText uploadUrl(@RequestPart("file") MultipartFile file) {
		if (file == null || file.isEmpty()) {
			throw new RRException("上传文件不能为空");
		}
		return sysPictureService.uploadUrl(file);
	}

	/**
	 * 上传文件（更新图片）
	 */
	@RequestMapping("/uploadPicture")
	public R uploadPicture(PictureReceive pictureReceive) {
		if (pictureReceive == null || pictureReceive.getFile().isEmpty()) {
			throw new RRException("上传文件不能为空");
		}
		return sysPictureService.uploadPicture(pictureReceive);
	}
}
