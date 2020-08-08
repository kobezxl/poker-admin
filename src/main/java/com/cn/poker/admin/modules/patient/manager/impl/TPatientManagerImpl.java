package com.cn.poker.admin.modules.patient.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.modules.patient.dao.TPatientMapper;
import com.cn.poker.admin.modules.patient.entity.TPatientEntity;
import com.cn.poker.admin.modules.patient.manager.TPatientManager;

/**
 * 
 * @author <>
 */
@Component("tPatientManager")
public class TPatientManagerImpl implements TPatientManager {

	@Autowired
	private TPatientMapper tPatientMapper;

    /**
     * 分页查询
     * @param page
     * @param search
     * @return
     */
	@Override
	public List<TPatientEntity> listTPatient(Page<TPatientEntity> page, Query search) {
		return tPatientMapper.listForPage(page, search);
	}

    /**
     * 新增
     * @param tPatient
     * @return
     */
	@Override
	public int saveTPatient(TPatientEntity tPatient) {
		return tPatientMapper.save(tPatient);
	}

    /**
     * 根据id查询
     * @param id
     * @return
     */
	@Override
	public TPatientEntity getTPatientById(Long id) {
		TPatientEntity tPatient = tPatientMapper.getObjectById(id);
		return tPatient;
	}

    /**
     * 修改
     * @param tPatient
     * @return
     */
	@Override
	public int updateTPatient(TPatientEntity tPatient) {
		return tPatientMapper.update(tPatient);
	}

    /**
     * 删除
     * @param id
     * @return
     */
	@Override
	public int batchRemove(Long[] id) {
		int count = tPatientMapper.batchRemove(id);
		return count;
	}
	
}
