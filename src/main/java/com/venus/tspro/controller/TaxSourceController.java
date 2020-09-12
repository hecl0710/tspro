package com.venus.tspro.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.ser.Serializers;
import com.github.pagehelper.PageInfo;
import com.venus.tspro.entity.TaxSource;
import com.venus.tspro.global.BaseResponse;
import com.venus.tspro.global.PageVO;
import com.venus.tspro.global.ResponseBuilder;
import com.venus.tspro.service.TaxSourceService;
import com.venus.tspro.utils.PageVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 税源地控制类
 */
@RestController
@RequestMapping("tsf")
@Slf4j
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

    @PostMapping("add")
    public BaseResponse addTaxSource(@RequestBody TaxSource taxSource){
        log.info("接收到增加税源地请求：{}", JSON.toJSONString(taxSource));
        taxSourceService.addNewTaxSource(taxSource);
        return ResponseBuilder.buildSuccessResponse();
    }
}
