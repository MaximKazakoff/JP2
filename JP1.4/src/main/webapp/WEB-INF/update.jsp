<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 19.12.2019
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <h1>update.jsp</h1>
</head>
<body>
    <table>
        <form action="${pageContext.request.contextPath}/Update" method="POST">
            <c:if test="${EditType == 'AddStart'}"><input type="hidden" name="EditType" value="AddEnd" /></c:if>
            <c:if test="${EditType == 'UpdateStart'}"><input type="hidden" name="EditType" value="UpdateEnd" /></c:if>
            <input type="hidden" name="id" value=${id} />
            <tr>
                <th>Name</th> <td> <input type="text" name= "name" value= ${name} > </td>
            </tr>
            <tr>
                <th>Password</th> <td> <input type="text" name= "password" value= ${password} > </td>
            </tr>
            <tr>
                <th>Money</th> <td> <input type="text" name= "money" value= ${money} > </td>
            </tr>
            <tr>
                <td colspan="2">  <input type="submit" value="Action" /> </td>
            </tr>
        </form>
    </table>
</body>
</html>
