
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Flights</title>
    <%@include file="bootstrap.jsp"%>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <c:if test="${not empty requestScope.flights}">
        <h1><fmt:message key="page.flights.list"/>:</h1>
        <ul>
            <c:forEach var="flight" items="${requestScope.flights}">
                <li>
                    <a href="${pageContext.request.contextPath}/tickets?flightId=${flight.id}">${flight.description}</a>
                </li>
            </c:forEach>
        </ul>
    </c:if>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
