package com.venus.tspro.service.impl;

import com.alibaba.fastjson.JSON;
import com.venus.tspro.dao.BillDao;
import com.venus.tspro.entity.BillInfo;
import com.venus.tspro.service.BillService;
import com.venus.tspro.utils.SeqBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BillServiceImpl implements BillService {
    @Resource
    BillDao billDao;
    @Override
    public List<BillInfo> queryAllBills(Map<String,String> billInfoMap) {
        return billDao.queryAllBills(billInfoMap);
    }

    @Override
    public void addNewBill(BillInfo billInfo) {
        log.info("接收到新增发票请求：{}", JSON.toJSONString(billInfo));
        billInfo.setBillId(SeqBuilder.buildBillId());
        billDao.saveNewBill(billInfo);
    }

    @Override
    public void editBill(BillInfo billInfo) {
        log.info("接收到编辑发票请求：{}", JSON.toJSONString(billInfo));
        billDao.updateBill(billInfo);
    }
}
