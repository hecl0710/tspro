package com.venus.tspro.dao;

import com.venus.tspro.entity.TaxCompany;

import java.util.List;

public interface TaxCompanyDao {
    List<TaxCompany> queryAllTaxCompany();
    void saveNewTaxCompany(TaxCompany taxCompany);
    void updateTaxCompany(TaxCompany taxCompany);
}
