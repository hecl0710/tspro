package com.venus.tspro.service.impl;

import com.alibaba.fastjson.JSON;
import com.venus.tspro.dao.TaxCompanyDao;
import com.venus.tspro.entity.TaxCompany;
import com.venus.tspro.service.TaxCompanyService;
import com.venus.tspro.utils.SeqBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class TaxCompanyServiceImpl implements TaxCompanyService {

    @Resource
    TaxCompanyDao taxCompanyDao;
    @Override
    public List<TaxCompany> queryAllTaxCompany() {
        return taxCompanyDao.queryAllTaxCompany();
    }

    @Override
    public void addTaxCompany(TaxCompany taxCompany) {
        log.info("接收到新增税源企业请求：{}", JSON.toJSONString(taxCompany));
        taxCompany.setCompanyId(SeqBuilder.buildTaxCompanyId());
        taxCompanyDao.saveNewTaxCompany(taxCompany);
    }

    @Override
    public void editTaxCompany(TaxCompany taxCompany) {
        log.info("接收到编辑税源企业请求：{}", JSON.toJSONString(taxCompany));
        taxCompanyDao.updateTaxCompany(taxCompany);
    }
}
