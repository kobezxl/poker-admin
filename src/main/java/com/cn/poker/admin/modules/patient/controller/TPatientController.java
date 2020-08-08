package com.cn.poker.admin.modules.patient.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cn.poker.admin.common.annotation.SysLog;
import com.cn.poker.admin.modules.sys.controller.AbstractController;
import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.modules.patient.entity.TPatientEntity;
import com.cn.poker.admin.modules.patient.service.TPatientService;

/**
 * 
 * @author <>
 */
@RestController
@RequestMapping("/patient")
public class TPatientController extends AbstractController {
	
	@Autowired
	private TPatientService tPatientService;

	/**
	 * 列表
	 * @param params
	 * @return
	 */
	@RequestMapping("/list")
	public Page<TPatientEntity> list(@RequestBody Map<String, Object> params) {
		return tPatientService.listTPatient(params);
	}

	/**
	 * 新增
	 * @param tPatient
	 * @return
	 */
	@SysLog("新增")
	@RequestMapping("/save")
	public R save(@RequestBody TPatientEntity tPatient) {
		return tPatientService.saveTPatient(tPatient);
	}
	
	/**
	 * 根据id查询详情
	 * @param id
	 * @return
	 */
	@RequestMapping("/info")
	public R getById(@RequestBody Long id) {
		return tPatientService.getTPatientById(id);
	}
	
	/**
	 * 修改
	 * @param tPatient
	 * @return
	 */
	@SysLog("修改")
	@RequestMapping("/update")
	public R update(@RequestBody TPatientEntity tPatient) {
		return tPatientService.updateTPatient(tPatient);
	}
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	@SysLog("删除")
	@RequestMapping("/remove")
	public R batchRemove(@RequestBody Long[] id) {
		return tPatientService.batchRemove(id);
	}
	
}
