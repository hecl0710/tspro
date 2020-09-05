package com.venus.tspro.service.impl;

import com.github.pagehelper.PageInfo;
import com.venus.tspro.global.PageVO;
import com.venus.tspro.dao.TaskDao;
import com.venus.tspro.entity.TaskInfo;
import com.venus.tspro.service.TaskService;
import com.venus.tspro.utils.PageVOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    TaskDao taskDao;

    @Override
    public PageVO<TaskInfo> getTastData(TaskInfo taskInfoReq) {
        List<TaskInfo> taskInfoReqs = taskDao.getTastData(taskInfoReq);
        PageVO<TaskInfo> pageVO = PageVOUtil.convert(new PageInfo<>(taskInfoReqs));
        return pageVO;
    }
}
