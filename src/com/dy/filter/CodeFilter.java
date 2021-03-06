package com.dy.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "CodeFilter")
public class CodeFilter implements Filter {
    private FilterConfig filterConfig;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response =(HttpServletResponse) resp;
        HttpSession session = request.getSession();
        //利用过滤器参数设置字符集
        String charset=filterConfig.getInitParameter("charset");
        if(charset==null){
            charset="UTF-8";
        }
        request.setCharacterEncoding(charset);
        chain.doFilter(request,response);
    }

    public void init(FilterConfig config) throws ServletException {
        filterConfig=config;
    }

}
