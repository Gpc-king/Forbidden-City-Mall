<%--
  Created by IntelliJ IDEA.
  User: Peng
  Date: 2022/4/23
  Time: 22:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>PALACE MALL</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/index.css">
    <script type="text/javascript">
        var number = 1;
        function fun(){
            number++;
            if(number > 8){
                number = 1;
            }
            document.getElementById("banner").src = "/ForbiddenCityMall/static/img/ad"+number+".jpg";
        }
        setInterval(fun, 2000);
    </script>
</head>
<body>

<jsp:include page="./header.jsp"/>
<!-- 广告位 -->
<div class="ad">
    <img src="${pageContext.request.contextPath}/static/img/ad2.jpg" id="banner">
</div>

<!-- 店铺分类 -->
<div class="cate">
    <ul>
        <li><h2>产品分类</h2></li>
        <li>猫主子们:<span>故宫猫主子的周边。</span></li>
        <li>文创用品:<span>故宫文化创新用品。</span></li>
        <li>中国节日:<span>中国传统节日周边。</span></li>
        <li>温馨家具:<span>仿古创新的小家具。</span></li>
        <li>可爱包包:<span>美丽纹饰的小包包。</span></li>
    </ul>
</div>
<!-- 公告 -->
<div class="info">
    <div style=" width:500px;background-color: rgba(255, 255, 255, 0.4); border-radius: 20%;margin: 0 auto;">
    <ul style="list-style: none; color: black" >
        <li></li>
        <li><h2>店铺公告</h2></li>
        <li>紫禁城的小屋 - The Forbidden City Mall</li>
    </ul>
    </div>
</div>
<!-- 底部 -->
<jsp:include page="footer.jsp"/>
<script src="${pageContext.request.contextPath}/static/js/time.js"></script>
</body>
</html>
