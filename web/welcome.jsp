<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2017/9/11
  Time: 15:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <%
      String contextPath = request.getContextPath();
      String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+
              contextPath+"/";
    %>
    <title>欢迎页面</title>
    <base href="<%= basePath%>">
    <style>
      .bd1{
        background-image: url("images/bg.jpg");
        background-repeat:no-repeat;
        background-size:100% 100%;
        background-attachment:fixed;
      }
      .div1 {
        margin: 13% 33%;
        width: 26%;
        height: 20%;
        border: solid #7a5b5b;
        border-radius: 11px;
      }
      .font{
        font-size: x-large;
        color: black;
      }
      a{
        margin-left: 29%;
        text-decoration: none;
      }
    </style>
  </head>
  <body class="bd1">
  <div class="div1">
    <a href="page/admin/adminLogin.jsp"><span class="font">管理员登录</span></a><br /><br /><br />
    <a href="isNeed_login_Customer.do"><span class="font">用户界面</span></a>
  </div>
  </body>
</html>
