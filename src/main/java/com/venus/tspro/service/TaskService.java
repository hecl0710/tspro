package com.venus.tspro.service;

import com.venus.tspro.common.PageVO;
import com.venus.tspro.entity.manager.TaskInfoBack;
import com.venus.tspro.entity.manager.vo.TaskInfoVo;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {
    PageVO<TaskInfoBack> getTastData(TaskInfoVo taskInfoReq);
}
