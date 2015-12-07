<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>default</title>
</head>
<body>
<h1>default page</h1>
<form action="user" method="post">
    <input type="hidden" name="action" value="login">
    username: <input name="username"><br/>
    password: <input name="password" type="password"><br/>
    <input type="submit" value="LOGIN">
</form>
</body>
</html>
