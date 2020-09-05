package com.venus.tspro.utils;


import com.github.pagehelper.PageInfo;
import com.venus.tspro.global.PageVO;
import org.springframework.stereotype.Component;

/**
 * 分页查询结果对象转换工具类
 */
@Component
public class PageVOUtil {

    private PageVOUtil() {
    }

    /**
     * 将pageInfo中的分页信息转换到PageVO中
     */
    public static <K> PageVO<K> convert(PageInfo<K> pageInfo) {
        PageVO<K> pageVO = new PageVO<K>();
        pageVO.setPageNum(pageInfo.getPageNum());
        pageVO.setPageSize(pageInfo.getPageSize());
        pageVO.setSize(pageInfo.getSize());
        pageVO.setTotal(pageInfo.getTotal());
        pageVO.setPages(pageInfo.getPages());
        pageVO.setFirstPage(pageInfo.getNavigateFirstPage());
        pageVO.setPrePage(pageInfo.getPrePage());
        pageVO.setNextPage(pageInfo.getNextPage());
        pageVO.setLastPage(pageInfo.getNavigateLastPage());
        pageVO.setList(pageInfo.getList());
        return pageVO;
    }
}