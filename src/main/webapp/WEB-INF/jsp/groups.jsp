<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Group list</title>
</head>
<body>
<h1>Group List</h1>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name Of Facultet</th>
            <th>Students</th>

        </tr>
        <c:forEach items="${groups}" var="group">
            <tr>
                <td>${group.id}</td>
                <td>${group.nameOfFacultet}</td>
                <td>${group.studentListToString}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
