package com.venus.tspro.dao;

import com.venus.tspro.entity.CustomerInfo;

import java.util.List;

/**
 * 客户信息管理dao
 */
public interface CustomerDao {
    List<CustomerInfo> getCustomerData(CustomerInfo customerInfo);

    void addCustomerData(CustomerInfo customerInfo);

    void editCustomerData(CustomerInfo customerInfo);

    void deleteCustomerData(CustomerInfo customerInfo);
}
