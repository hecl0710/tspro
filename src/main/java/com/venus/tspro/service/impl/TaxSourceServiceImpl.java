package com.venus.tspro.service.impl;

import com.alibaba.fastjson.JSON;
import com.venus.tspro.dao.TaxSourceDao;
import com.venus.tspro.entity.TaxSource;
import com.venus.tspro.service.TaxSourceService;
import com.venus.tspro.utils.SeqBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class TaxSourceServiceImpl implements TaxSourceService {
    @Resource
    TaxSourceDao taxSourceDao;
    @Override
    public List<TaxSource> queryAllTaxSource() {
        return taxSourceDao.queryAllTaxSource();
    }

    @Override
    public void addNewTaxSource(TaxSource taxSource) {
        log.info("接收到增加税源地请求：{}", JSON.toJSONString(taxSource));
        taxSource.setTsId(SeqBuilder.buildTaxSourceId());
        //操作人编码
        taxSourceDao.saveNewTaxSource(taxSource);
    }

    @Override
    public void editTaxSource(TaxSource taxSource) {
        log.info("接收到编辑税源地请求：{}", JSON.toJSONString(taxSource));
        taxSourceDao.updateTaxSource(taxSource);
    }
}
