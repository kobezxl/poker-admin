package com.cn.poker.admin.modules.generator.service;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.modules.generator.entity.GeneratorParamEntity;
import com.cn.poker.admin.modules.generator.entity.TableEntity;

import java.util.Map;


/**
 * 代码生成器
 */
public interface SysGeneratorService {

	Page<TableEntity> listTable(Map<String, Object> params);
	
	byte[] generator(GeneratorParamEntity params);
	
}
