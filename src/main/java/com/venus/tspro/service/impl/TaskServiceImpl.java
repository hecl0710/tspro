package com.venus.tspro.service.impl;

import com.github.pagehelper.PageInfo;
import com.venus.tspro.dao.TaskDao;
import com.venus.tspro.entity.TaskInfo;
import com.venus.tspro.global.PageVO;
import com.venus.tspro.service.TaskService;
import com.venus.tspro.utils.DateUtil;
import com.venus.tspro.utils.PageVOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 任务管理模块service
 *
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    TaskDao taskDao;

    @Override
    public PageVO<TaskInfo> getTaskData(TaskInfo taskInfo) {
        List<TaskInfo> taskInfoReqs = taskDao.getTaskData(taskInfo);
        PageVO<TaskInfo> pageVO = PageVOUtil.convert(new PageInfo<>(taskInfoReqs));
        return pageVO;
    }

    @Override
    public void addTaskData(TaskInfo taskInfo) {
        taskInfo.setTaskId(UUID.randomUUID().toString());
        taskInfo.setStatus("2");
        taskInfo.setAmount("0");
        taskDao.addTaskData(taskInfo);
    }
}
