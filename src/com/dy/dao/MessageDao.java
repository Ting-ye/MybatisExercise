package com.dy.dao;

import com.dy.bean.Book;
import com.dy.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*、
* 这是一个专门用来操作boo表的类
* */
public class MessageDao {
    //根据查询条件查询book列表
    public List<Book> queryMessageList(String bookname, String author){
        DBAccess dbAccess=new DBAccess();
        List<Book> bookList=new ArrayList<Book>();
        SqlSession sqlSession=null;
        try {
            sqlSession= dbAccess.getSqlSession();
            Book book=new Book();
            book.setBookname(bookname);
            book.setAuthor(author);
            //通过sqlSession执行SQL语句
            bookList=sqlSession.selectList("Book.queryMessageList",book);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null)
            {
            sqlSession.close();}
        }
        return bookList;
    }


}
