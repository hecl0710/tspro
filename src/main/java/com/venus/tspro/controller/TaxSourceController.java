package com.venus.tspro.controller;

import com.github.pagehelper.PageInfo;
import com.venus.tspro.entity.TaxSource;
import com.venus.tspro.global.PageVO;
import com.venus.tspro.service.TaxSourceService;
import com.venus.tspro.utils.PageVOUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 税源地控制类
 */
@RestController
@RequestMapping("tsf")
public class TaxSourceController {

    @Resource
    TaxSourceService taxSourceService;

    /**
     * 查询所有税源地
     * @return
     */
    @PostMapping("list")
    public PageVO<TaxSource> queryAllTaxSource(){
        return PageVOUtil.convert(new PageInfo<>(taxSourceService.queryAllTaxSource()));
    }
}
