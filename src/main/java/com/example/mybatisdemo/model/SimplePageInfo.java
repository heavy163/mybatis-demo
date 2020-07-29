package com.example.mybatisdemo.model;

import com.github.pagehelper.PageInfo;

import java.util.List;

public class SimplePageInfo<T> {
    //当前页
    private int pageNum;
    //每页的数量
    private int pageSize;
    //当前页的数量
    private int size;

    //总页数
    private int pages;

    List<T> list;

    public SimplePageInfo(PageInfo<T> pageInfo){
        if(pageInfo != null){
            this.pageNum = pageInfo.getPageNum();
            this.pageSize = pageInfo.getSize();
            this.pages = pageInfo.getPages();
            this.size = pageInfo.getSize();
            this.list = pageInfo.getList();
        }
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
