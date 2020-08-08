package com.cn.poker.admin.modules.sys.dao;

import java.util.List;

import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.modules.sys.dao.BaseMapper;
import com.cn.poker.admin.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;


/**
 * 系统用户dao
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

	SysUserEntity getByUserName(String username);
	
	List<Long> listAllMenuId(Long userId);
	
	List<Long> listAllOrgId(Long userId);
	
	int updatePswdByUser(Query query);
	
	int updateUserStatus(Query query);
	
	int updatePswd(SysUserEntity user);
	
}
