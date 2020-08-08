package com.cn.poker.admin.modules.sys.dao;

import java.util.List;

import com.cn.poker.admin.modules.sys.dao.BaseMapper;
import com.cn.poker.admin.modules.sys.entity.SysRoleEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * 系统角色
 */
@Mapper
public interface SysRoleMapper extends BaseMapper<SysRoleEntity> {
	
	List<String> listUserRoles(Long userId);
	
}
