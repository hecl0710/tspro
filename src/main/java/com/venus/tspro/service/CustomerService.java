package com.venus.tspro.service;

import com.venus.tspro.entity.CustomerInfo;
import com.venus.tspro.global.PageVO;

/**
 * 客户信息管理service
 */
public interface CustomerService {
    PageVO<CustomerInfo> getCustomerData(CustomerInfo customerInfo);

    void addCustomerData(CustomerInfo customerInfo);

    void editCustomerData(CustomerInfo customerInfo);

    void deleteCustomerData(CustomerInfo customerInfo);
}
