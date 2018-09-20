package com.dy.service;

import com.dy.bean.Book;
import com.dy.bean.CommandContent;
import com.dy.dao.CommandContentDao;
import com.dy.dao.MessageDao;

import java.util.ArrayList;
import java.util.List;
/*这是用于维护数据库的类 增删改查*/
public class MaintainService {

    //批量删除数据
    public void deleteBatch(String[] ids) {
        MessageDao messageDao=new MessageDao();
        List<Integer> idList =new ArrayList<Integer>();
        for(String id:ids){
            idList.add(Integer.valueOf(id));
        }
        messageDao.deleteBatch(idList);

    }

    //删除单挑数据
    public void deleteOne(String id) {
        if(id!=null&&!"".equals(id.trim())){
        MessageDao messageDao=new MessageDao();
        messageDao.deleteOne(Integer.parseInt(id));
        }
    }

    //插入单挑数据
    public void insertOne(String bookname,String author,String publishhouse,int repertory) {
        Book book=new Book();
        book.setBookname(bookname);
        book.setAuthor(author);
        book.setPublishhouse(publishhouse);
        book.setRepertory(repertory);
        MessageDao messageDao=new MessageDao();
        messageDao.insertOne(book);

    }

    //批量插入数据
    public void insertBatch(String content,int commamdId){
        CommandContentDao commandContentDao=new CommandContentDao();
        List<CommandContent> contentList;
        
    }
}
