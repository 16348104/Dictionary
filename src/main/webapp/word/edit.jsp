<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>word edit page</title>
    </head>
    <body>
        <h1>Word Edit Page</h1>
        <form action="${ctx}/word/modify" method="post">
            <input type="hidden" name="id" value="${sessionScope.word.id}">
            ENGLISH: <input name="english" value="${sessionScope.word.english}"><br>
            PHONETICUK: <input name="phoneticUk" value="${sessionScope.word.phoneticUk}"><br>
            PHONETICUS: <input name="phoneticUs" value="${sessionScope.word.phoneticUs}"><br>
            AUDIOUKMALE: <input name="audioUkMale" value="${sessionScope.word.audioUkMale}"><br>
            AUDIOUKFEMALE: <input name="audioUkFemale" value="${sessionScope.word.audioUkFemale}"><br>
            AUDIOUSMALE: <input name="audioUsMale" value="${sessionScope.word.audioUsMale}"><br>
            AUDIOUSFEMALE: <input name="audioUsFemale" value="${sessionScope.word.audioUsFemale}"><br>
            EXTENSION: <input name="extension" value="${sessionScope.word.extension}"><br>
            ETYMOLOGYCN: <input name="etymologyCn" value="${sessionScope.word.etymologyCn}"><br>
            LEVEL: <input name="level" value="${sessionScope.word.level}"><br>
            <input type="submit" value="UPDATE">
        </form>
    </body>
</html>