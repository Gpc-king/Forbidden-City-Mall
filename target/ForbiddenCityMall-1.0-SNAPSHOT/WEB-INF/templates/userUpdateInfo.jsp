<%--
  Created by IntelliJ IDEA.
  User: Peng
  Date: 2022/4/25
  Time: 13:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.peng.fcmall.pojo.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/userUpdateInfo.css">
</head>
<body>
<!-- 导航栏 -->
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="user_title">
        <h1>
            <span class="tit_span"><img src="${pageContext.request.contextPath}/static/img/l.png" width="20px"></span>
            <span> 修改信息 </span> <span class="tit_span"><img
                src="${pageContext.request.contextPath}/static/img/r.png" width="20px"></span>
        </h1>
    </div>
    <%
        User u = (User) session.getAttribute("userInfo");
    %>
    <div class="user_content">
        <form action="${pageContext.request.contextPath}/user/update" method="post">
            <input type="hidden" name="memberCode" value="<%=u.getMemberCode() %>"/>
            <input type="hidden" name="id" value="<%=u.getId() %>"/>
            <ul>
                <li>姓名：<input type="text" name="username" value="<%=u.getUsername()%>"></li>
                <li>密码：<input type="text" name="password"  value="<%=u.getPassword()%>"/></li>
                <li>电话：<input type="tel" name="tel"  value="<%=u.getTel()%>"/></li>
                <li>邮箱：<input type="email" name="email"  value="<%=u.getEmail()%>"/></li>
                <li>
    <%
        String male = "";
        String female = "";
        if ("男".equals(u.getSex())){
            male = "checked";
        }else{
            female = "checked";
        }
    %>
                    <label style="margin-right: 20px;">性别</label>
                    <input id="male" name="sex" type="radio" value="男" <%=male %>>
                    <label for="male" style="margin-right: 20px;">男</label>
                    <input id="female" name="sex" type="radio" value="女" <%=female %>>
                    <label for="female">女</label></li>
                <li>地址：<input type="text" name="address" value="<%=u.getAddress()%>"></li>
                <li style="text-align: center;">
                    <input type="submit" value="修改"/>
                </li>
                <li style="text-align: center;">
                    <a href="${pageContext.request.contextPath}/user/PersonalCenter"><span style="color: white;">返回上层</span></a>
                </li>
            </ul>
        </form>
    </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
