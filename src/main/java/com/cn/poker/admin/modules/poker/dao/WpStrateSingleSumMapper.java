package com.cn.poker.admin.modules.poker.dao;

import com.cn.poker.admin.modules.poker.entity.WpStrateSingleSumEntity;
import com.cn.poker.admin.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * 单个购买策略包汇总
 * @author <>
 */
@Mapper
public interface WpStrateSingleSumMapper extends BaseMapper<WpStrateSingleSumEntity> {


    void update2(WpStrateSingleSumEntity getwpStrateSingleSum);

    void update1(WpStrateSingleSumEntity getwpStrateSingleSum);
}
