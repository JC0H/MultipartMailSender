<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: jcoh
  Date: 20/04/18
  Time: 07:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User List</title>
</head>
<body>
    <h3>User List Page</h3>
    <c:forEach var="user" items="${userList}">
        <p><a href="user${user.id}">${user.username}</a></p>
    </c:forEach>
</body>
</html>
