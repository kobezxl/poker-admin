package com.cn.poker.admin.modules.poker.service.impl;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.common.utils.CommonUtils;
import com.cn.poker.admin.modules.poker.entity.WpStrategyDetailEntity;
import com.cn.poker.admin.modules.poker.manager.WpStrategyDetailManager;
import com.cn.poker.admin.modules.poker.service.WpStrategyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * 
 * @author <>
 */
@Service("wpStrategyDetailService")
public class WpStrategyDetailServiceImpl implements WpStrategyDetailService {

	@Autowired
	private WpStrategyDetailManager wpStrategyDetailManager;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<WpStrategyDetailEntity> listWpStrategyDetail(Map<String, Object> params) {
		Query query = new Query(params);
		Page<WpStrategyDetailEntity> page = new Page<>(query);
		wpStrategyDetailManager.listWpStrategyDetail(page, query);
		return page;
	}

    /**
     * 新增
     * @param wpStrategyDetail
     * @return
     */
	@Override
	public R saveWpStrategyDetail(WpStrategyDetailEntity wpStrategyDetail) {
		int count = wpStrategyDetailManager.saveWpStrategyDetail(wpStrategyDetail);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getWpStrategyDetailById(Long id) {
		WpStrategyDetailEntity wpStrategyDetail = wpStrategyDetailManager.getWpStrategyDetailById(id);
		return CommonUtils.msg(wpStrategyDetail);
	}

    /**
     * 修改
     * @param wpStrategyDetail
     * @return
     */
	@Override
	public R updateWpStrategyDetail(WpStrategyDetailEntity wpStrategyDetail) {
		int count = wpStrategyDetailManager.updateWpStrategyDetail(wpStrategyDetail);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = wpStrategyDetailManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
