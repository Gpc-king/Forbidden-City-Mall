<%@ page import="com.peng.fcmall.pojo.User" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Peng
  Date: 2022/4/26
  Time: 9:47
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

                <li><a href="${pageContext.request.contextPath}/user/order">订单页面</a></li>

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
            <form action="${pageContext.request.contextPath}/user/admin/1" method="post">
                <span>用户名：</span>
                <input type="text" name="is" placeholder="请输入用户名"/>
                <input type="submit" value="查询"/>
                <a href="${pageContext.request.contextPath}/admin/out" style="background-color: #FFC125">一键导出</a>
                <a href="${pageContext.request.contextPath}/admin/add" style="background-color: #FFC125">添加用户</a>
            </form>
        </div>

        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">会员码</th>
                <th width="10%">用户名</th>
                <th width="10%">密码</th>
                <th width="10%">电话</th>
                <th width="15%">邮箱</th>
                <th width="10%">性别</th>
                <th width="15%">地址</th>
                <th width="10%">身份</th>
                <th width="10%">操作</th>
            </tr>
            <%
                List<User> userList = ((List<User>) session.getAttribute("userList"));
            %>
            <%
                if (userList != null && userList.size() > 0) {

                    for (User user : userList) {
            %>
            <tr>
                <td><%=user.getMemberCode()%>
                </td>
                <td><%=user.getUsername()%>
                </td>
                <td><%=user.getPassword()%>
                </td>
                <td><%=user.getTel()%>
                </td>
                <td><%=user.getEmail()%>
                </td>
                <td><%=user.getSex()%>
                </td>
                <td><%=user.getAddress()%>
                </td>
                <td><%
                    if (user.isAdmin()) {
                %>
                    管理员
                    <%
                    } else {
                    %>
                    普通会员
                    <%
                        }
                    %>
                </td>
                <td>
                    <a href="${pageContext.request.contextPath}/admin/view/<%=user.getId()%>"><img
                            src="${pageContext.request.contextPath}/static/img/read.png" alt="查看" title="查看"/></a>
                    <a href="${pageContext.request.contextPath}/admin/update/<%=user.getId()%>"><img
                            src="${pageContext.request.contextPath}/static/img/xiugai.png" alt="修改" title="修改"/></a>
                    <a href="${pageContext.request.contextPath}/admin/delete/<%=user.getId() %>" class="removeUser"><img
                            src="${pageContext.request.contextPath}/static/img/schu.png"
                            alt="删除"
                            title="删除"/></a>
                </td>
            </tr>
            <%
                    }

            %>
            <tr>
                <td colspan="9">
                    <c:if test="${countLine > 5}">
                    <a href="${pageContext.request.contextPath}/user/admin/1">
                        <div>[首页]</div>
                    </a>

                    <c:forEach var="i" begin="1" end="${n}">
                        <a href="${pageContext.request.contextPath}/user/admin/${i }">
                            [<c:out value="${i }"/>]
                        </a>
                    </c:forEach>

                    <a href="${pageContext.request.contextPath}/user/admin/${n }">
                        <div>[末页]</div>
                    </a>
                    </c:if>
                </td>
            </tr>
            <%
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
