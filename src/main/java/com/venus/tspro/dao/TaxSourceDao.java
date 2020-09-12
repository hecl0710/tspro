package com.venus.tspro.dao;

import com.venus.tspro.entity.TaxSource;

import java.util.List;

public interface TaxSourceDao {
    List<TaxSource> queryAllTaxSource();
    void saveNewTaxSource(TaxSource taxSource);
}
