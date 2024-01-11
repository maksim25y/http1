
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
    <c:choose>
        <c:when test="${not empty requestScope.flights}">
            <h1><fmt:message key="page.flights.list"/>:</h1>
            <ul class="list-group">
                <c:forEach var="flight" items="${requestScope.flights}">
                    <li class="list-group-item mb-1" aria-current="true"><a href="${pageContext.request.contextPath}/tickets?flightId=${flight.id}">${flight.description}</a></li>
                </c:forEach>
            </ul>
<%--            <ul>--%>
<%--&lt;%&ndash;                <c:forEach var="flight" items="${requestScope.flights}">&ndash;%&gt;--%>
<%--&lt;%&ndash;                        <a href="${pageContext.request.contextPath}/tickets?flightId=${flight.id}">${flight.description}</a>&ndash;%&gt;--%>
<%--&lt;%&ndash;                </c:forEach>&ndash;%&gt;--%>
<%--            </ul>--%>
        </c:when>
        <c:otherwise>
            <h1><fmt:message key="page.flights.not"/></h1>
        </c:otherwise>
    </c:choose>
    <form action="${pageContext.request.contextPath}/flights" method="post" enctype="application/x-www-form-urlencoded">
    <div class="form-floating mt-1">
        <input type="text" class="form-control" name="from" id="from" >
        <label for="from">From:</label>
    </div>
    <div class="form-floating mt-1">
        <input type="text" class="form-control" name="to" id="to">
        <label for="to">To:</label>
    </div>
    <button class="btn btn-warning w-100 py-2 mt-2" type="submit"><fmt:message key="page.flights.filter"/> </button>
    </form>
</div>
<%@include file="footer.jsp"%>
</body>
</html>
