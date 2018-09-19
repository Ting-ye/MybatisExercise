package com.dy.dao;

import com.dy.bean.Book;
import com.dy.bean.Command;
import com.dy.db.DBAccess;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
* 与Command表相对应的数据库操作类
* */
public class CommandDao {
    //根据查询条件查询Command列表 只需要在Servlet中改变一下调用CommandDao而不是MessageDao
    //修改顺序dao》》service》》servlet
    public List<Command> queryCommandList(String name, String description){
        DBAccess dbAccess=new DBAccess();
        List<Command> commandList=new ArrayList<Command>();
        SqlSession sqlSession=null;
        try {
            sqlSession= dbAccess.getSqlSession();
            Command command=new Command();
            command.setName(name);
            command.setDescription(description);
            //通过sqlSession执行SQL语句
            commandList=sqlSession.selectList("Command.queryCommandList",command);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(sqlSession!=null)
            {
                sqlSession.close();}
        }
        return commandList;
    }
}
