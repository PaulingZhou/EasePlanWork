<%@ page import="com.zhou.easeplanwork.meta.Commodity" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2018/2/9
  Time: 下午3:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.getSession().setAttribute("Commodity", request.getAttribute("Commodity")); %>
<html>
<head>
    <title>商品详情</title>
</head>
<body>
<table border="1">
    <tr>
        <th>标题</th>
        <td>${Commodity.title}</td>
    </tr>
    <tr>
        <th>商品id</th>
        <td>${Commodity.uid}</td>
    </tr>
    <tr>
        <th>商品版本id</th>
        <td>${Commodity.version}</td>
    </tr>
    <tr>
        <th>摘要</th>
        <td>${Commodity.summary}</td>
    </tr>
    <tr>
        <th>价格</th>
        <td>${Commodity.price}</td>
    </tr>
    <tr>
        <th>发布时间</th>
        <td>${Commodity.stamp}</td>
    </tr>
    <tr>
        <th>正文</th>
        <td>${Commodity.text}</td>
    </tr>
    <tr>
        <th>图片</th>
        <td><c:if test="${Commodity.picture != null}">has picture!</c:if>
            <c:if test="${Commodity.picture == null}">does not have picture!</c:if></td>
    </tr>
</table>
<div>
    <form action="UpdateCommodity.edit" method="get">
        <input type="submit" name="submit" value="发布">
    </form>
</div>
</body>
</html>
