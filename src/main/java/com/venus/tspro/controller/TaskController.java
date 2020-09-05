package com.venus.tspro.controller;

import com.venus.tspro.common.PageVO;
import com.venus.tspro.common.ResponseData;
import com.venus.tspro.entity.manager.TaskInfoBack;
import com.venus.tspro.entity.manager.vo.TaskInfoVo;
import com.venus.tspro.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 任务管理
 */
@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @ResponseBody
    @RequestMapping("/list")
    public ResponseData getTastData(TaskInfoVo taskInfoReq) {
        PageVO<TaskInfoBack> taskInfoList = taskService.getTastData(taskInfoReq);
        return ResponseData.success().setData(taskInfoList);
    }
}
