
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="header.jsp"%>
    <c:if test="${not empty requestScope.tickets}">
        <h1>Купленные билеты:</h1>
        <ul>
            <h2>Количество билетов: ${fn:length(tickets)}</h2>
            <c:forEach var="ticket" items="${requestScope.tickets}">
                <li>${ticket.seatNo}</li>
            </c:forEach>
        </ul>
    </c:if>
</body>
</html>
