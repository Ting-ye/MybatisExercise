package com.dy.servlet;

import com.dy.bean.Book;
import com.dy.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "insertOneServlet")
public class insertOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type=request.getParameter("type");
        if(type==null) {
            request.getRequestDispatcher("/WEB-INF/jsp/addOneBook.jsp").forward(request, response);
        }
        if("addOne".equals(type)){
            String bookname = request.getParameter("bookname");
            String author = request.getParameter("author");
            String publishhouse = request.getParameter("publishhouse");
            String repertory = request.getParameter("repertory");
            MaintainService maintainService = new MaintainService();
            maintainService.insertOne(bookname,author,publishhouse,Integer.parseInt(repertory));
            request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request,response);
        }
    }
}
