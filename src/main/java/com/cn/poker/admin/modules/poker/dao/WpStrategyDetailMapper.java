package com.cn.poker.admin.modules.poker.dao;

import com.cn.poker.admin.modules.poker.entity.Strate;
import com.cn.poker.admin.modules.poker.entity.User;
import com.cn.poker.admin.modules.poker.entity.WpStrategyDetailEntity;
import com.cn.poker.admin.modules.sys.dao.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.Date;
import java.util.List;


/**
 * 
 * @author <>
 */
@Mapper
public interface WpStrategyDetailMapper extends BaseMapper<WpStrategyDetailEntity> {

    /**
     * 获取用户列表
     * @param userName
     * @return
     */
    List<User> userList(String userName);

    /**
     * 获取策略包列表
     * @param strate
     * @return
     */
    List<Strate> packgeList(Strate strate);

    /**
     * 查询新注册的用户并且没有得到奖励的
     * @param start
     * @return
     */
    List<User> selectNewUser(Date start);
}
