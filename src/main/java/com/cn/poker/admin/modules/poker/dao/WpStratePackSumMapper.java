package com.cn.poker.admin.modules.poker.dao;
import com.cn.poker.admin.modules.poker.entity.WpStratePackSumEntity;
import com.cn.poker.admin.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 打包购买策略包汇总
 * @author <>
 */
@Mapper
public interface WpStratePackSumMapper extends BaseMapper<WpStratePackSumEntity> {


    void update2(WpStratePackSumEntity wpStratePackSumEntity);

    List<WpStratePackSumEntity> selectByUserId(@Param("poolType") Integer poolType, @Param("type") Integer type, @Param("userId") Integer userId);

    void update3(WpStratePackSumEntity wpStratePackSumEntity);

}
