package com.dy.servlet;

import com.dy.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "InsertBatchServlet")
public class InsertBatchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String type=request.getParameter("type");
        if(type==null) {
            request.getRequestDispatcher("/WEB-INF/jsp/addBatchBook.jsp").forward(request, response);
        }
        if("addBatch".equals(type)) {
            String number = request.getParameter("number");
            String[] content = request.getParameterValues("content");
            String[] commandId = request.getParameterValues("commandId");
            MaintainService maintainService = new MaintainService();
            maintainService.insertBatch(Integer.parseInt(number), content, commandId);
            request.getRequestDispatcher("/WEB-INF/jsp/success.jsp").forward(request, response);
        }
    }
}
