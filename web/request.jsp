<%--
  Created by IntelliJ IDEA.
  User: Zack
  Date: 2016/11/29
  Time: ����8:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=gb2312"%>
<%request.setCharacterEncoding("gb2312");%>
<html>
<head>
    <title>request����_��1</title>
</head>
<body bgcolor="#FFFFF0">
<form action="" method="post">
    <input type="text" name="qwe">
    <input type="submit" value="�ύ">
</form>
����ʽ��<%=request.getMethod()%><br>
�������Դ��<%=request.getRequestURI()%><br>
�����õ�Э�飺<%=request.getProtocol()%><br>
������ļ�����<%=request.getServletPath()%><br>
����ķ�������IP��<%=request.getServerName()%><br>
����������Ķ˿ڣ�<%=request.getServerPort()%><br>
�ͻ���IP��ַ��<%=request.getRemoteAddr()%><br>
�ͻ�����������<%=request.getRemoteHost()%><br>
���ύ����ֵ��<%=request.getParameter("qwe")%><br>
</body>
</html>