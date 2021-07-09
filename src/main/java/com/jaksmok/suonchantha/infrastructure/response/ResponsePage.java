package com.jaksmok.suonchantha.infrastructure.response;


public class ResponsePage {
    private int page;
    private int totalPage;
    private long totalElements;
    private int pageSize;

    public ResponsePage(int page, int totalPage, long totalElements, int pageSize) {
        this.page = page;
        this.totalPage = totalPage;
        this.totalElements = totalElements;
        this.pageSize = pageSize;
    }

    public ResponsePage() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
