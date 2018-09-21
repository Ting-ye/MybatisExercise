package com.dy.service;

import com.dy.bean.Book;
import com.dy.bean.Command;
import com.dy.bean.CommandContent;
import com.dy.dao.CommandDao;
import com.dy.dao.MessageDao;
import com.dy.entity.Page;
import com.dy.util.Iconst;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/*书本相关的业务功能*/
public class QueryService {
    public List<Book> queryMessageList(String bookname, String author, Page page){
        //组织消息对象
        Book book=new Book();
        book.setBookname(bookname);
        book.setAuthor(author);
        MessageDao messageDao=new MessageDao();
        //查询数据库条数
        int totalNumber=messageDao.count(book);
        page.setTotalNumber(totalNumber);
        Map<String,Object> parameter=new HashMap<String,Object>();
        parameter.put("book",book);
        parameter.put("page",page);
        return messageDao.queryMessageList(parameter);
    }

    /**
     * 通过指令查询自动回复的内容
     * @param command 指令
     * @return 自动回复的内容
     */
    public String queryByCommand(String command) {
        CommandDao commandDao = new CommandDao();
        List<Command> commandList;
        if(Iconst.HELP_COMMAND.equals(command)) {
            commandList = commandDao.queryCommandList(null, null);
            StringBuilder result = new StringBuilder();
            for(int i = 0; i < commandList.size(); i++) {
                if(i != 0) {
                    result.append("<br/>");
                }
                result.append("回复[" + commandList.get(i).getName() + "]可以查看" + commandList.get(i).getDescription());
            }
            return result.toString();
        }
        commandList = commandDao.queryCommandList(command, null);
        if(commandList.size() > 0) {
            List<CommandContent> contentList=commandList.get(0).getContentList();
            return contentList.get(new Random().nextInt(contentList.size())).getContent();
        }
        return Iconst.NO_MATCHING_CONTENT;
    }


}
