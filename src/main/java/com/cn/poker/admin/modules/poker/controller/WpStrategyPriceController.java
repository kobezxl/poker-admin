package com.cn.poker.admin.modules.poker.controller;

import com.cn.poker.admin.common.annotation.SysLog;
import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.modules.poker.entity.WpStrategyPriceEntity;
import com.cn.poker.admin.modules.poker.service.WpStrategyPriceService;
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
@RequestMapping("/poker/price")
public class WpStrategyPriceController extends AbstractController {
	
	@Autowired
	private WpStrategyPriceService wpStrategyPriceService;
	
	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<WpStrategyPriceEntity> list(@RequestBody Map<String, Object> params) {
		return wpStrategyPriceService.listWpStrategyPrice(params);
	}
		
	/**
	 * 新增
	 * @param wpStrategyPrice
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public R save(@RequestBody WpStrategyPriceEntity wpStrategyPrice) {
		return wpStrategyPriceService.saveWpStrategyPrice(wpStrategyPrice);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return wpStrategyPriceService.getWpStrategyPriceById(id);
	}
	
	/**
	 * 修改
	 * @param wpStrategyPrice
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public R update(@RequestBody WpStrategyPriceEntity wpStrategyPrice) {
		return wpStrategyPriceService.updateWpStrategyPrice(wpStrategyPrice);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return wpStrategyPriceService.batchRemove(id);
	}
	
}
