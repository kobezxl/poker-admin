package com.cn.poker.admin.modules.poker.service.impl;

import com.cn.poker.admin.common.entity.PokerConfig;
import com.cn.poker.admin.common.utils.DateUtils;
import com.cn.poker.admin.modules.poker.dao.WpStrateMapper;
import com.cn.poker.admin.modules.poker.dao.WpStrateSingleSumMapper;
import com.cn.poker.admin.modules.poker.dao.WpStrategyDetailMapper;
import com.cn.poker.admin.modules.poker.entity.*;
import com.cn.poker.admin.modules.poker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service("taskService")
public class TaskServiceImpl implements TaskService{

    @Autowired
    private PokerConfig pokerConfig;

    @Autowired
    private WpStrategyDetailMapper wpStrategyDetailMapper;

    @Autowired
    private WpStrateSingleSumMapper wpStrateSingleSumMapper;

    @Autowired
    private WpStrateMapper wpStrateMapper;

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
            wpStrategyDetailMapper.updateUser(user.getUserId());
        }

    }

    /**
     * 用户时间汇总初始化
     */
    @Override
    public void UserTimeSum() {
        //1.初始化单个策略包
        //2.初始化打包购买策略包
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
        //初始化钱包
        WpStratePackSumEntity wpStratePackSumEntity = null;
        List<WpStratePackSumEntity> list = new ArrayList<>();
        for (int j = 2; j <= 3 ; j++) {
            for (int i = 1; i <= 4; i++) {
                wpStratePackSumEntity = new WpStratePackSumEntity();
                wpStratePackSumEntity.setPoolType(i);
                wpStratePackSumEntity.setUserId(userId);
                wpStratePackSumEntity.setType(j);
                wpStratePackSumEntity.setStartTime(wp.getStartDate());
                wpStratePackSumEntity.setEndTime(wp.getEndDate());
                list.add(wpStratePackSumEntity);
            }
        }
        wpStrategyDetailMapper.insertBatch(list);
        //再以打包购买策略包为准 初始化单个策略包
        for (int i = 2; i <= 3; i++) {     // 6人桌    8人桌
            for (int j = 1; j <= 3; j++) {   // 单底池     3bet底池    6bet底池      全部
                    List<WpStrateSingleSumEntity> wpStrateSingleSumEntityList = getStrateSingleSumZero(i,j,userId);  //初始化为0
                    wpStrateSingleSumMapper.insertBatch(wpStrateSingleSumEntityList);
            }

        }

    }


    private List<WpStrateSingleSumEntity> getStrateSingleSumZero(int type, int poolType, Integer userId) {
        List<WpStrateSingleSumEntity> list = new ArrayList<>();
        WpStrateSingleSumEntity wpStrateSingleSumEntity = null;
        WpStrateEntity wpStrateEntity = new WpStrateEntity(poolType,type);
        List<WpStrateEntity> strateEntityList =  wpStrateMapper.getList(wpStrateEntity);
        for (WpStrateEntity strateEntity : strateEntityList) {
            wpStrateSingleSumEntity = new WpStrateSingleSumEntity(userId,strateEntity.getId(),type,poolType,null,null);
            list.add(wpStrateSingleSumEntity);
        }
        return list;
    }

}
