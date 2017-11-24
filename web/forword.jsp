<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/18
  Time: 11:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    out.println(request.getAttribute("key"));
    out.println(session.getAttribute("key"));
    out.println(pageContext.getAttribute("key"));
    out.println(application.getAttribute("key"));
%>
</body>
</html>
