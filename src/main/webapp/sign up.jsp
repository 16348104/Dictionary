<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sign up</title>
    <script src="static/jQuery/jquery-1.11.3.js"/>
    <script>

        $(document).ready(function () {
            $('#username').blur(function () {
                var user=$('#usernme').val();
                $.ajax({
                    url: 'user?action=check',
                    date: {"username": username}
                });
            });
        });
    </script>
</head>
<body>
<h1>sign up</h1>

<form action="user" method="post">
    <input type="hidden" name="action" value="signup">
    userneme: <input type="text" name="username" id="username"><br>
    password: <input type="password" name="password"><br>
    <input type="submit" value="sign up">
</form>
</body>
</html>
