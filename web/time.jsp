<%--
  Created by IntelliJ IDEA.
  User: Zack
  Date: 2016/11/29
  Time: 下午8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.Calendar" language="java" %>
<html>
<head>
    <title>Time</title>
</head>
<body>
<%
    Calendar today = Calendar.getInstance();
    out.println("Now is " + today.get(Calendar.HOUR_OF_DAY)+"h "+ today.get(Calendar.MINUTE) + "m " + today.get(Calendar.SECOND) + "s.");
%>
</body>
</html>
