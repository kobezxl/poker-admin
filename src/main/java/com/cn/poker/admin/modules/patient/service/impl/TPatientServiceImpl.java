package com.cn.poker.admin.modules.patient.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.common.utils.CommonUtils;
import com.cn.poker.admin.modules.patient.entity.TPatientEntity;
import com.cn.poker.admin.modules.patient.manager.TPatientManager;
import com.cn.poker.admin.modules.patient.service.TPatientService;

/**
 * 
 * @author <>
 */
@Service("tPatientService")
public class TPatientServiceImpl implements TPatientService {

	@Autowired
	private TPatientManager tPatientManager;

    /**
     * 分页查询
     * @param params
     * @return
     */
	@Override
	public Page<TPatientEntity> listTPatient(Map<String, Object> params) {
		Query query = new Query(params);
		Page<TPatientEntity> page = new Page<>(query);
		tPatientManager.listTPatient(page, query);
		return page;
	}

    /**
     * 新增
     * @param tPatient
     * @return
     */
	@Override
	public R saveTPatient(TPatientEntity tPatient) {
		int count = tPatientManager.saveTPatient(tPatient);
		return CommonUtils.msg(count);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public R getTPatientById(Long id) {
		TPatientEntity tPatient = tPatientManager.getTPatientById(id);
		return CommonUtils.msg(tPatient);
	}

    /**
     * 修改
     * @param tPatient
     * @return
     */
	@Override
	public R updateTPatient(TPatientEntity tPatient) {
		int count = tPatientManager.updateTPatient(tPatient);
		return CommonUtils.msg(count);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public R batchRemove(Long[] id) {
		int count = tPatientManager.batchRemove(id);
		return CommonUtils.msg(id, count);
	}

}
