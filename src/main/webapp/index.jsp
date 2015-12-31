<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>index</title>
    <script>
        function del() {
            return confirm("Are you sure?");
        }
    </script>
</head>
<body>
<h1>index page</h1>
<c:if test="${sessionScope.user ==null}">
    <c:redirect url="/"></c:redirect>
</c:if>
welcome:${sessionScope.user.username}<br>
<a href="/user/logout">退出</a>
<hr>
<form action="/word/queryWordByEnglish" method="post">
    <input type="text" name="english">
    <input type="submit" value="查询">
</form>
<hr>
<%--<table border="0.5">--%>
    <%--<c:choose>--%>
        <%--<c:when test="${sessionScope.words[0] ==null}">--%>
            <%--<c:out value="没有记录"></c:out>--%>
        <%--</c:when>--%>
        <%--<c:otherwise>--%>
            <%--<tr>--%>
                <%--<th>ID</th>--%>
                <%--<th>ENGLISH</th>--%>
                <%--<th>CHINESE</th>--%>
                <%--<th colspan="2">操作</th>--%>
            <%--</tr>--%>
        <%--</c:otherwise>--%>
    <%--</c:choose>--%>
    <%--<c:forEach items="${sessionScope.words} " var="word" varStatus="status">--%>
        <%--<tr>--%>
            <%--<td>${status.count}</td>--%>
            <%--<td>${word.english}</td>--%>
            <%--<td>${word.chinese}</td>--%>
            <%--<td><a href="word?action=search&id=${word.id}">eidt</a></td>--%>
            <%--<td><a href="word?action=delete&id=${word.id}" oncilck="return del()">delete</a></td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
  <%----%>
<%--</table>--%>
</body>
</html>
