package com.cn.poker.admin.modules.poker.manager.impl;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.modules.poker.dao.WpStrategyPriceMapper;
import com.cn.poker.admin.modules.poker.entity.WpStrategyPriceEntity;
import com.cn.poker.admin.modules.poker.manager.WpStrategyPriceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 
 * @author <>
 */
@Component("wpStrategyPriceManager")
public class WpStrategyPriceManagerImpl implements WpStrategyPriceManager {

	@Autowired
	private WpStrategyPriceMapper wpStrategyPriceMapper;

    /**
     * 分页查询
     * @param page
     * @param search
     * @return
     */
	@Override
	public List<WpStrategyPriceEntity> listWpStrategyPrice(Page<WpStrategyPriceEntity> page, Query search) {
		return wpStrategyPriceMapper.listForPage(page, search);
	}

    /**
     * 新增
     * @param wpStrategyPrice
     * @return
     */
	@Override
	public int saveWpStrategyPrice(WpStrategyPriceEntity wpStrategyPrice) {
		return wpStrategyPriceMapper.save(wpStrategyPrice);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public WpStrategyPriceEntity getWpStrategyPriceById(Long id) {
		WpStrategyPriceEntity wpStrategyPrice = wpStrategyPriceMapper.getObjectById(id);
		return wpStrategyPrice;
	}

    /**
     * 修改
     * @param wpStrategyPrice
     * @return
     */
	@Override
	public int updateWpStrategyPrice(WpStrategyPriceEntity wpStrategyPrice) {
		return wpStrategyPriceMapper.update(wpStrategyPrice);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public int batchRemove(Long[] id) {
		int count = wpStrategyPriceMapper.batchRemove(id);
		return count;
	}
	
}
