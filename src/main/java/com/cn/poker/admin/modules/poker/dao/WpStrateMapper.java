package com.cn.poker.admin.modules.poker.dao;

import com.cn.poker.admin.modules.poker.entity.WpStrateEntity;
import com.cn.poker.admin.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 策略包
 * @author <>
 */
@Mapper
public interface WpStrateMapper extends BaseMapper<WpStrateEntity> {

    List<WpStrateEntity> getList(WpStrateEntity wpStrateEntity);
}
