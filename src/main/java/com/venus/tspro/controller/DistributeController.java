package com.venus.tspro.controller;

import com.venus.tspro.entity.Distribute;
import com.venus.tspro.global.PageVO;
import com.venus.tspro.service.DistributeService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 结算controller
 */
@RestController
@RequestMapping("distribute")
public class DistributeController {

    @Resource
    DistributeService distributeService;

    /**
     * 查询结算明细
     *
     * @param distribute
     * @return
     */
    @RequestMapping("trade/list")
    public PageVO<Distribute> getTaskData(@RequestBody Distribute distribute) {
        return distributeService.getDistributeData(distribute);
    }

}
