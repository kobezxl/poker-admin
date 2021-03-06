package com.cn.poker.admin.modules.poker.service;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.modules.poker.entity.Strate;
import com.cn.poker.admin.modules.poker.entity.WpStrategyDetailEntity;

import java.util.Map;


/**
 * 
 * @author <>
 */
public interface WpStrategyDetailService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<WpStrategyDetailEntity> listWpStrategyDetail(Map<String, Object> params);

    /**
     * 新增
     * @param wpStrategyDetail
     * @return
     */
	R saveWpStrategyDetail(WpStrategyDetailEntity wpStrategyDetail);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getWpStrategyDetailById(Long id);

    /**
     * 修改
     * @param wpStrategyDetail
     * @return
     */
	R updateWpStrategyDetail(WpStrategyDetailEntity wpStrategyDetail);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);

    /**
     * 查询用户
     * @param userName
     * @return
     */
    R userList(String userName);

    /**
     * 获取策略包列表
     * @param strate
     * @return
     */
    R packgeList(Strate strate);
}
