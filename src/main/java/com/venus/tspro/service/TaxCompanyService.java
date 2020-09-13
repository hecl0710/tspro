package com.venus.tspro.service;

import com.venus.tspro.entity.TaxCompany;

import java.util.List;

public interface TaxCompanyService {
    List<TaxCompany> queryAllTaxCompany();
    void addTaxCompany(TaxCompany taxCompany);
    void editTaxCompany(TaxCompany taxCompany);
}
