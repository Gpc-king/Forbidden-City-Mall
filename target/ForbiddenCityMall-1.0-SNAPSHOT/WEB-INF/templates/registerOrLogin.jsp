<%--
  Created by IntelliJ IDEA.
  User: Peng
  Date: 2022/4/23
  Time: 22:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <meta name="decorator" content="default"/>
    <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/registerOrLogin.css">

</head>
<body>
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
<div class="container">
    <div class="modal-dialog" id="login_form">
        <div class="modal-content">
            <div class="modal-title">
                <ul class="news-nav js-nav-title">
                    <li class="on" data="login">登录</li>
                    <li class="" data="register">注册</li>
                </ul>
            </div>
            <div class="modal-body index-news-list" id="index-news-list-1">
                <form class="loginForm" id="loginForm" action="${pageContext.request.contextPath}/user/login"
                      method="post">
                    <div>
                        <input type="radio" value="login" name="type" checked="checked"
                               hidden/>
                    </div>
                    <div class="form-group">
                        <input class="form-control required" name="account" id="account"
                               type="text" placeholder="请输入电话-邮箱-会员码">
                    </div>
                    <div class="form-group">
                        <input class="form-control required" name="password"
                               id="passwords" type="password" placeholder="请输入密码">
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary" type="submit">登录</button>
                    </div>
                </form>
            </div>

            <div class="modal-body index-news-list" id="index-news-list-2" style="padding-bottom: 60px">
                <form class="loginForm" id="registerForm" action="${pageContext.request.contextPath}/user/register"
                      method="post">
                    <div>
                        <input type="radio" value="register" name="type"
                               checked="checked" hidden/>
                    </div>
                    <div class="form-group">
                        <input class="form-control required" name="username" id="username"
                               type="text" placeholder="请输入要注册的用户名">
                    </div>
                    <div class="form-group">
                        <input class="form-control required" name="password"
                               id="password" minlength="6" maxlength="9" type="password" placeholder="请输入密码">
                    </div>
                    <div class="form-group">
                        <input class="form-control required" name="email"
                               id="email" type="email" placeholder="请输入邮箱">
                    </div>
                    <div class="form-group">
                        <input class="form-control required" name="tel"
                               id="tel" type="tel" maxlength="11" minlength="11" placeholder="请输入电话">
                    </div>
                    <div class="form-group">
                        <label style="margin-right: 20px;">性别</label>
                        <input id="male" name="sex" type="radio" value="男">
                        <label for="male" style="margin-right: 20px;">男</label>
                        <input id="female" name="sex" type="radio" value="女">
                        <label for="female">女</label>
                    </div>
                    <div class="form-group">
                        <input class="form-control required" name="address" id="address"
                               type="text" placeholder="请输入地址">
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary" type="submit">注册</button>
                    </div>
                </form>
            </div>

        </div>
    </div>
</div>
<%--底部--%>
<jsp:include page="footer.jsp"/>
<script>
    $(document).ready(function () {
        $(".js-nav-title li").click(function () {
            $(this).attr("class", "on");
            $(this).siblings().attr("class", "");
            var index = $(".js-nav-title li").index(this);
            $(".index-news-list").css("display", "none");
            $("#index-news-list-" + (index + 1)).css("display", "block");
        });
    });
</script>

</body>
</html>