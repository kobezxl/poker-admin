package com.cn.poker.admin.modules.patient.service;

import java.util.Map;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.R;
import com.cn.poker.admin.modules.patient.entity.TPatientEntity;

/**
 * 
 * @author <>
 */
public interface TPatientService {

    /**
     * 分页查询
     * @param params
     * @return
     */
	Page<TPatientEntity> listTPatient(Map<String, Object> params);

    /**
     * 新增
     * @param tPatient
     * @return
     */
	R saveTPatient(TPatientEntity tPatient);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	R getTPatientById(Long id);

    /**
     * 修改
     * @param tPatient
     * @return
     */
	R updateTPatient(TPatientEntity tPatient);

    /**
     * 删除
     * @param id
     * @return
     */
	R batchRemove(Long[] id);
	
}
