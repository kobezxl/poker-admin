package com.cn.poker.admin.modules.poker.manager;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.modules.poker.entity.WpStrateEntity;

import java.util.List;


/**
 * 策略包
 * @author <>
 */
public interface WpStrateManager {

    /**
     * 分页查询
     * @param page
     * @param search
     * @return
     */
	List<WpStrateEntity> listWpStrate(Page<WpStrateEntity> page, Query search);

    /**
     * 新增
     * @param wpStrate
     * @return
     */
	int saveWpStrate(WpStrateEntity wpStrate);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	WpStrateEntity getWpStrateById(Long id);

    /**
     * 修改
     * @param wpStrate
     * @return
     */
	int updateWpStrate(WpStrateEntity wpStrate);

    /**
     * 删除
     * @param id
     * @return
     */
	int batchRemove(Long[] id);
	
}
