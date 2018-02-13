<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zhou
  Date: 2018/2/13
  Time: 上午11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="mage/jpeg; charset=utf8" language="java" %>
<c:set var="picture" value="${Commodity.picture}"/>
<%
    byte[] picture = (byte[]) pageContext.getAttribute("picture");
    ServletOutputStream sout = response.getOutputStream();
    sout.write(picture);
    sout.flush();
    sout.close();
%>
