package com.venus.tspro.service;

import com.venus.tspro.entity.BillInfo;

import java.util.List;
import java.util.Map;

public interface BillService {
    List<BillInfo> queryAllBills(Map<String,String> billInfoMap);
    void addNewBill(BillInfo billInfo);
    void editBill(BillInfo billInfo);
}
