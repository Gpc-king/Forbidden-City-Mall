<%@ page import="com.peng.fcmall.pojo.Product" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>PALACE MALL</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/productDetail.css">
</head>
<body>
<!-- 页头 -->
<jsp:include page="header.jsp"/>
<!-- 商品详情 -->
<%
    Product p = (Product)request.getAttribute("product");
%>
<div class="container">
    <div class="card">
        <div class="pro_img">
            <%
                String num = String.valueOf(p.getPID());
                String src = request.getContextPath() + "/static/img/t" + num + ".jpg";
            %>
            <img src=<%=src%> width="250px" />
        </div>
        <div class="pro_detail">
            <div class="pro_detail_h3">
                <h3><%=p.getPName() %></h3>
            </div>
            <div class="pro_detail_p">
                <p><%=p.getPDetail() %></p>
            </div>
            <div class="pro_detail_price">
                ￥
                <p><%=p.getPPrice() %></p>
            </div>
            <div class="pro_detail_num">
                <p>
                    库存:<%=p.getPNum() %></p>
            </div>
            <div class="pro_detail_buy">
                <form action="${pageContext.request.contextPath}/products/buy" method="post">
                    <input type="number" name="num" min="0" value="1" class="bt" />
                    <input type="text" name="id" value="<%=p.getPID() %>" hidden="hidden">
                    <input type="submit" value="购买" class="bs">
                </form>
                <p>速来~</p>
            </div>
        </div>
    </div>
</div>
<!-- 其他 -->
<div class="pro_others">
    <ul>
        <li>服务承诺：</li>
        <li>正品保证</li>
        <li>极速退款</li>
        <li>退货运费险</li>
        <li>七天无理由</li>
    </ul>
</div>
<!-- 底部 -->
<jsp:include page="footer.jsp"/>
<script src="${pageContext.request.contextPath}/static/js/time.js"></script>
</body>
</html>
