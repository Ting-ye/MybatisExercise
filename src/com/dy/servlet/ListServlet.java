package com.dy.servlet;

import com.dy.service.ListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListServlet")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //接受页面传过来的值
        String bookname=request.getParameter("bookname");
        String author=request.getParameter("author");
        //向页面传值
        request.setAttribute("bookname",bookname);
        request.setAttribute("author",author);
        ListService listService=new ListService();
        //查询消息列表并传给页面
        request.setAttribute("bookList",listService.queryMessageList(bookname,author));
        //跳转
        request.getRequestDispatcher("/WEB-INF/jsp/list.jsp").forward(request,response);
    }
}
