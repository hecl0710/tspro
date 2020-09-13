package com.venus.tspro.dao;

import com.venus.tspro.entity.BillInfo;

import java.util.List;

public interface BillDao {
    List<BillInfo> queryAllBills();
    void saveNewBill(BillInfo billInfo);
}
