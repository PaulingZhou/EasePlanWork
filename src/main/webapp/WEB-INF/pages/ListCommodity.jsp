<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2018/2/9
  Time: 下午1:37
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品列表</title>
</head>
<body>
<table border="1">
    <tr>
        <th>commodityid</th>
        <th>commodityversion</th>
        <th>title</th>
        <th>summary</th>
        <th>price</th>
        <th>stamp</th>
        <th>user_uid</th>
        <th>ispermanent</th>
    </tr>
    <c:forEach items="${CommodityList}" var="Commodity">
        <tr>
            <td>${Commodity.uid}</td>
            <td>${Commodity.version}</td>
            <td>${Commodity.title}</td>
            <td>${Commodity.summary}</td>
            <td>${Commodity.price}</td>
            <td>${Commodity.stamp}</td>
            <td>${Commodity.user_uid}</td>
            <td>${Commodity.ispermanent}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
