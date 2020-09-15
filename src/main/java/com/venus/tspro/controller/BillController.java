package com.venus.tspro.controller;

import com.github.pagehelper.PageInfo;
import com.venus.tspro.entity.BillInfo;
import com.venus.tspro.global.PageVO;
import com.venus.tspro.service.BillService;
import com.venus.tspro.utils.PageVOUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("bill")
public class BillController {

    @Resource
    BillService billService;

    @PostMapping("list")
    public PageVO<BillInfo> queryAllBills(){
        return PageVOUtil.convert(new PageInfo<>(billService.queryAllBills()));
    }

    @PostMapping("add")
    public void addNewBill(@RequestBody BillInfo billInfo){
        billService.addNewBill(billInfo);
    }

    @PostMapping("edit")
    public void editBill(@RequestBody BillInfo billInfo){
        billService.editBill(billInfo);
    }
}
