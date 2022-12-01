<%@ page import="com.peng.fcmall.pojo.User" %>
<%@ page import="java.util.List" %>
<%@ page import="com.peng.fcmall.pojo.OrderItem" %><%--
  Created by IntelliJ IDEA.
  User: Peng
  Date: 2022/4/27
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <%
            User u = (User) session.getAttribute("userInfo");
        %>
        <p><span id="isWhens"></span><span style="color: #fff21b"><%=u.getUsername()%> </span> , 欢迎你！</p>
        <a href="${pageContext.request.contextPath}/user/exit">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2022年02月21日 08:31  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">

                <li><a href="${pageContext.request.contextPath}/user/admin/1">用户管理</a></li>

                <li><a href="${pageContext.request.contextPath}/user/exit">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面</span>
        </div>
        <div class="search">
            <a href="${pageContext.request.contextPath}/admin/outOrder" style="background-color: #FFC125">一键导出</a>
        </div>
        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="20%">会员码</th>
                <th width="20%">用户名</th>
                <th width="20%">价钱</th>
                <th width="20%">方式</th>
                <th width="20%">时间</th>
            </tr>
            <%
                List<OrderItem> orderList = ((List<OrderItem>) session.getAttribute("orderList"));
            %>
            <%
                if (orderList != null && orderList.size() > 0) {

                    for (OrderItem ol : orderList) {
            %>
            <tr>
                <td><%=ol.getMemberCode()%>
                </td>
                <td><%=ol.getUsername()%>
                </td>
                <td><%=ol.getPrice()%>
                </td>
                <td><%=ol.getCate()%>
                </td>
                <td><%=ol.getTime()%>
                </td>
            </tr>
            <%
                }
            }
            else
            {
            %>
            <tr>
                <td colspan="9">
                    <h1>暂未查询到数据 (⊙ˍ⊙)</h1>
                </td>
            </tr>
            <%
                }
            %>
        </table>

    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="#" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<footer class="footer">
</footer>

<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/js/js.js"></script>
<script src="${pageContext.request.contextPath}/static/js/time1.js"></script>
<script src="${pageContext.request.contextPath}/static/js/when.js"></script>

</body>
</html>

