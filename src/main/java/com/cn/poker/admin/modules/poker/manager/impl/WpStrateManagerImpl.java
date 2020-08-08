package com.cn.poker.admin.modules.poker.manager.impl;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.modules.poker.dao.WpStrateMapper;
import com.cn.poker.admin.modules.poker.entity.WpStrateEntity;
import com.cn.poker.admin.modules.poker.manager.WpStrateManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


/**
 * 策略包
 * @author <>
 */
@Component("wpStrateManager")
public class WpStrateManagerImpl implements WpStrateManager {

	@Autowired
	private WpStrateMapper wpStrateMapper;

    /**
     * 分页查询
     * @param page
     * @param search
     * @return
     */
	@Override
	public List<WpStrateEntity> listWpStrate(Page<WpStrateEntity> page, Query search) {
		return wpStrateMapper.listForPage(page, search);
	}

    /**
     * 新增
     * @param wpStrate
     * @return
     */
	@Override
	public int saveWpStrate(WpStrateEntity wpStrate) {
		return wpStrateMapper.save(wpStrate);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public WpStrateEntity getWpStrateById(Long id) {
		WpStrateEntity wpStrate = wpStrateMapper.getObjectById(id);
		return wpStrate;
	}

    /**
     * 修改
     * @param wpStrate
     * @return
     */
	@Override
	public int updateWpStrate(WpStrateEntity wpStrate) {
		return wpStrateMapper.update(wpStrate);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public int batchRemove(Long[] id) {
		int count = wpStrateMapper.batchRemove(id);
		return count;
	}
	
}
