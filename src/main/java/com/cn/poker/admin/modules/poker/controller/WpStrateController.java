package com.cn.poker.admin.modules.poker.controller;

import com.cn.poker.admin.common.annotation.SysLog;
import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.modules.poker.entity.WpStrateEntity;
import com.cn.poker.admin.modules.poker.service.WpStrateService;
import com.cn.poker.admin.modules.sys.controller.AbstractController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


/**
 * 策略包
 * @author <>
 */
@RestController
@RequestMapping("/poker/statge")
public class WpStrateController extends AbstractController {
	
	@Autowired
	private WpStrateService wpStrateService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<WpStrateEntity> list(@RequestBody Map<String, Object> params) {
		return wpStrateService.listWpStrate(params);
	}
		
	/**
	 * 新增
	 * @param wpStrate
	 * @return
	 */
	@SysLog("新增策略包")
	@RequestMapping("/save")
	public R save(@RequestBody WpStrateEntity wpStrate) {
		return wpStrateService.saveWpStrate(wpStrate);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return wpStrateService.getWpStrateById(id);
	}
	
	/**
	 * 修改
	 * @param wpStrate
	 * @return
	 */
	@SysLog("修改策略包")
	@RequestMapping("/update")
	public R update(@RequestBody WpStrateEntity wpStrate) {
		return wpStrateService.updateWpStrate(wpStrate);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除策略包")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return wpStrateService.batchRemove(id);
	}

}
