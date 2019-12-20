<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.12.2019
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <h1>userTable.jsp</h1>
</head>
<body>
    <div margin-left="auto" margin-right="auto">
        <form action="${pageContext.request.contextPath}/Update" method="POST">
            <input type="hidden" value="AddStart" name="EditType"/>
            <input type="submit" value="Add User">
        </form>
    </div>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Password</th>
            <th>Money</th>
            <th>Update user</th>
            <th>Delete user</th>
        </tr>
        <jsp:useBean id="lists" scope="request" type="java.util.List"/>
        <c:forEach var="user" items="${lists}">
            <tr>
                <td>${user.getId()}</td>
                <td>${user.getName()}</td>
                <td>${user.getPassword()}</td>
                <td>${user.getMoney()}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/Update" method="POST">
                        <input type="hidden" value="${user.getId()}" name="id"/>
                        <input type="hidden" value="${user.getName()}" name="name"/>
                        <input type="hidden" value="${user.getPassword()}" name="password"/>
                        <input type="hidden" value="${user.getMoney()}" name="money"/>
                        <input type="hidden" value="UpdateStart" name="EditType"/>
                        <input type="submit" value="Update">
                    </form>
                </td>

                <td>
                    <form action="${pageContext.request.contextPath}/Update" method="POST">
                        <input type="hidden" value="${user.getId()}" name="id"/>
                        <input type="hidden" value="${user.getName()}" name="name"/>
                        <input type="hidden" value="${user.getPassword()}" name="password"/>
                        <input type="hidden" value="${user.getMoney()}" name="money"/>
                        <input type="hidden" value="Delete" name="EditType"/>
                        <input type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
