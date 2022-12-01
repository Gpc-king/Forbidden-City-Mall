<%@ page import="com.peng.fcmall.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Peng
  Date: 2022/4/26
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/public.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/style.css"/>
    <link rel="script" href="${pageContext.request.contextPath}/static/js/when.js">
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>后台管理系统</h1>

    <div class="publicHeaderR">
        <p><span id="isWhens"></span><span style="color: #fff21b"> Admin</span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/user/exit">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2022年02月21日 10:21  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="${pageContext.request.contextPath}/user/admin/1">系统主页</a></li>

                <li><a href="${pageContext.request.contextPath}/user/admin/1">用户管理</a></li>

                <li><a href="${pageContext.request.contextPath}/user/exit">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span><a href="${pageContext.request.contextPath}/user/admin/1">用户管理页面</a> >> 用户信息查看页面</span>
        </div>
        <div class="providerView">
            <%
                try {
                    User user = (User) session.getAttribute("userID");
            %>
            <p><strong>会员码：</strong><span><%=user.getMemberCode()%></span></p>
            <p><strong>用户名：</strong><span><%=user.getUsername()%></span></p>
            <p><strong>密码：</strong><span><%=user.getPassword()%></span></p>
            <p><strong>性别：</strong><span><%=user.getSex()%></span></p>
            <p><strong>邮箱：</strong><span><%=user.getEmail()%></span></p>
            <p><strong>电话：</strong><span><%=user.getTel()%></span></p>
            <p><strong>用户类别：</strong><span><%
                if (user.isAdmin()) {
            %>
                    管理员
                    <%
                    } else {
                    %>
                    普通会员
                    <%
                        }
                    %></span></p>
            <%
                } catch (Exception e) {
                    response.sendRedirect("error.jsp");
                }
            %>
            <a onclick="history.back(-1)">返回</a>
        </div>
    </div>
</section>
<footer class="footer">
</footer>
<script src="${pageContext.request.contextPath}/static/js/time1.js"></script>
<script src="${pageContext.request.contextPath}/static/js/when.js"></script>
</body>
</html>
