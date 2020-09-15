package com.venus.tspro.dao;

import com.venus.tspro.entity.BillInfo;

import java.util.List;
import java.util.Map;

public interface BillDao {
    List<BillInfo> queryAllBills(Map<String,String> billInfoMap);
    void saveNewBill(BillInfo billInfo);
    void updateBill(BillInfo billInfo);
}
