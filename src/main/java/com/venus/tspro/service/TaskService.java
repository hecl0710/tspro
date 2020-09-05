package com.venus.tspro.service;

import com.venus.tspro.common.PageVO;
import com.venus.tspro.entity.TaskInfo;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {
    PageVO<TaskInfo> getTastData(TaskInfo taskInfoReq);
}
