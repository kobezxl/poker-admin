package com.cn.poker.admin.modules.poker.service;

public interface TaskService {
    /**
     * 新用户赠送策略包
     */
    void newUserGiving();

    /**
     * 初始化用户时间汇总
     */
    void UserTimeSum();
}
