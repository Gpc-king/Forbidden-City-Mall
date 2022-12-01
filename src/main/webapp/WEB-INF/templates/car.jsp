<%--
  Created by IntelliJ IDEA.
  User: Peng
  Date: 2022/4/25
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.ArrayList" %>
<%@ page import="com.peng.fcmall.pojo.Product" %>
<%@ page import="com.peng.fcmall.pojo.Car" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>我的车</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/car.css">


</head>
<body>
<jsp:include page="header.jsp"/>
<div style="width: 100%; height: 110vh">

    <!-- 车 -->
    <div class="container">
        <ul>
            <%
                boolean flag = true;
                ArrayList<Car> carList = null;
                int sum = 0;
                int count = 0;
                try {
                    carList = (ArrayList<Car>) session.getAttribute("carList");
                } catch (Exception e) {
                    flag = false;
                }
                if (flag && carList != null && carList.size() != 0) {
                    for (Car c : carList) {
                        sum += c.getNum() * c.getProduct().getPPrice();
                        count += c.getNum();
            %>
            <li>
                <div class="car">
                    <div class="car_img">
                        <%
                            String num = String.valueOf(c.getProduct().getPID());
                            String src = request.getContextPath() + "/static/img/t" + num + ".jpg";
                        %>
                        <img src=<%=src %> width="150px"/>
                    </div>
                    <div class="car_title">
                        <h3><%=c.getProduct().getPName()%>
                        </h3>
                        <p>
                            购买了：<%=c.getNum()%>件
                        </p>
                        <p>
                            共计：<%=c.getNum() * c.getProduct().getPPrice()%>元
                        </p>
                        <p>
                            <form action="${pageContext.request.contextPath}/products/remove/<%=c.getProduct().getPID()%>">
                                <input type="text" value="<%=c.getProduct().getPID()%>" name="PID" hidden="hidden">
                                <input type="number" value="1" name="num" min="1" max="<%=c.getNum()%>" class="bt">
                                <input type="submit" value="移除" class="bs">
                            </form>
                        </p>
                    </div>
                </div>
            </li>
            <%
                }
            %>
            <li>
                <div class="allInfo">
                    <div class="allInfos">
                        <p>
                            <a href="${pageContext.request.contextPath}/products/all">清空购物车</a>
                        </p>
                        <p>
                            所有产品共计：<%=count %>件
                        </p>
                        <p>
                            所有产品总计：<%=sum %>元
                        </p>
                    </div>
                </div>
            </li>
            <%
            } else {
            %>
            <li>
                <div class="car">
                    <h1 align="center">购物车空了，快来买吧！！！</h1>
                </div>
            </li>
            <%
                }
            %>

        </ul>
    </div>
</div>
<script src="${pageContext.request.contextPath}/static/js/time.js"></script>
</body>
</html>
