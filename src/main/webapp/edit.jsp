<%--
  Created by IntelliJ IDEA.
  User: xdx
  Date: 2015/12/11
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>edit page</title>

</head>
<body>
<h1>edit page</h1>

<form action="word" method="post">
    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="${sessionScope.word.id}"><br>
    english: <input type="text" name="english" value="${sessionScope.word.english}"><br>
    chinese: <input type="text" name="chinese" value="${sessionScope.word.chinese}"><br>
    <input type="submit" value="UPDATE">
    <br>
</form>
</body>
</html>
