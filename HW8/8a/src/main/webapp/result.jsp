<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="del" method="post">
    <table border="1">
        <tr>
            <th>Id #</th>
            <th>Name</th>
            <th>Age</th>
            <th>CB</th>
        </tr>

        <% int i = 0;%>
        <c:set var="i" value="${0}"/>
        <c:forEach items="${users}" var="user">
            <tr>
                <c:set var="i" value="${i+1}"/>
                <td><c:out value="${i}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.age}"/></td>
                <td><input type="checkbox" name="usersID" value="${user.id}"/></td>
            </tr>
        </c:forEach>
</table>

    <br>
    <input type="submit" value="delete"/>
</form>


<br><a href="/">Go to Add</a>

</body>
</html>
