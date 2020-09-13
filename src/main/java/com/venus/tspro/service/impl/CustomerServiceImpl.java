package com.venus.tspro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.venus.tspro.dao.CustomerDao;
import com.venus.tspro.entity.CustomerInfo;
import com.venus.tspro.global.PageVO;
import com.venus.tspro.service.CustomerService;
import com.venus.tspro.utils.DateUtil;
import com.venus.tspro.utils.PageVOUtil;
import com.venus.tspro.utils.SeqBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 客户信息管理service
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Resource
    CustomerDao customerDao;

    /**
     * 查询客户信息
     *
     * @param customerInfo
     * @return
     */
    @Override
    public PageVO<CustomerInfo> getCustomerData(CustomerInfo customerInfo) {
        PageHelper.startPage(customerInfo.getPageNumber(), customerInfo.getPageSize());
        List<CustomerInfo> customerInfos = customerDao.getCustomerData(customerInfo);
        PageVO<CustomerInfo> pageVO = PageVOUtil.convert(new PageInfo<>(customerInfos));
        return pageVO;
    }

    /**
     * 添加客户信息
     *
     * @param customerInfo
     */
    @Override
    public void addCustomerData(CustomerInfo customerInfo) {
        customerInfo.setCustId(SeqBuilder.buildCustomerCustId());
        customerInfo.setOptUser("");//操作人
        customerInfo.setAgreement("");//合同存放路径
        customerInfo.setStatus("1");
        customerInfo.setCreateTime(DateUtil.getCurrentDateByPattern("yyyy-MM-dd HH:mm:ss"));
        customerInfo.setUpdateTime(DateUtil.getCurrentDateByPattern("yyyy-MM-dd HH:mm:ss"));
        customerDao.addCustomerData(customerInfo);
    }

    /**
     * 修改客户信息
     *
     * @param customerInfo
     */
    @Override
    public void editCustomerData(CustomerInfo customerInfo) {
        customerInfo.setOptUser("");//操作人
        customerInfo.setAgreement("");//若有变化，需修改合同存放路径
        customerInfo.setUpdateTime(DateUtil.getCurrentDateByPattern("yyyy-MM-dd HH:mm:ss"));
        customerDao.editCustomerData(customerInfo);
    }

    /**
     * 删除客户信息
     *
     * @param customerInfo
     */
    @Override
    public void deleteCustomerData(CustomerInfo customerInfo) {
        customerInfo.setOptUser("");//操作人
        customerDao.deleteCustomerData(customerInfo);
    }
}
