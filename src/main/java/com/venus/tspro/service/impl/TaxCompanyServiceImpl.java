package com.venus.tspro.service.impl;

import com.venus.tspro.dao.TaxCompanyDao;
import com.venus.tspro.entity.TaxCompany;
import com.venus.tspro.service.TaxCompanyService;
import com.venus.tspro.utils.SeqBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaxCompanyServiceImpl implements TaxCompanyService {

    @Resource
    TaxCompanyDao taxCompanyDao;
    @Override
    public List<TaxCompany> queryAllTaxCompany() {
        return taxCompanyDao.queryAllTaxCompany();
    }

    @Override
    public void addTaxCompany(TaxCompany taxCompany) {
        taxCompany.setCompanyId(SeqBuilder.buildTaxCompanyId());
        taxCompanyDao.saveNewTaxCompany(taxCompany);
    }
}
