<%--
  Created by IntelliJ IDEA.
  User: zhushengzhe
  Date: 2022/6/12
  Time: 下午2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> <%-- idea识别EL表达式 --%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/accept4" method="post">
    <input type="text" name="userList[0].username"><br>
    <input type="text" name="userList[0].age"><br>
    <input type="text" name="userList[1].username"><br>
    <input type="text" name="userList[1].age"><br>
    <input type="text" name="userList[2].username"><br>
    <input type="text" name="userList[2].age"><br>
    <input type="submit" value="sub"><br>
</form>
</body>
</html>
