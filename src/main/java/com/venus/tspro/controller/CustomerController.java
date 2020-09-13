package com.venus.tspro.controller;

import com.venus.tspro.entity.CustomerInfo;
import com.venus.tspro.global.PageVO;
import com.venus.tspro.service.CustomerService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 客户信息管理controller
 */
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Resource
    CustomerService customerService;

    @RequestMapping("list")
    public PageVO<CustomerInfo> getTaskData(@RequestBody CustomerInfo customerInfo) {
        return customerService.getCustomerData(customerInfo);
    }

    /**
     * 添加客户信息
     *
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public void addTaskData(CustomerInfo customerInfo) {
        customerService.addCustomerData(customerInfo);
    }

    /**
     * 修改客户信息
     *
     * @param customerInfo
     * @return
     */
    @RequestMapping("edit")
    @ResponseBody
    public void editCustomerData(CustomerInfo customerInfo) {
        customerService.editCustomerData(customerInfo);
    }

    /**
     * 删除客户信息
     *
     * @param customerInfo
     */
    @RequestMapping("delete")
    @ResponseBody
    public void deleteCustomerData(CustomerInfo customerInfo) {
        customerService.deleteCustomerData(customerInfo);
    }
}
