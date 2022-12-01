<%@ page import="com.peng.fcmall.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: Peng
  Date: 2022/4/24
  Time: 21:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- 页头 -->
<div class="bar">
    <!-- 欢迎语 -->
    <div class="bar_title">
        <p>欢迎来到紫禁城的小屋!</p>
    </div>

    <!-- 登陆注册 -->
    <div class="bar_rl">
        <%
            User u = (User) session.getAttribute("userInfo");
            if (u == null) { %>
        <p>
            <a href="${pageContext.request.contextPath}/user/login">注册</a> | <a
                href="${pageContext.request.contextPath}/user/login">登录</a>
        </p>
        <%
        } else {
        %>

        <p>
            <a href="${pageContext.request.contextPath}/user/PersonalCenter">
            <%=u.getUsername() %>&nbsp;欢迎！
            </a>


            <%if(u.isAdmin()){%>
            <a href="${pageContext.request.contextPath}/user/admin/1" target="_blank">
                后台
            </a>
            <%
            }
            %>
            &nbsp;&nbsp;
            <a href="${pageContext.request.contextPath}/user/exit">
                退出
            </a>
        </p>

        <%

            }
        %>

    </div>
    <!-- 时间 -->
    <div class="bar_time">
        <p id="time">2022年4月25日 00 : 00 : 00</p>
    </div>
</div>
<!-- 导航栏 -->
<div class="nav">
    <ul>
        <a href="${pageContext.request.contextPath}/nav/index">
            <li>产品分类</li>
        </a>
        <a href="${pageContext.request.contextPath}/nav/all/1/all">
            <li>全部商品</li>
        </a>
        <a href="${pageContext.request.contextPath}/nav/all/1/猫主子们">
            <li>猫主子们</li>
        </a>
        <a href="${pageContext.request.contextPath}/nav/all/1/文创用品">
            <li>文创用品</li>
        </a>
        <a href="${pageContext.request.contextPath}/nav/all/1/中国节日">
            <li>中国节日</li>
        </a>
        <a href="${pageContext.request.contextPath}/nav/all/1/温馨家具">
            <li>温馨家具</li>
        </a>
        <a href="${pageContext.request.contextPath}/nav/all/1/可爱包包">
            <li>可爱包包</li>
        </a>
        <a href="${pageContext.request.contextPath}/nav/car">
            <li>购物车</li>
        </a>
    </ul>
</div>

<script href="${pageContext.request.contextPath}/static/js/time.js"></script>
