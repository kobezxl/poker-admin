package com.cn.poker.admin.modules.poker.manager.impl;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.modules.poker.dao.WpStrategyDetailMapper;
import com.cn.poker.admin.modules.poker.entity.WpStrategyDetailEntity;
import com.cn.poker.admin.modules.poker.manager.WpStrategyDetailManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;



/**
 * 
 * @author <>
 */
@Component("wpStrategyDetailManager")
public class WpStrategyDetailManagerImpl implements WpStrategyDetailManager {

	@Autowired
	private WpStrategyDetailMapper wpStrategyDetailMapper;

    /**
     * 分页查询
     * @param page
     * @param search
     * @return
     */
	@Override
	public List<WpStrategyDetailEntity> listWpStrategyDetail(Page<WpStrategyDetailEntity> page, Query search) {
		return wpStrategyDetailMapper.listForPage(page, search);
	}

    /**
     * 新增
     * @param wpStrategyDetail
     * @return
     */
	@Override
	public int saveWpStrategyDetail(WpStrategyDetailEntity wpStrategyDetail) {
		return wpStrategyDetailMapper.save(wpStrategyDetail);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public WpStrategyDetailEntity getWpStrategyDetailById(Long id) {
		WpStrategyDetailEntity wpStrategyDetail = wpStrategyDetailMapper.getObjectById(id);
		return wpStrategyDetail;
	}

    /**
     * 修改
     * @param wpStrategyDetail
     * @return
     */
	@Override
	public int updateWpStrategyDetail(WpStrategyDetailEntity wpStrategyDetail) {
		return wpStrategyDetailMapper.update(wpStrategyDetail);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public int batchRemove(Long[] id) {
		int count = wpStrategyDetailMapper.batchRemove(id);
		return count;
	}
	
}
