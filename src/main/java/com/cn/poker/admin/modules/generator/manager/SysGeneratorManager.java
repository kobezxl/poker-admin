package com.cn.poker.admin.modules.generator.manager;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.modules.generator.entity.ColumnEntity;
import com.cn.poker.admin.modules.generator.entity.TableEntity;

import java.util.List;


/**
 * 代码生成器
 */
public interface SysGeneratorManager {

	void listTable(Page<TableEntity> page, Query query);
	
	TableEntity getTableByName(String tableName);
	
	List<ColumnEntity> listColumn(String tableName);
	
}
