package com.venus.tspro.dao;

import com.venus.tspro.entity.Distribute;

import java.util.List;

/**
 * 结算dao
 */
public interface DistributeDao {
    List<Distribute> getDistributeData(Distribute distribute);
}
