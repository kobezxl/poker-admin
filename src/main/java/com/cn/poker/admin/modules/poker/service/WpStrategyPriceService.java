package com.cn.poker.admin.modules.poker.service;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.modules.poker.entity.WpStrategyPriceEntity;

import java.util.Map;



/**
 * 
 * @author <>
 */
public interface WpStrategyPriceService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<WpStrategyPriceEntity> listWpStrategyPrice(Map<String, Object> params);

    /**
     * 新增
     * @param wpStrategyPrice
     * @return
     */
	R saveWpStrategyPrice(WpStrategyPriceEntity wpStrategyPrice);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getWpStrategyPriceById(Long id);

    /**
     * 修改
     * @param wpStrategyPrice
     * @return
     */
	R updateWpStrategyPrice(WpStrategyPriceEntity wpStrategyPrice);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
