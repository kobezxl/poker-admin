package com.cn.poker.admin.modules.sys.controller;

import com.cn.poker.admin.common.utils.ShiroUtils;
import com.cn.poker.admin.modules.sys.entity.SysUserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Controller公共组件
 */
public abstract class AbstractController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	protected SysUserEntity getUser() {
		return ShiroUtils.getUserEntity();
	}

	protected Long getUserId() {
		return getUser().getUserId();
	}
	
}
