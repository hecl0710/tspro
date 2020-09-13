package com.venus.tspro.service;

import com.venus.tspro.entity.BillInfo;

import java.util.List;

public interface BillService {
    List<BillInfo> queryAllBills();
    void addNewBill(BillInfo billInfo);
}
