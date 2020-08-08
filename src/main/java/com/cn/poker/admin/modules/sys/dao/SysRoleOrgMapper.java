package com.cn.poker.admin.modules.sys.dao;

import java.util.List;

import com.cn.poker.admin.modules.sys.entity.SysRoleOrgEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 角色与机构的关系
 */
@Mapper
public interface SysRoleOrgMapper extends BaseMapper<SysRoleOrgEntity> {

	List<Long> listOrgId(Long roleId);
	
	int batchRemoveByOrgId(Long[] id);
	
	int batchRemoveByRoleId(Long[] id);
	
}
