package com.cn.poker.admin.modules.sys.service;

import java.util.Map;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.modules.sys.entity.SysLogEntity;

/**
 * 系统日志
 */
public interface SysLogService {

	Page<SysLogEntity> listLog(Map<String, Object> params);
	
	R batchRemove(Long[] id);
	
	R batchRemoveAll();
	
}
