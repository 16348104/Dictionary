<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sign up</title>
    <script src="static/jQuery/jquery-1.11.3.js"/>
    <script>
        $(document).ready(function () {
            $('#username').blur(function () {
                var user = $('#usernme').val();
                $.ajax({
                    url: 'user?action=check',
                    data: {"username": username},
                    dataType: 'json',
                    success: function (result) {
                        if (result.isUsernameExist) {
                            $('#hint').text(" exist!");
                        } else {
                            $('#hint').text(" available!");

                        }
                    }
                });
            });
        });
    </script>
</head>
<body>
<h1>sign up</h1>

<form action="user" method="post">
    <input type="hidden" name="action" value="signup">
    <form action="user/add" method="post">
    userneme: <input  name="username" id="username"><span id="hint"></span><br>
    password: <input type="password" name="password"><br>
    <input type="submit" value="sign up">
</form>
${requestScope.message}
</body>
</html>
