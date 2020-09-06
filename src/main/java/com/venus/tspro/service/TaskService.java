package com.venus.tspro.service;

import com.venus.tspro.entity.TaskInfo;
import com.venus.tspro.global.PageVO;


public interface TaskService {
    PageVO<TaskInfo> getTaskData(TaskInfo taskInfo);

    void addTaskData(TaskInfo taskInfo);

    void editTaskData(TaskInfo taskInfo);
}
