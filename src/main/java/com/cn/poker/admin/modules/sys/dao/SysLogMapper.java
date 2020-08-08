package com.cn.poker.admin.modules.sys.dao;

import com.cn.poker.admin.modules.sys.dao.BaseMapper;
import com.cn.poker.admin.modules.sys.entity.SysLogEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * 系统日志
 */
@Mapper
public interface SysLogMapper extends BaseMapper<SysLogEntity> {

	int batchRemoveAll();
	
}
