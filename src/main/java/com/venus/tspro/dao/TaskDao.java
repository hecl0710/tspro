package com.venus.tspro.dao;

import com.venus.tspro.entity.TaskInfo;

import java.util.List;

/**
 * 任务管理模块dao
 */
public interface TaskDao {
     List<TaskInfo> getTaskData(TaskInfo taskInfo);

    void addTaskData(TaskInfo taskInfo);

    void editTaskData(TaskInfo taskInfo);
}
