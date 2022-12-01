<%@ page import="com.peng.fcmall.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Peng
  Date: 2022/4/24
  Time: 17:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>个人中心</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/userInfo.css">

</head>
<body>
<!-- 导航栏 -->
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="user_title">
        <h1>
            <span class="tit_span"><img src="${pageContext.request.contextPath}/static/img/l.png" width="20px"></span>
            <span> 个人信息 </span> <span class="tit_span"><img
                src="${pageContext.request.contextPath}/static/img/r.png" width="20px"></span>
        </h1>
    </div>
    <p>Welcome!</p>
    <%
        User u = (User) session.getAttribute("userInfo");
    %>
    <div class="user_content">
        <table>
            <tr>
                <td>姓名：</td>
                <td><%=u.getUsername()%></td>
            </tr>

            <tr>
                <td>会员码：</td>
                <td><%=u.getMemberCode()%></td>
            </tr>

            <tr>
                <td>密码：</td>
                <td><%=u.getPassword()%></td>
            </tr>

            <tr>
                <td>Email:</td>
                <td><%=u.getEmail()%></td>
            </tr>

            <tr>
                <td>性别：</td>
                <td><%=u.getSex()%></td>
            </tr>

            <tr>
                <td>电话：</td>
                <td><%=u.getTel()%></td>
            </tr>

            <tr>
                <td>地址：</td>
                <td><%=u.getAddress()%></td>
            </tr>


        </table>
        <ul>
            <li style="text-align: center;">
                <a href="${pageContext.request.contextPath}/user/update"><span style="color: white;">修改信息</span></a>
                <a href="${pageContext.request.contextPath}/user/delete/<%=u.getId() %>"><span style="color: white;">注销账号</span></a>
            </li>
        </ul>
    </div>
    <a href="${pageContext.request.contextPath}/user/exit">
        <div class="user_exit">
            <p>
                <br>退出<br>登录
            </p>
        </div>
    </a>
</div>
<jsp:include page="footer.jsp"/>
<script src="${pageContext.request.contextPath}/static/js/time.js"></script>
</body>
</html>

