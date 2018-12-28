package com.jwl.common.sys.base;

public class PageResponse <D>{
    private int current;
    private int pageSize;
    private int total;
    private D data;

    public PageResponse() {
    }

    public PageResponse(D data,int current, int pageSize, int total) {
        this.current = current;
        this.data = data;
        this.pageSize = pageSize;
        this.total = total;
    }

    public PageResponse(D data,PageRequest request, int total) {
        this.current = request.getCurrent();
        this.data = data;
        this.pageSize = request.getPageSize();
        this.total = total;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public D getData() {
        return data;
    }
}
