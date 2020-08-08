package com.cn.poker.admin.modules.poker.service.impl;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.common.utils.CommonUtils;
import com.cn.poker.admin.modules.poker.entity.WpStrateEntity;
import com.cn.poker.admin.modules.poker.manager.WpStrateManager;
import com.cn.poker.admin.modules.poker.service.WpStrateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 * 策略包
 * @author <>
 */
@Service("wpStrateService")
public class WpStrateServiceImpl implements WpStrateService {

	@Autowired
	private WpStrateManager wpStrateManager;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<WpStrateEntity> listWpStrate(Map<String, Object> params) {
		Query query = new Query(params);
		Page<WpStrateEntity> page = new Page<>(query);
		wpStrateManager.listWpStrate(page, query);
		return page;
	}

    /**
     * 新增
     * @param wpStrate
     * @return
     */
	@Override
	public R saveWpStrate(WpStrateEntity wpStrate) {
		int count = wpStrateManager.saveWpStrate(wpStrate);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getWpStrateById(Long id) {
		WpStrateEntity wpStrate = wpStrateManager.getWpStrateById(id);
		return CommonUtils.msg(wpStrate);
	}

    /**
     * 修改
     * @param wpStrate
     * @return
     */
	@Override
	public R updateWpStrate(WpStrateEntity wpStrate) {
		int count = wpStrateManager.updateWpStrate(wpStrate);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = wpStrateManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
