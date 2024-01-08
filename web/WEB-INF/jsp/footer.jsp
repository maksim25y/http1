<%--
  Created by IntelliJ IDEA.
  User: mudan
  Date: 04.01.2024
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!--footer-->
<fmt:setLocale value="${sessionScope.lang!=null?sessionScope.lang:(param.lang!=null?param.lang:'en_US')}"/>
<fmt:setBundle basename="translations"/>
<footer class="py-3 my-4">
    <ul class="nav justify-content-center border-bottom pb-3 mb-3">
        <li class="nav-item">
            <a href="/" class="nav-link px-2 text-body-secondary"><fmt:message key="page.header.home"/> </a>
        </li>
        <li class="nav-item">
            <a href="/" class="nav-link px-2 text-body-secondary"><fmt:message key="page.header.about"/></a>
        </li>
        <li class="nav-item">
            <a href="/" class="nav-link px-2 text-body-secondary">Telegram</a>
        </li>
        <li class="nav-item">
            <a href="#" class="nav-link px-2 text-body-secondary">Instagram</a>
        </li>
    </ul>
    <p class="text-center text-body-secondary">© 2023 Company, Inc</p>
</footer>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
        crossorigin="anonymous"
></script>
</body>
</html>
