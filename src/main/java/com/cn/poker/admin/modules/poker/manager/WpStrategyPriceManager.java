package com.cn.poker.admin.modules.poker.manager;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.modules.poker.entity.WpStrategyPriceEntity;

import java.util.List;



/**
 * 
 * @author <>
 */
public interface WpStrategyPriceManager {

    /**
     * 分页查询
     * @param page
     * @param search
     * @return
     */
	List<WpStrategyPriceEntity> listWpStrategyPrice(Page<WpStrategyPriceEntity> page, Query search);

    /**
     * 新增
     * @param wpStrategyPrice
     * @return
     */
	int saveWpStrategyPrice(WpStrategyPriceEntity wpStrategyPrice);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	WpStrategyPriceEntity getWpStrategyPriceById(Long id);

    /**
     * 修改
     * @param wpStrategyPrice
     * @return
     */
	int updateWpStrategyPrice(WpStrategyPriceEntity wpStrategyPrice);

    /**
     * 删除
     * @param id
     * @return
     */
	int batchRemove(Long[] id);
	
}
