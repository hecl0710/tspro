package com.venus.tspro.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.venus.tspro.dao.DistributeDao;
import com.venus.tspro.entity.Distribute;
import com.venus.tspro.global.PageVO;
import com.venus.tspro.service.DistributeService;
import com.venus.tspro.utils.PageVOUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 结算service
 */
@Service
public class DistributeServiceImpl implements DistributeService {

    @Resource
    DistributeDao distributeDao;

    @Override
    public PageVO<Distribute> getDistributeData(Distribute distribute) {
        PageHelper.startPage(distribute.getPageNumber(), distribute.getPageSize());
        List<Distribute> customerInfos = distributeDao.getDistributeData(distribute);
        PageVO<Distribute> pageVO = PageVOUtil.convert(new PageInfo<>(customerInfos));
        return pageVO;
    }
}
