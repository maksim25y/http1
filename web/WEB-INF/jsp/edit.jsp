<%--
  Created by IntelliJ IDEA.
  User: mudan
  Date: 09.01.2024
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Edit</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
    />
</head>
<body>
<fmt:setLocale value="${sessionScope.lang!=null?sessionScope.lang:(param.lang!=null?param.lang:'en_US')}"/>
<fmt:setBundle basename="translations"/>
<header class="p-3 text-bg-dark">
    <div class="container">
        <div
                class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start"
        >
            <a
                    href="/"
                    class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none"
            >
                <svg
                        class="bi me-2"
                        width="40"
                        height="32"
                        role="img"
                        aria-label="Bootstrap"
                >
                    <use xlink:href="#bootstrap"></use>
                </svg>
            </a>

            <ul
                    class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0"
            >
                <li><a href="/" class="nav-link px-2 text-secondary"><fmt:message key="page.header.home"/></a></li>
                <c:if test="${not empty sessionScope.user}">
                    <li><a href="${pageContext.request.contextPath}/flights" class="nav-link px-2 text-white"><fmt:message key="page.header.tickets"/></a></li>
                </c:if>
                <li><a href="${pageContext.request.contextPath}/about" class="nav-link px-2 text-white"><fmt:message key="page.header.about"/></a></li>
                <li>
                    <c:if test="${not empty sessionScope.user}">
                        <a href="${pageContext.request.contextPath}/logout">
                            <button type="button" class="btn btn-danger me-2">
                                <fmt:message key="page.header.logout"/>
                            </button>
                        </a>
                    </c:if>
                </li>
            </ul>

            <div class="text-end">
                <form action="${pageContext.request.contextPath}/locale" method="post">
                    <button class="btn btn-primary me-2" type="submit" name="lang" value="ru_RU">RU</button>
                    <button class="btn btn-primary me-2" type="submit" name="lang" value="en_US">EN</button>
                </form>
            </div>
        </div>
    </div>
</header>

<div class="container">
    <main class="form-signin w-50 p-3 m-auto">
        <form action="${pageContext.request.contextPath}/edit" method="post" enctype="application/x-www-form-urlencoded">
            <div class="form-floating mt-1">
                <input type="password" class="form-control" name="newPassword" id="newPassword" required>
                <label for="newPassword"><fmt:message key="page.edit.new"/>:</label>
            </div>
            <button class="btn btn-primary w-100 py-2 mt-2"><fmt:message key="page.header.edit"/> </button>
        </form>
    </main>
</div>

</body>
</html>
