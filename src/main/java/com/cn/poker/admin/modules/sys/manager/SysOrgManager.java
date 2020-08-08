package com.cn.poker.admin.modules.sys.manager;

import com.cn.poker.admin.modules.sys.entity.SysOrgEntity;

import java.util.List;


/**
 * 组织机构
 */
public interface SysOrgManager {

	List<SysOrgEntity> listOrg();
	
	int saveOrg(SysOrgEntity org);
	
	SysOrgEntity getOrg(Long orgId);
	
	int updateOrg(SysOrgEntity org);
	
	int bactchRemoveOrg(Long[] id);
	
	boolean hasChildren(Long[] id);
	
}
