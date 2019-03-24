package com.jzzx.util;
/**
 * 分页
 * */
public class PageUtil {  
    /**每页多少条数据*/  
    private int pageSize = 10;  
    /**总记录条数*/  
    private int totalCount;     
    /**当前页*/  
    private int currentPage;  
    /**总页数*/  
    private int pageCount;  
  
    public PageUtil(int pageSize, int totalCount, int currentPage) {  
        this.pageSize = pageSize;  
        this.totalCount = totalCount;  
        this.setCurrentPage(currentPage);  
    }  
      
    public void setCurrentPage(int currentPage) {  
        int activePage = currentPage <= 0 ? 1 : currentPage;  
        activePage = activePage > getPageCount() ? getPageCount() : activePage;  
        this.currentPage = activePage;  
    }  
    public int getPageCount() {  
        pageCount = totalCount / pageSize;  // 26  /  10     2     
        int mod = totalCount % pageSize;    // 26  %  10     6     
        if (mod != 0) {  
            pageCount++;   //3  
        }  
        return totalCount == 0 ? 1 : pageCount;  
    }  
    public int getFromIndex() {  
        return (currentPage - 1) * pageSize;  
    }  
  
    public int getToIndex() {  
        return Math.min(totalCount, currentPage * pageSize);  
    }  
  
    public int getPageSize() {  
        return pageSize;  
    }  
  
    public void setPageSize(int pageSize) {  
        this.pageSize = pageSize;  
    }  
}  