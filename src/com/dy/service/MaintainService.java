package com.dy.service;

import com.dy.bean.Book;
import com.dy.dao.MessageDao;

import java.util.List;
/*这是用于维护数据库的类 增删改查*/
public class MaintainService {
    public void deleteOne(String id) {
        if(id!=null&&"".equals(id.trim())){
        MessageDao messageDao=new MessageDao();
        messageDao.deleteOne(Integer.parseInt(id));
        }
    }

}
