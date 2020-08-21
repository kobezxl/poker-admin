package com.cn.poker.admin.modules.poker.service.impl;

import com.cn.poker.admin.common.entity.PokerConfig;
import com.cn.poker.admin.common.utils.DateUtils;
import com.cn.poker.admin.modules.poker.dao.WpStrategyDetailMapper;
import com.cn.poker.admin.modules.poker.entity.StrateInfoVo;
import com.cn.poker.admin.modules.poker.entity.User;
import com.cn.poker.admin.modules.poker.entity.WpStrategyDetailEntity;
import com.cn.poker.admin.modules.poker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService{

    @Autowired
    private PokerConfig pokerConfig;

    @Autowired
    private WpStrategyDetailMapper wpStrategyDetailMapper;
    /**
     * 新用户赠送策略包
     */
    @Override
    public void newUserGiving() {
        int dayCount = pokerConfig.getDaycount();
        String startDate = pokerConfig.getStart();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date start = null;
        try {
             start = formatter.parse(startDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        //查询用户
        List<User> list = wpStrategyDetailMapper.selectNewUser(start);
        for (User user : list) {
            //购买一个6人桌全部策略包和一个 8人桌的全部策略包
            saveOrder(2,4,user.getUserId(),dayCount);
            saveOrder(3,4,user.getUserId(),dayCount);
        }

    }

    public void saveOrder(int type,int poolType,int userId,int dayCount){
        WpStrategyDetailEntity wp = new WpStrategyDetailEntity();
        StrateInfoVo strateInfoVo = new StrateInfoVo();
        strateInfoVo.setType(type);
        strateInfoVo.setPoolType(poolType);
        wp.setCreateDate(new Date());
        wp.setPoolType(poolType);
        wp.setType(type);
        wp.setDayCount(30);//写死三十天
        wp.setStartDate(new Date());
        wp.setEndDate(DateUtils.getDateAfter(dayCount));
        wp.setUserId(userId);
        wp.setGold(0);
        wp.setTypeNum(type+"-"+poolType);
        wp.setDataFrom(1);//是否是系统赠送:1-是，0-否
        wpStrategyDetailMapper.save(wp);
    }

}
