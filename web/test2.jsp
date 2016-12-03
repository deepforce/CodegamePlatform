<%--
  Created by IntelliJ IDEA.
  User: Zack
  Date: 2016/11/29
  Time: 下午7:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="Spirit.Tank" pageEncoding="UTF-8"%>
<html>
<head>
    <title>测试</title>
</head>
<body>

<% int varMC = 1; %>
<form name = "insertForm" method = "post" action="test2.jsp">
    <input type = "hidden" name = "mc" value = "<%=varMC%>">
</form>

<script src="js/test2.js"></script>
</body>
</html>
