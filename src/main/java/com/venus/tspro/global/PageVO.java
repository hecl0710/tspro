package com.venus.tspro.global;

import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
public class PageVO<T> {

    /**
     * 页码
     */
    private Integer pageNumber;

    /**
     * 每页数量
     */
    private Integer pageSize;

    /**
     * 当前页数量
     */
    private Integer size;

    /**
     * 总记录数
     */
    private Long total;

    /**
     * 总页数
     */
    private Integer pages;

    /**
     * 首页页码
     */
    private Integer firstPage;

    /**
     * 上一页页码
     */
    private Integer prePage;

    /**
     * 下一页页码
     */
    private Integer nextPage;

    /**
     * 末页页码
     */
    private Integer lastPage;

    /**
     * 数据
     */
    private List<T> list;


}
