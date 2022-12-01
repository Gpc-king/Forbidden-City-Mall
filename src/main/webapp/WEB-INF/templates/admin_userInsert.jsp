<%--
  Created by IntelliJ IDEA.
  User: Peng
  Date: 2022/4/1
  Time: 12:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
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
    <span id="time">2022年02月21日 08:31  星期一</span>
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
            <span><a href="${pageContext.request.contextPath}/user/admin/1">用户管理页面</a> >> 用户插入页面</span>
        </div>
        <div class="providerAdd">
            <form action="${pageContext.request.contextPath}/admin/insert" method="post">

                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="username">用户名：</label>
                    <input type="text" name="username" required id="username"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="password">密码：</label>
                    <input type="text" name="password" maxlength="9" required id="password"/>
                    <span >*</span>
                </div>
                <div>
                    <label>性别：</label>
                    男<input type="radio" value="男" name="sex" id="sex1" checked>
                    女<input type="radio" value="女" name="sex" id="sex2">
                    <span >*</span>
                </div>

                <div>
                    <label for="email">邮箱：</label>
                    <input type="email" name="email" id="email" required/>
                    <span >*</span>
                </div>

                <div>
                    <label for="tel">电话：</label>
                    <input type="tel" name="tel" maxlength="11" minlength="11" required id="tel"/>
                    <span >*</span>
                </div>

                <div>
                    <label for="address">地址：</label>
                    <input type="text" required name="address" id="address"/>
                    <span >*</span>
                </div>

                <div>
                    <label>用户类型：</label>
                    管理员<input type="radio" value="1" name="isAdmin" id="type1">
                    用户<input type="radio" value="0" name="isAdmin" id="type2" checked>
                    <span >*</span>
                </div>

                <div class="providerAddBtn">
                    <input type="submit" value="保存"/>
                </div>
            </form>
        </div>

    </div>
</section>
<footer class="footer">
</footer>

<script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
<script src="${pageContext.request.contextPath}/static/js/js.js"></script>
<script src="${pageContext.request.contextPath}/static/js/time1.js"></script>
<script src="${pageContext.request.contextPath}/static/js/when.js"></script>

</body>
</html>
