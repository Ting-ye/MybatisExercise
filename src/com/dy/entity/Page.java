package com.dy.entity;

public class Page {
    //数据的总条数
    private int totalNumber;
    //数据总页数
    private int totalPage;
    //当前页数
    private int currentPage;
    //每页显示的数据条数
    private int pageNumber=6;
    //数据库中limit参数从第几条数据开始
    private int dbIndex;
    //数据库中limit参数到第几条数据结束
    private int dbNumber;


    //根据对象中的属性值计算并设置相关属性值
    public void count(){
        //计算总页数
        int totalPageTemp=(this.totalNumber-1)/this.pageNumber+1;
        this.totalPage=totalPageTemp;

        //设置当前页数
        if(this.currentPage>this.totalPage){
            this.currentPage=this.totalPage;
        }
        //当前页数小于1则设置为1
        if(this.currentPage<1){
            this.currentPage=1;
        }
        //设置limit参数
        this.dbIndex=(this.currentPage-1)*this.pageNumber;
        this.dbNumber=this.pageNumber;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
        this.count();
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
        this.count();
    }

    public int getDbIndex() {
        return dbIndex;
    }

    public void setDbIndex(int dbIndex) {
        this.dbIndex = dbIndex;
    }

    public int getDbNumber() {
        return dbNumber;
    }

    public void setDbNumber(int dbNumber) {
        this.dbNumber = dbNumber;
    }




}
