<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Registration</title>
    <%@include file="bootstrap.jsp"%>
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
                    <c:if test="${empty sessionScope.user}">
                        <a href="${pageContext.request.contextPath}/login">
                            <button type="button" class="btn btn-success me-2">
                                <fmt:message key="page.header.login"/>
                            </button>
                        </a>
                    </c:if>
                </li>
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
            <form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">
                <div class="form-floating mt-1">
                    <input type="text" class="form-control" name="name" id="nameId" value="${param.name}" required>
                    <label for="nameId"><fmt:message key="page.registration.name"/>: </label>
                </div>
                <div class="form-floating mt-1">
                    <input type="date" class="form-control" name="birthday" id="birthdayId" required>
                    <label for="birthdayId"><fmt:message key="page.registration.birthday"/>: </label>
                </div>
                <div class="form-floating mt-1">
                    <input type="file" class="form-control" name="image" id="imageId" required>
                    <label for="imageId"><fmt:message key="page.registration.image"/>: </label>
                </div>

                <div class="form-floating mt-1">
                    <input type="text" class="form-control" placeholder="name@example.com" name="email" id="email" value="${param.email}" required>
                    <label for="email"><fmt:message key="page.login.email"/>:</label>
                </div>
                <div class="form-floating mt-1">
                    <input type="password" class="form-control" placeholder="Password" name="password" id="password" required>
                    <label for="password"><fmt:message key="page.login.password"/>:</label>
                </div>
                <div class="form-floating mt-1">
                    <select name="role">
                        <c:forEach var="role" items="${requestScope.roles}">
                            <option value="${role}">${role}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-floating mt-1">
                        <c:forEach var="gender" items="${requestScope.genders}">
                            <input type="radio" name="gender" value="${gender}">${gender}
                            <br>
                        </c:forEach>
                </div>
                <button class="btn btn-primary w-100 py-2 mt-2" type="submit"><fmt:message key="page.registration.send"/> </button>
            </form>
        </main>
    </div>
<%@include file="footer.jsp"%>
</body>
</html>

<%--<form action="${pageContext.request.contextPath}/registration" method="post" enctype="multipart/form-data">--%>
<%--    <label for="nameId">Name:--%>
<%--        <input type="text" name="name" id="nameId">--%>
<%--    </label><br>--%>
<%--    <label for="birthdayId">Birthday:--%>
<%--        <input type="date" name="birthday" id="birthdayId" required>--%>
<%--    </label><br>--%>
<%--    <label for="imageId">Image:--%>
<%--        <input type="file" name="image" id="imageId" required>--%>
<%--    </label><br>--%>
<%--    <label for="emailId">Email:--%>
<%--        <input type="text" name="email" id="emailId">--%>
<%--    </label><br>--%>
<%--    <label for="passwordId">Password:--%>
<%--        <input type="password" name="password" id="passwordId">--%>
<%--    </label><br>--%>
<%--    <select name="role" id="role">--%>
<%--        <c:forEach var="role" items="${requestScope.roles}">--%>
<%--            <option value="${role}">${role}</option>--%>
<%--        </c:forEach>--%>
<%--    </select>--%>
<%--    <br>--%>
<%--    <c:forEach var="gender" items="${requestScope.genders}">--%>
<%--        <input type="radio" name="gender" value="${gender}">${gender}--%>
<%--        <br>--%>
<%--    </c:forEach>--%>
<%--    <button type="submit">Send</button>--%>
<%--    <c:if test="${not empty requestScope.errors}">--%>
<%--        <div style="color: red">--%>
<%--            <c:forEach var="error" items="${requestScope.errors}">--%>
<%--                <span>${error.message}</span>--%>
<%--                <br>--%>
<%--            </c:forEach>--%>
<%--        </div>--%>
<%--    </c:if>--%>
<%--</form>--%>
