package com.venus.tspro.service;

import com.venus.tspro.global.PageVO;
import com.venus.tspro.entity.TaskInfo;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {
    PageVO<TaskInfo> getTastData(TaskInfo taskInfoReq);
}
