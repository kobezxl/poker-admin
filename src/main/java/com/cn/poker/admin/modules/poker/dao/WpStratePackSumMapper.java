package com.cn.poker.admin.modules.poker.dao;
import com.cn.poker.admin.modules.poker.entity.WpStratePackSumEntity;
import com.cn.poker.admin.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * 打包购买策略包汇总
 * @author <>
 */
@Mapper
public interface WpStratePackSumMapper extends BaseMapper<WpStratePackSumEntity> {


    void update2(WpStratePackSumEntity wpStratePackSumEntity);
}
