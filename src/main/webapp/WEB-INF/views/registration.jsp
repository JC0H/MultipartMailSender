<%--
  Created by IntelliJ IDEA.
  User: jcoh
  Date: 20/04/18
  Time: 05:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h3>registration form</h3>
    <form action="registration" method="post" enctype="multipart/form-data">
        <input type="text" name="username">
        <input type="text" name="password">
        <input type="text" name="email">
        <input type="file" name="file">
        <input type="submit">
        <input type="hidden"
                        name="${_csrf.parameterName}"
                        value="${_csrf.token}">
    </form>
</body>
</html>
