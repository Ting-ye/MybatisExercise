package com.dy.dao;

import com.dy.bean.Book;
import com.dy.bean.CommandContent;
import com.dy.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class CommandContentDao {
    //批量插入数据
    public  void insertBatch(List<CommandContent> contentList){
        DBAccess dbAccess=new DBAccess();
        SqlSession sqlSession=null;
        try {
            sqlSession= dbAccess.getSqlSession();
            //通过sqlSession执行SQL语句
            ICommandContent iCommandContent=sqlSession.getMapper(ICommandContent.class);
            iCommandContent.insertBatch(contentList);
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
