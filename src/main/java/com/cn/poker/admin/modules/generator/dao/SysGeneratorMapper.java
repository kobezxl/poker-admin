package com.cn.poker.admin.modules.generator.dao;

import java.util.List;
import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.modules.generator.entity.ColumnEntity;
import com.cn.poker.admin.modules.generator.entity.TableEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 代码生成器
 */
@Mapper
public interface SysGeneratorMapper {

	List<TableEntity> listTable(Page<TableEntity> page, Query query);
	
	TableEntity getTableByName(String tableName);
	
	List<ColumnEntity> listColumn(String tableName);
	
}
