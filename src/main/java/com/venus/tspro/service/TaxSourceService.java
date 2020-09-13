package com.venus.tspro.service;

import com.venus.tspro.entity.TaxSource;

import java.util.List;

public interface TaxSourceService {
    List<TaxSource> queryAllTaxSource();
    void addNewTaxSource(TaxSource taxSource);
    void editTaxSource(TaxSource taxSource);
}
