package com.dy.dao;

import com.dy.bean.Book;

import java.util.List;
import java.util.Map;

/*与Book或者Message配置文件相对应的接口*/
public interface IMessage {
    public List<Book> queryMessageList(Map<String,Object> parameter);

    public int count(Book book);
    public void deleteOne(int id);
    public void deleteBatch(List<Integer> ids);
    public  void insertOne(Book book);
}
