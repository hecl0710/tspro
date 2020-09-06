package com.venus.tspro.controller;

import com.venus.tspro.global.PageVO;
import com.venus.tspro.entity.TaskInfo;
import com.venus.tspro.global.ResponseData;
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

    /**
     *  查询任务信息
     * @param taskInfo
     * @return
     */
    @RequestMapping("list")
    @ResponseBody
    public PageVO<TaskInfo> getTaskData(TaskInfo taskInfo) {
        return taskService.getTaskData(taskInfo);
    }

    /**
     * 添加任务信息
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public ResponseData addTaskData(TaskInfo taskInfo){
        taskService.addTaskData(taskInfo);
        return null;
    }
}
