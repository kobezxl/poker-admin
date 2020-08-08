package com.cn.poker.admin.modules.sys.service;

import java.util.List;
import java.util.Map;

import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.modules.sys.entity.SysMenuEntity;

/**
 * 系统菜单
 */
public interface SysMenuService {
	
	R listUserMenu(Long userId);
	
	List<SysMenuEntity> listMenu(Map<String, Object> params);
	
	R listNotButton();
	
	R saveMenu(SysMenuEntity menu);

	R getMenuById(Long id);
	
	R updateMenu(SysMenuEntity menu);
	
	R batchRemove(Long[] id);

}
