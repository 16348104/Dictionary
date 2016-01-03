<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>word list page</title>
        <script>
            function del() { return confirm('REMOVE?'); }
        </script>
    </head>
    <body>
        <h1>Word List Page</h1>
        <hr/>
        <c:import url="add.jsp"/>
        <hr/>
        <table border="1">
            <tr>
                <th>INDEX</th>
                <th>ID</th>
                <th>ENGLISH</th>
                <th>PHONETICUK</th>
                <th>PHONETICUS</th>
                <th>AUDIOUKMALE</th>
                <th>AUDIOUKFEMALE</th>
                <th>AUDIOUSMALE</th>
                <th>AUDIOUSFEMALE</th>
                <th>EXTENSION</th>
                <th>ETYMOLOGYCN</th>
                <th>LEVEL</th>
                <th colspan="2">OPERATION</th>
            </tr>
            <c:forEach var="word" items="${sessionScope.pagination.list}" varStatus="vs">
            <tr>
                <td>${vs.count}</td>
                <td>${word.id}</td>
                <td>${word.english}</td>
                <td>${word.phoneticUk}</td>
                <td>${word.phoneticUs}</td>
                <td>${word.audioUkMale}</td>
                <td>${word.audioUkFemale}</td>
                <td>${word.audioUsMale}</td>
                <td>${word.audioUsFemale}</td>
                <td>${word.extension}</td>
                <td>${word.etymologyCn}</td>
                <td>${word.level}</td>
                <td><a href="${ctx}/word/search/${word.id}">EDIT</a></td>
                <td><a class="delete" href="${ctx }/word/remove/${word.id}" onclick="return del()">REMOVE</a></td>
            </tr>
            </c:forEach>
        </table>
        <c:import url="${ctx}/commons/page.jsp">
            <c:param name="path" value="word/${sessionScope.pagination.selectId}"/>
        </c:import>
    </body>
</html>