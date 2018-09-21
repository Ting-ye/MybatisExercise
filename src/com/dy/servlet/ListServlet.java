package com.dy.servlet;

import com.dy.entity.Page;
import com.dy.service.QueryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

/*
* 后台维护显示数据页面的初始化
* */
@WebServlet(name = "ListServlet")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //接受页面传过来的值
        String bookname=request.getParameter("bookname");
        String author=request.getParameter("author");
        String currentPage=request.getParameter("currentPage");
        Page page=new Page();
        Pattern pattern=Pattern.compile("[0-9]{1,9}");
        if(currentPage==null || !pattern.matcher(currentPage).matches()){
            page.setCurrentPage(1);
        }else{
            page.setCurrentPage(Integer.parseInt(currentPage));
        }
        QueryService queryService =new QueryService();
        //查询消息列表并传给页面
        request.setAttribute("bookList", queryService.queryMessageList(bookname,author,page));
        //向页面传值
        request.setAttribute("bookname",bookname);
        request.setAttribute("author",author);
        request.setAttribute("page",page);
        //跳转
        request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request,response);
    }
}
