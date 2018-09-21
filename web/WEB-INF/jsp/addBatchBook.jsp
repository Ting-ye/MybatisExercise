<%--
  Created by IntelliJ IDEA.
  User: p13
  Date: 18/9/21
  Time: 10:29
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
<form action="<%=basePath%>InsertBatchServlet?type=addBatch" method="post">
    <table class="tab2" width="100%">
        <tr>
            <th>序号</th>
            <th>指令内容</th>
            <th>指令id</th>
        </tr>
        <tr>
            <td>1</td>
            <td><input type="text" name="content"></td>
            <td><input type="text" name="commandId"></td>
        </tr>
        <tr>
            <td><input type="text" name="number"></td>
            <td><input type="text" name="content"></td>
            <td><input type="text" name="commandId"></td>
        </tr>
    </table>
    <input type="submit" value="提交" />
</form>
</body>
</html>
