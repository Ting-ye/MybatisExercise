package com.dy.bean;

public class Book {
    private int id;
    private String bookname;
    private String author;
    private String publishhouse;
    private Float price;
    private int repertory;
    private  int buybooknum=1;//购买数量
    public int getBuybooknum() {
        return buybooknum;
    }

    public void setBuybooknum(Integer buybooknum) {
        this.buybooknum = buybooknum;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishhouse() {
        return publishhouse;
    }

    public void setPublishhouse(String publishhouse) {
        this.publishhouse = publishhouse;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getRepertory() {
        return repertory;
    }

    public void setRepertory(Integer repertory) {
        this.repertory = repertory;
    }


}
