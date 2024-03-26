package com.example.toamto.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Page<T> {
    private int page;//分页起始页
    private int size;//每页记录数
    private List<T> list;//返回的记录集合

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    private long total;//总记录条数


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }



    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "page=" + page +
                ", size=" + size +
                ", list=" + list +
                ", total=" + total +
                '}';
    }
}
