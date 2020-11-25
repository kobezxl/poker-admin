package com.cn.poker.admin.modules.poker.service.impl;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.common.utils.CommonUtils;
import com.cn.poker.admin.common.utils.DateUtils;
import com.cn.poker.admin.modules.poker.dao.WpStratePackSumMapper;
import com.cn.poker.admin.modules.poker.dao.WpStrateSingleSumMapper;
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
	@Autowired
	private WpStrateSingleSumMapper wpStrateSingleSumMapper;
	@Autowired
	private WpStratePackSumMapper wpStratePackSumMapper;

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
			wpStrategyDetail.setCreateDate(new Date());
			wpStrategyDetail.setStartDate(new Date());
			wpStrategyDetail.setEndDate(DateUtils.getDateAfter(count));
			wpStrategyDetail.setUserId(wpStrategyDetail.getUserId());
			wpStrategyDetail.setGold(0);
			wpStrategyDetail.setTypeNum(wpStrategyDetail.getType()+"-"+"0");
			number = wpStrategyDetailManager.saveWpStrategyDetail(wpStrategyDetail);
			WpStrateSingleSumEntity wpStrateSingleSumEntity = getWpStrateSingleSumEntity(wpStrategyDetail);
			wpStrateSingleSumMapper.update(wpStrateSingleSumEntity);
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
			wpStrategyDetail.setCreateDate(new Date());
			wpStrategyDetail.setStartDate(new Date());
			wpStrategyDetail.setEndDate(DateUtils.getDateAfter(count));
			wpStrategyDetail.setGold(0);
			wpStrategyDetail.setTypeNum(wpStrategyDetail.getType()+"-"+wpStrategyDetail.getPoolType());
			number = wpStrategyDetailManager.saveWpStrategyDetail(wpStrategyDetail);
			Integer poolType = wpStrategyDetail.getPoolType();
			List<WpStratePackSumEntity> list =  wpStratePackSumMapper.selectByUserId(poolType,wpStrategyDetail.getType(),wpStrategyDetail.getUserId());
			if(poolType==4){//全量购买
				if (list!=null && list.size()>0) {  //没到期 叠加
					wpStratePackSumMapper.update3(getWpStratePackSumEntity(wpStrategyDetail));
					wpStrateSingleSumMapper.update3(getwpStrateSingleSum(wpStrategyDetail));
				}else {//到期，直接跟新
					wpStratePackSumMapper.update2(getWpStratePackSumEntity(wpStrategyDetail));
					wpStrateSingleSumMapper.update2(getwpStrateSingleSum(wpStrategyDetail));
				}

			}else { //非全量购买
				if (list!=null && list.size()>0) {  //没到期 叠加
					wpStratePackSumMapper.update3(getWpStratePackSumEntity(wpStrategyDetail));
					wpStrateSingleSumMapper.update3(getwpStrateSingleSum(wpStrategyDetail));
				}else {//到期，直接跟新
					wpStratePackSumMapper.update(getWpStratePackSumEntity(wpStrategyDetail));
					wpStrateSingleSumMapper.update1(getwpStrateSingleSum(wpStrategyDetail));
				}

			}
		}
		return CommonUtils.msg(number);
	}

	private WpStrateSingleSumEntity getWpStrateSingleSumEntity(WpStrategyDetailEntity wpStrategyDetail) {
		WpStrateSingleSumEntity wpStrateSingleSumEntity = new WpStrateSingleSumEntity();
		wpStrateSingleSumEntity.setPackageId(wpStrategyDetail.getStrategyId());
		wpStrateSingleSumEntity.setUserId(wpStrategyDetail.getUserId());
		wpStrateSingleSumEntity.setPoolType(wpStrategyDetail.getPoolType());
		wpStrateSingleSumEntity.setType(wpStrategyDetail.getType());
		wpStrateSingleSumEntity.setStartTime(wpStrategyDetail.getStartDate());
		wpStrateSingleSumEntity.setEndTime(wpStrategyDetail.getEndDate());
		return wpStrateSingleSumEntity;
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
			WpStrateEntity wpStrateEntity = wpStrategyDetailManager.selectByStatgeId(wpStrategyDetail);
			if (wpStrateEntity==null) {
				wpStrategyDetail.setMsg("["+wpStrategyDetail.getName()+"]策略包不存在");
				flag = false;
			}else {
				wpStrategyDetail.setStrategyId(wpStrateEntity.getId());
				wpStrategyDetail.setPoolType(wpStrateEntity.getPoolType());
				wpStrategyDetail.setType(wpStrateEntity.getType());
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


	private WpStratePackSumEntity getWpStratePackSumEntity(WpStrategyDetailEntity orderVo) {
		WpStratePackSumEntity wpStratePackSumEntity = new WpStratePackSumEntity();
		wpStratePackSumEntity.setUserId(orderVo.getUserId());
		wpStratePackSumEntity.setType(orderVo.getType());
		wpStratePackSumEntity.setPoolType(orderVo.getPoolType());
		wpStratePackSumEntity.setStartTime(orderVo.getStartDate());
		wpStratePackSumEntity.setEndTime(orderVo.getEndDate());
		wpStratePackSumEntity.setDaySum(orderVo.getDayCount());
		return wpStratePackSumEntity;
	}

	private WpStrateSingleSumEntity getwpStrateSingleSum(WpStrategyDetailEntity orderVo) {
		WpStrateSingleSumEntity wpStrateSingleSumEntity = new WpStrateSingleSumEntity();
		wpStrateSingleSumEntity.setUserId(orderVo.getUserId());
		wpStrateSingleSumEntity.setType(orderVo.getType());
		wpStrateSingleSumEntity.setPoolType(orderVo.getPoolType());
		wpStrateSingleSumEntity.setStartTime(orderVo.getStartDate());
		wpStrateSingleSumEntity.setEndTime(orderVo.getEndDate());
		wpStrateSingleSumEntity.setDaySum(orderVo.getDayCount());
		return wpStrateSingleSumEntity;
	}

}
