package com.venus.tspro.controller;

import com.github.pagehelper.PageInfo;
import com.venus.tspro.entity.TaxCompany;
import com.venus.tspro.global.BaseResponse;
import com.venus.tspro.global.PageVO;
import com.venus.tspro.global.ResponseBuilder;
import com.venus.tspro.service.TaxCompanyService;
import com.venus.tspro.utils.PageVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 税源企业请求处理类
 */
@RestController
@RequestMapping("tsc")
@Slf4j
public class TaxCompanyController {

    @Resource
    TaxCompanyService taxCompanyService;

    @PostMapping("list")
    public PageVO<TaxCompany> queryAllTaxCompany(){
        return PageVOUtil.convert(new PageInfo<>(taxCompanyService.queryAllTaxCompany()));
    }

    @PostMapping("add")
    public BaseResponse addTaxCompany(@RequestBody TaxCompany taxCompany){
        taxCompanyService.addTaxCompany(taxCompany);
        return ResponseBuilder.buildSuccessResponse();
    }

    @PostMapping("edit")
    public void editTaxCompany(@RequestBody TaxCompany taxCompany){
        taxCompanyService.editTaxCompany(taxCompany);
    }
}
