<%--
  Created by IntelliJ IDEA.
  User: zhushengzhe
  Date: 2022/6/10
  Time: 上午8:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> <%-- idea识别EL表达式 --%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/upload1" method="post" enctype="multipart/form-data">
    名称：<input type="text" name="username"><br>
    文件：<input type="file" name="uploadFile"><br>
    <input type="submit" value="sub ">

</form>

</body>
</html>
