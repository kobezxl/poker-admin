package com.cn.poker.admin.modules.poker.service.impl;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.common.utils.CommonUtils;
import com.cn.poker.admin.modules.poker.entity.WpStrategyPriceEntity;
import com.cn.poker.admin.modules.poker.manager.WpStrategyPriceManager;
import com.cn.poker.admin.modules.poker.service.WpStrategyPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;



/**
 * 
 * @author <>
 */
@Service("wpStrategyPriceService")
public class WpStrategyPriceServiceImpl implements WpStrategyPriceService {

	@Autowired
	private WpStrategyPriceManager wpStrategyPriceManager;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<WpStrategyPriceEntity> listWpStrategyPrice(Map<String, Object> params) {
		Query query = new Query(params);
		Page<WpStrategyPriceEntity> page = new Page<>(query);
		wpStrategyPriceManager.listWpStrategyPrice(page, query);
		return page;
	}

    /**
     * 新增
     * @param wpStrategyPrice
     * @return
     */
	@Override
	public R saveWpStrategyPrice(WpStrategyPriceEntity wpStrategyPrice) {
		int count = wpStrategyPriceManager.saveWpStrategyPrice(wpStrategyPrice);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getWpStrategyPriceById(Long id) {
		WpStrategyPriceEntity wpStrategyPrice = wpStrategyPriceManager.getWpStrategyPriceById(id);
		return CommonUtils.msg(wpStrategyPrice);
	}

    /**
     * 修改
     * @param wpStrategyPrice
     * @return
     */
	@Override
	public R updateWpStrategyPrice(WpStrategyPriceEntity wpStrategyPrice) {
		int count = wpStrategyPriceManager.updateWpStrategyPrice(wpStrategyPrice);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = wpStrategyPriceManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
