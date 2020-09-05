package com.venus.tspro.dao;

import com.venus.tspro.entity.TaskInfo;

import java.util.List;

public interface TaskDao {
     List<TaskInfo> getTaskData(TaskInfo taskInfoReq);
}
