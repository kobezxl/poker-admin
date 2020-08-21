package com.cn.poker.admin.modules.poker.manager;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.modules.poker.entity.Strate;
import com.cn.poker.admin.modules.poker.entity.User;
import com.cn.poker.admin.modules.poker.entity.WpStrategyDetailEntity;

import java.util.List;



/**
 * 
 * @author <>
 */
public interface WpStrategyDetailManager {

    /**
     * 分页查询
     * @param page
     * @param search
     * @return
     */
	List<WpStrategyDetailEntity> listWpStrategyDetail(Page<WpStrategyDetailEntity> page, Query search);

    /**
     * 新增
     * @param wpStrategyDetail
     * @return
     */
	int saveWpStrategyDetail(WpStrategyDetailEntity wpStrategyDetail);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	WpStrategyDetailEntity getWpStrategyDetailById(Long id);

    /**
     * 修改
     * @param wpStrategyDetail
     * @return
     */
	int updateWpStrategyDetail(WpStrategyDetailEntity wpStrategyDetail);

    /**
     * 删除
     * @param id
     * @return
     */
	int batchRemove(Long[] id);

    /**
     * 获取用户列表
     * @param userName
     * @return
     */
    List<User> userList(String userName);

    /**
     * 获取策略包列表
     * @param strate
     * @return
     */
    List<Strate> packgeList(Strate strate);
}
