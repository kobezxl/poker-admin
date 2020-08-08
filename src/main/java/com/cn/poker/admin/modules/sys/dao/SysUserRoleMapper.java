package com.cn.poker.admin.modules.sys.dao;

import java.util.List;

import com.cn.poker.admin.modules.sys.dao.BaseMapper;
import com.cn.poker.admin.modules.sys.entity.SysUserRoleEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * 用户与角色关系
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysUserRoleEntity> {

	List<Long> listUserRoleId(Long userId);
	
	int batchRemoveByUserId(Long[] id);
	
	int batchRemoveByRoleId(Long[] id);
	
}
