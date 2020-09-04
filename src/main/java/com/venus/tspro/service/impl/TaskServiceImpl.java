package com.venus.tspro.service.impl;

import com.github.pagehelper.PageInfo;
import com.venus.tspro.common.PageVO;
import com.venus.tspro.dao.TaskDao;
import com.venus.tspro.entity.manager.TaskInfoBack;
import com.venus.tspro.entity.manager.vo.TaskInfoVo;
import com.venus.tspro.service.TaskService;
import com.venus.tspro.utils.PageVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskDao taskDao;

    @Override
    public PageVO<TaskInfoBack> getTastData(TaskInfoVo taskInfoReq) {
        List<TaskInfoBack> taskInfoReqs = taskDao.getTastData(taskInfoReq);
        PageVO<TaskInfoBack> pageVO = PageVOUtil.convert(new PageInfo<>(taskInfoReqs));
        return pageVO;
    }
}
