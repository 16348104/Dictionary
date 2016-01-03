<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>${model?uncap_first} add page</title>
    </head>
    <body>
        <h1>${model} Add Page</h1>
        <form action="${'$'}{ctx}/${model?lower_case}/add" method="post">
            <#assign keys = properties?keys>
            <#list keys as key>
            ${key?upper_case}: <input name="${key}"><br>
            </#list>
            <input type="submit" value="ADD">
        </form>
    </body>
</html>