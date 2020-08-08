package com.cn.poker.admin.modules.sys.dao;

import com.cn.poker.admin.modules.sys.dao.BaseMapper;
import com.cn.poker.admin.modules.sys.entity.SysOrgEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 组织架构
 */
@Mapper
public interface SysOrgMapper extends BaseMapper<SysOrgEntity> {

	int countOrgChildren(Long parentId);
	
}
