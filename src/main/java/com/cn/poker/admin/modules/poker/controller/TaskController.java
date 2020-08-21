package com.cn.poker.admin.modules.poker.controller;

import com.cn.poker.admin.modules.poker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
@EnableScheduling
public class TaskController {

    @Autowired
    private TaskService taskService;

    /**
     *  新用户赠送策略包
     */
    @Scheduled(cron = "*/5 * * * * ?")
    public void initialize(){
        taskService.newUserGiving();
    }
}
