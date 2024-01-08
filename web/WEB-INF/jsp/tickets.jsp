
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Title</title>
    <%@include file="bootstrap.jsp"%>
</head>
<body>
<div class="container">

</div>
<%@include file="header.jsp"%>
<div class="container">
    <c:if test="${not empty requestScope.tickets}">
        <h1><fmt:message key="page.tickets.purchased"/>:</h1>
        <ul>
            <h2><fmt:message key="page.tickets.count"/>: ${fn:length(tickets)}</h2>
            <c:forEach var="ticket" items="${requestScope.tickets}">
                <li>${ticket.seatNo}</li>
            </c:forEach>
        </ul>
    </c:if>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
