package com.venus.tspro.service.impl;

import com.venus.tspro.dao.BillDao;
import com.venus.tspro.entity.BillInfo;
import com.venus.tspro.service.BillService;
import com.venus.tspro.utils.SeqBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
@Slf4j
public class BillServiceImpl implements BillService {
    @Resource
    BillDao billDao;
    @Override
    public List<BillInfo> queryAllBills() {
        return billDao.queryAllBills();
    }

    @Override
    public void addNewBill(BillInfo billInfo) {
        billInfo.setBillId(SeqBuilder.buildBillId());
        billDao.saveNewBill(billInfo);
    }
}
