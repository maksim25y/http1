<%--
  Created by IntelliJ IDEA.
  User: mudan
  Date: 04.01.2024
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="с" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="header.jsp"%>
    <с:if test="${requestScope.flights.size()>0}">
        <p>YES</p>
    </с:if>
    <div>
        <span>Content. Русский</span>
        <p>${requestScope.flights.size()}</p>
        <p>Id: ${requestScope.flights.get(0).id}</p>
        <p>Map Id: ${sessionScope.flightsMap[1]}</p>
        <p>Cookie Id:${cookie["JSESSIONID"]}</p>
        <p>Header:${header["Cookie"]}</p>
        <p>Param:${param.id}</p
        <p>Param test:${param.test}</p>
    </div>
    <%@include file="footer.jsp"%>
</body>
</html>
