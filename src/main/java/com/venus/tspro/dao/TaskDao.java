package com.venus.tspro.dao;

import com.venus.tspro.entity.manager.TaskInfoBack;
import com.venus.tspro.entity.manager.vo.TaskInfoVo;

import java.util.List;

public interface TaskDao {
     List<TaskInfoBack> getTastData(TaskInfoVo taskInfoReq);
}
