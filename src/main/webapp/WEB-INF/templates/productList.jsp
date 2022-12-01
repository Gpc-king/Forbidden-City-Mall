<%--
  Created by IntelliJ IDEA.
  User: Peng
  Date: 2022/4/24
  Time: 19:35
  To change this template use File | Settings | File Templates.
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page import="com.peng.fcmall.pojo.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>PALACE MALL</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/productList.css">
</head>
<body>
<!-- 页头 -->
<jsp:include page="header.jsp"/>
<!-- 获取内容 -->
<%
    List<Product> productInfos = (List<Product>) session.getAttribute("productInfos");
%>

<!-- 商品 -->
<div class="pro">
    <div class="pro_inner">
        <ul>
            <%
                for (Product pInfo : productInfos) {
            %>
            <a href="${pageContext.request.contextPath}/products/product/<%=pInfo.getPID()%>">
                <li>
                    <div class="pro_card">
                        <div class="pro_card_img">
                            <%
                                String num = String.valueOf(pInfo.getPID());
                                String src = request.getContextPath() + "/static/img/t" + num + ".jpg";
                            %>
                            <img width="250px" height="250px" src=<%=src%> />
                        </div>
                        <div class="pro_card_title">
                            <p><%=pInfo.getPName()%></p>
                        </div>
                        <div class="pro_card_info">
                            <div class="pro_card_price">
                                <p>
                                    ￥<%=pInfo.getPPrice()%>
                                </p>
                            </div>

                            <div class="pro_card_num">
                                <p>
                                    库存：<%=pInfo.getPNum()%>件
                                </p>
                            </div>
                        </div>
                    </div>
                </li>
            </a>
            <%
                }
            %>
        </ul>
    </div>
</div>

<div style="width: auto;"align="center">
    <c:if test="${np > 1}">
        <a href="${pageContext.request.contextPath}/nav/all/1/all" style="display: inline-block">
            <div>[首页]</div>
        </a>
        <c:forEach var="i" begin="1" end="${np}">
            <a href="${pageContext.request.contextPath}/nav/all/${i}/${isWhat}" style="display: inline-block">
                [<c:out value="${i }"/>]
            </a>
        </c:forEach>

        <a href="${pageContext.request.contextPath}/nav/all/${np}/${isWhat}" style="display: inline-block">
            <div>[末页]</div>
        </a>
    </c:if>
</div>

<!-- 底部 -->
<jsp:include page="footer.jsp"/>
<script src="${pageContext.request.contextPath}/static/js/time.js"></script>
</body>
</html>
