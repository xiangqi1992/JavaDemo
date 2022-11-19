package com.learning.mybatis;

import java.util.List;

// 封装查询结果的POJO
public class PageVO<T> {

    /**
     * 每页条数
     */
    private int pageSize;
    /**
     * 页码
     */
    private int pageNum;

    /**
     * 总页数
     */
    private int pages;
    /**
     * 总条数
     */
    private int total;

    /**
     * 当前页的数据
     */
    private List<T> data;

    public PageVO(int pageSize, int pageNum, int total, List<T> data) {
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.total = total;
        this.data = data;
        this.pages = total / pageSize + (total % pageSize == 0 ? 0 : 1);
    }

    // 省略get/set方法


    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    @Override
    public java.lang.String toString() {
        return "PageVO{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", pages=" + pages +
                ", total=" + total +
                ", data=" + data +
                '}';
    }
}