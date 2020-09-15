package com.venus.tspro.service;

import com.venus.tspro.entity.Distribute;
import com.venus.tspro.global.PageVO;

/**
 * 结算service
 */
public interface DistributeService {
    PageVO<Distribute> getDistributeData(Distribute distribute);
}
