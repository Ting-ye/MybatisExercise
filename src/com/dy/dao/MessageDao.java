package com.dy.dao;

import com.dy.bean.Book;
import com.dy.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*、
* 这是一个专门用来操作book表的类
* */

//查询类
public class MessageDao {

    public List<Book> queryMessageList(Map<String,Object> parameter){
        DBAccess dbAccess=new DBAccess();
        List<Book> bookList=new ArrayList<Book>();
        SqlSession sqlSession=null;
        try {
            sqlSession= dbAccess.getSqlSession();
            //通过sqlSession执行SQL语句
            IMessage iMessage=sqlSession.getMapper(IMessage.class);
            bookList= iMessage.queryMessageList(parameter);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null)
            {
                sqlSession.close();}
        }
        return bookList;
    }

    public int count(Book book){
        DBAccess dbAccess=new DBAccess();
        SqlSession sqlSession=null;
        int result=0;
        try {
            sqlSession=dbAccess.getSqlSession();
            IMessage iMessage=sqlSession.getMapper(IMessage.class);
            result=iMessage.count(book);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }
        return result;
    }

//    //根据查询条件查询book列表
//    public List<Book> queryMessageList(String bookname, String author){
//        DBAccess dbAccess=new DBAccess();
//        List<Book> bookList=new ArrayList<Book>();
//        SqlSession sqlSession=null;
//        try {
//            sqlSession= dbAccess.getSqlSession();
//            Book book=new Book();
//            book.setBookname(bookname);
//            book.setAuthor(author);
//            //通过sqlSession执行SQL语句
//            IMessage iMessage=sqlSession.getMapper(IMessage.class);
//            bookList= iMessage.queryMessageList(book);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            if(sqlSession!=null)
//            {
//            sqlSession.close();}
//        }
//        return bookList;
//    }


    //删除单挑数据的类
        public  void deleteOne(int id){
            DBAccess dbAccess=new DBAccess();
            SqlSession sqlSession=null;
            try {
                sqlSession= dbAccess.getSqlSession();
                //通过sqlSession执行SQL语句
                IMessage iMessage=sqlSession.getMapper(IMessage.class);
                iMessage.deleteOne(id);
                sqlSession.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (sqlSession != null) {
                    sqlSession.close();
                }
            }
    }

    //批量删除数据的类
    public  void deleteBatch(List<Integer> ids){
        DBAccess dbAccess=new DBAccess();
        SqlSession sqlSession=null;
        try {
            sqlSession= dbAccess.getSqlSession();
            //通过sqlSession执行SQL语句
           IMessage iMessage=sqlSession.getMapper(IMessage.class);
           iMessage.deleteBatch(ids);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


    //插入数据单条
    public  void insertOne(Book book){
        DBAccess dbAccess=new DBAccess();
        SqlSession sqlSession=null;
        try {
            sqlSession= dbAccess.getSqlSession();
            //通过sqlSession执行SQL语句
            IMessage iMessage=sqlSession.getMapper(IMessage.class);
            iMessage.insertOne(book);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
