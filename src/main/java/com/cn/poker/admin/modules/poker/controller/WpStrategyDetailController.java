package com.cn.poker.admin.modules.poker.controller;

import com.cn.poker.admin.common.annotation.SysLog;
import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.modules.poker.entity.Strate;
import com.cn.poker.admin.modules.poker.entity.WpStrategyDetailEntity;
import com.cn.poker.admin.modules.poker.service.WpStrategyDetailService;
import com.cn.poker.admin.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * 
 * @author <>
 */
@RestController
@RequestMapping("/poker/detail")
public class WpStrategyDetailController extends AbstractController {
	
	@Autowired
	private WpStrategyDetailService wpStrategyDetailService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<WpStrategyDetailEntity> list(@RequestBody Map<String, Object> params) {
		return wpStrategyDetailService.listWpStrategyDetail(params);
	}
		
	/**
	 * 新增---用户赠送策略包
	 * @param wpStrategyDetail
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public R save(@RequestBody WpStrategyDetailEntity wpStrategyDetail) {
		return wpStrategyDetailService.saveWpStrategyDetail(wpStrategyDetail);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return wpStrategyDetailService.getWpStrategyDetailById(id);
	}
	
	/**
	 * 修改
	 * @param wpStrategyDetail
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public R update(@RequestBody WpStrategyDetailEntity wpStrategyDetail) {
		return wpStrategyDetailService.updateWpStrategyDetail(wpStrategyDetail);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return wpStrategyDetailService.batchRemove(id);
	}

	/**
	 * 查询用户
	 */
	@RequestMapping("/userList")
	public R userList(@RequestBody String userName) {
		return wpStrategyDetailService.userList(userName);
	}

	/**
	 * 获取策略包名称
	 */
	@RequestMapping("/packgeList")
	public R packgeList(@RequestBody Strate strate) {
		return wpStrategyDetailService.packgeList(strate);
	}


}
