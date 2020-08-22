package com.cn.poker.admin.modules.poker.service.impl;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.common.utils.CommonUtils;
import com.cn.poker.admin.common.utils.DateUtils;
import com.cn.poker.admin.modules.poker.entity.*;
import com.cn.poker.admin.modules.poker.manager.WpStrategyDetailManager;
import com.cn.poker.admin.modules.poker.service.WpStrategyDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
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
		int number =0;
		//校验
		boolean validate =  valiData(wpStrategyDetail);
		if(!validate){
			return CommonUtils.msg(0,wpStrategyDetail.getMsg());
		}
		//单个购买
		if (wpStrategyDetail.getStrategyId()!=null) {
			int count = 0;
			wpStrategyDetail.setCreateDate(new Date());
			int dayCount = wpStrategyDetail.getDayCount();
			if (dayCount==1) {
				count=30;
			}else if (dayCount==2){
				count=365;
			}else if(dayCount==3){
				count=-1;
			}
			wpStrategyDetail.setDayCount(count);
			wpStrategyDetail.setStartDate(new Date());
			wpStrategyDetail.setEndDate(DateUtils.getDateAfter(count));
			wpStrategyDetail.setUserId(wpStrategyDetail.getUserId());
			wpStrategyDetail.setGold(0);
			wpStrategyDetail.setTypeNum(wpStrategyDetail.getType()+"-"+"0");

			number = wpStrategyDetailManager.saveWpStrategyDetail(wpStrategyDetail);
		}else {
			int count = 0;
			int dayCount = wpStrategyDetail.getDayCount();
			if (dayCount==1) {
				count=30;
			}else if (dayCount==2){
				count=365;
			}else if(dayCount==3){
				count=-1;
			}
			wpStrategyDetail.setDayCount(count);
			wpStrategyDetail.setStartDate(new Date());
			wpStrategyDetail.setEndDate(DateUtils.getDateAfter(count));
			wpStrategyDetail.setGold(0);
			wpStrategyDetail.setTypeNum(wpStrategyDetail.getType()+"-"+wpStrategyDetail.getPoolType());

			number = wpStrategyDetailManager.saveWpStrategyDetail(wpStrategyDetail);
		}
		return CommonUtils.msg(number);
	}


	private boolean valiData(WpStrategyDetailEntity wpStrategyDetail) {
		boolean flag = true;
		//用户名
		User user = wpStrategyDetailManager.selectByUserId(wpStrategyDetail.getUserLogin());
		if(user==null){
			wpStrategyDetail.setMsg("["+wpStrategyDetail.getUserLogin()+"]用户不存在");
			flag = false;
		}else {
			wpStrategyDetail.setUserId(user.getUserId());
		}
		//策略包名
		if(wpStrategyDetail.getName()!=null && !"".equals(wpStrategyDetail.getName())){
			WpStrateEntity wpStrateEntity = wpStrategyDetailManager.selectByStatgeId(wpStrategyDetail.getName());
			if (wpStrateEntity==null) {
				wpStrategyDetail.setMsg("["+wpStrategyDetail.getName()+"]策略包不存在");
				flag = false;
			}else {
				wpStrategyDetail.setStrategyId(wpStrateEntity.getId());
			}
		}

		//
		//
		//

		return flag;
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

	@Override
	public R userList(String userName) {
		List<User> user =  wpStrategyDetailManager.userList(userName);
		return CommonUtils.msg(user);
	}

    @Override
    public R packgeList(Strate strate) {
        List<Strate> list =  wpStrategyDetailManager.packgeList(strate);
        return CommonUtils.msg(list);
    }

}
