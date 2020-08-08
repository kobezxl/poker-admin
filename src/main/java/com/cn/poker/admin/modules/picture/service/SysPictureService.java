package com.cn.poker.admin.modules.picture.service;

import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.modules.picture.entity.PictureReceive;
import com.cn.poker.admin.modules.picture.entity.RichText;
import com.cn.poker.admin.modules.picture.entity.SysPictureEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 */
public interface SysPictureService {


	RichText uploadUrl(MultipartFile file);

	R uploadPicture(PictureReceive pictureReceive);

}
