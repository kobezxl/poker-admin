package com.cn.poker.admin.modules.sys.service;

import java.util.List;

import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.modules.sys.entity.SysOrgEntity;

/**
 * 组织机构
 */
public interface SysOrgService {

	List<SysOrgEntity> listOrg();
	
	List<SysOrgEntity> listOrgTree();
	
	R saveOrg(SysOrgEntity org);
	
	R getOrg(Long orgId);
	
	R updateOrg(SysOrgEntity org);
	
	R bactchRemoveOrg(Long[] id);
	
}
