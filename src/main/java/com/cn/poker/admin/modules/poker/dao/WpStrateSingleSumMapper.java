package com.cn.poker.admin.modules.poker.dao;

import com.cn.poker.admin.modules.poker.entity.WpStrateSingleSumEntity;
import com.cn.poker.admin.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 单个购买策略包汇总
 * @author <>
 */
@Mapper
public interface WpStrateSingleSumMapper extends BaseMapper<WpStrateSingleSumEntity> {


    void update2(WpStrateSingleSumEntity getwpStrateSingleSum);

    void update1(WpStrateSingleSumEntity getwpStrateSingleSum);

    void insertBatch(@Param("strateSingleSumList") List<WpStrateSingleSumEntity> list);

    void update3(WpStrateSingleSumEntity getwpStrateSingleSum);

}
