<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Students list</title>
</head>
<body>
<h1>Students List</h1>

<br/><br/>
<div>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Second Name</th>
            <th>Last Name</th>
            <th>Birthday</th>
            <th>Group</th>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.firstName}</td>
                <td>${student.secondName}</td>
                <td>${student.lastName}</td>
                <td>${student.birthday}</td>
                <td>${student.groupID}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>

</html>