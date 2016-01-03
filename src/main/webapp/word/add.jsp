<!DOCTYPE html><%@ page pageEncoding="UTF-8"%><%@ include file="/commons/inc.jsp"%>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>word add page</title>
    </head>
    <body>
        <h1>Word Add Page</h1>
        <form action="${ctx}/word/add" method="post">
            ENGLISH: <input name="english"><br>
            PHONETICUK: <input name="phoneticUk"><br>
            PHONETICUS: <input name="phoneticUs"><br>
            AUDIOUKMALE: <input name="audioUkMale"><br>
            AUDIOUKFEMALE: <input name="audioUkFemale"><br>
            AUDIOUSMALE: <input name="audioUsMale"><br>
            AUDIOUSFEMALE: <input name="audioUsFemale"><br>
            EXTENSION: <input name="extension"><br>
            ETYMOLOGYCN: <input name="etymologyCn"><br>
            LEVEL: <input name="level"><br>
            <input type="submit" value="ADD">
        </form>
    </body>
</html>