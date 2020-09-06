package com.venus.tspro.service.impl;

import com.venus.tspro.dao.TaxSourceDao;
import com.venus.tspro.entity.TaxSource;
import com.venus.tspro.service.TaxSourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaxSourceServiceImpl implements TaxSourceService {
    @Resource
    TaxSourceDao taxSourceDao;
    @Override
    public List<TaxSource> queryAllTaxSource() {
        return taxSourceDao.queryAllTaxSource();
    }
}
