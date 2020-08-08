package com.cn.poker.admin.modules.patient.manager;

import java.util.List;

import com.cn.poker.admin.common.entity.Page;
import com.cn.poker.admin.common.entity.Query;
import com.cn.poker.admin.modules.patient.entity.TPatientEntity;

/**
 * 
 * @author <>
 */
public interface TPatientManager {

    /**
     * 分页查询
     * @param page
     * @param search
     * @return
     */
	List<TPatientEntity> listTPatient(Page<TPatientEntity> page, Query search);

    /**
     * 新增
     * @param tPatient
     * @return
     */
	int saveTPatient(TPatientEntity tPatient);

    /**
     * 根据id查询
     * @param id
     * @return
     */
	TPatientEntity getTPatientById(Long id);

    /**
     * 修改
     * @param tPatient
     * @return
     */
	int updateTPatient(TPatientEntity tPatient);

    /**
     * 删除
     * @param id
     * @return
     */
	int batchRemove(Long[] id);
	
}
