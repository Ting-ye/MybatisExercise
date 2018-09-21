<%--
  Created by IntelliJ IDEA.
  User: p13
  Date: 18/9/20
  Time: 14:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    // 获得本项目的地址(例如: http://localhost:8080/MyApp/)赋值给basePath变量
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    // 将 "项目路径basePath" 放入pageContext中，待以后用EL表达式读出。
    pageContext.setAttribute("basePath", basePath);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="<%=basePath%>insertOneServlet?type=addOne" id="mainForm" method="post">
        书&nbsp;&nbsp;名：<input type="text" id="bookname" name="bookname"/><br />
        作&nbsp;&nbsp;者：<input type="text" id="author" name="author"/><br />
        出版商：<input type="text" id="publishhouse" name="publishhouse"/><br />
        库&nbsp;&nbsp;存：<input type="text" id="repertory" name="repertory" /><br />
        <input type="submit" value="确认插入">
    </form>
</body>
</html>
