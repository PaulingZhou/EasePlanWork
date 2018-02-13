<%@ page import="com.zhou.easeplanwork.meta.Commodity" %>
<%@ page import="org.springframework.web.multipart.MultipartFile" %>
<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2018/2/9
  Time: 下午4:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //    Commodity commodity = (Commodity) request.getSession().getAttribute("Commodity");
//    request.getSession().setAttribute("Commodity", commodity);
    MultipartFile picture = (MultipartFile) request.getSession().getAttribute("picture");
%>
<html>
<head>
    <title>商品更新</title>
</head>
<body>
<form method="post" action="updateCommodity.modify">
    <div>
        <h1>标题</h1>
        <input type="text" name="title" value="${Commodity.title}">
    </div>
    <div>
        <h2>摘要</h2>
        <input type="text" name="summary" value="${Commodity.summary}">
    </div>
    <div>
        <h2>价格</h2>
        <input type="text" name="price" value="${Commodity.price}">
    </div>
    <div>
        <h2>正文</h2>
        <input type="text" name="text" value="${Commodity.text}">
    </div>
    <div>
        <input type="submit" name="submit" value="提交">
    </div>
</form>
<form action="updateCommodity.updatePicture" method="post" enctype="multipart/form-data">
    <input type="file" name="picture" value="请选择图片"/>
    <p><%= picture == null ? "未选择图片" : "图片已选择: " + picture.getOriginalFilename() %>
    </p>
    <input type="submit" name="sumit" value="上传"/>
</form>
</body>
</html>
