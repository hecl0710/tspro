package com.venus.tspro.controller;

import com.venus.tspro.global.PageVO;
import com.venus.tspro.entity.TaskInfo;
import com.venus.tspro.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * 任务管理
 */
@Controller
@RequestMapping("task")
public class TaskController {

    @Resource
    TaskService taskService;

    @RequestMapping("list")
    @ResponseBody
    public PageVO<TaskInfo> getTastData(TaskInfo taskInfo) {
        return taskService.getTastData(taskInfo);
    }
}
