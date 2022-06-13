<%--
  Created by IntelliJ IDEA.
  User: zhushengzhe
  Date: 2022/6/12
  Time: 下午2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %> <%-- idea识别EL表达式 --%>
<html>
<head>
    <title>Title</title>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <script>
        var userList = new Array()
        userList.push({username:"lisi",age:"12"})
        userList.push({username:"zhangsan",age:"18"})
        $.ajax({
            type:"POST",
            url:"${pageContext.request.contextPath}/accept5",
            data:JSON.stringify(userList),
            contentType:"application/json"
        })
    </script>
</head>
<body>

</body>
</html>
