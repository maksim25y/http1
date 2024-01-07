
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/login" method="post" enctype="multipart/form-data">
        <label for="emailId">Email:
            <input type="text" name="email" id="emailId" required>
        </label>
        <br>
        <label for="passwordId">Password:
            <input type="password" name="password" id="passwordId" required>
        </label><br>
        <button type="submit">Login</button>
        <a href="${pageContext.request.contextPath}/registration">
            <button type="button">Register</button>
        </a>
    </form>
</body>
</html>
