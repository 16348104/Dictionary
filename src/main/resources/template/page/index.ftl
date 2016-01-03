<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>${model?uncap_first} index page</title>
    </head>
    <body>
        <h1>${model} Index Page</h1>
        <p><a href="${'$'}{ctx}/${model?lower_case}/add.jsp">ADD</a></p>
        <p><a href="${'$'}{ctx}/${model?lower_case}/list">LIST</a></p>
    </body>
</html>