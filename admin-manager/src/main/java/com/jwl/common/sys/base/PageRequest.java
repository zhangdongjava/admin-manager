package com.jwl.common.sys.base;

public class PageRequest {

    private int current=1;
    private int pageSize = 10;

    public PageRequest() {
    }

    public PageRequest(int current, int pageSize) {
        this.current = current;
        this.pageSize = pageSize;
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

    public int getOffset(){
      return   pageSize*( current-1);
    }
}
