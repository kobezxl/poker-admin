package com.cn.poker.admin.modules.poker.service;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.modules.poker.entity.WpStrateEntity;

import java.util.Map;


/**
 * 策略包
 * @author <>
 */
public interface WpStrateService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<WpStrateEntity> listWpStrate(Map<String, Object> params);

    /**
     * 新增
     * @param wpStrate
     * @return
     */
	R saveWpStrate(WpStrateEntity wpStrate);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getWpStrateById(Long id);

    /**
     * 修改
     * @param wpStrate
     * @return
     */
	R updateWpStrate(WpStrateEntity wpStrate);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
