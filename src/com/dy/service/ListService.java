package com.dy.service;

import com.dy.bean.Book;
import com.dy.dao.MessageDao;

import java.util.List;

/*书本相关的业务功能*/
public class ListService {
    public List<Book> queryMessageList(String bookname, String author) {
        MessageDao messageDao=new MessageDao();
        return messageDao.queryMessageList(bookname,author);
    }

}
