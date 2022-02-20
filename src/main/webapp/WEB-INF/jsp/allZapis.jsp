<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Список всех заметок</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
<h3><a href="zametki">Home</a></h3>
<hr/>
<h2>Заметки</h2>
<a href="zametki?action=add"><img src="img/add.png"></a>
<section>

    <br>
    <table border="1" cellpadding="8" cellspacing="0" width="50%">
        <thead>
        <tr>
            <th>ID</th>
            <th>Дата</th>
            <th>Тема</th>
            <th>Заметка</th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <c:forEach items="${allZapis}" var="zapis">
        <jsp:useBean id="zapis" type="com.github.sosedvovan.model.Zapis"/>
        <tr>
            <td>${zapis.id}</td>
            <td>${zapis.dateTime}</td>
            <td>${zapis.description1}</td>
            <td>${zapis.description2}</td>
            <td><a href="zametki?id=${zapis.id}&action=edit"><img src="img/pencil.png"></a></td>
            <td><a href="zametki?id=${zapis.id}&action=delete"><img src="img/pencil.png"></a></td>
        </tr>
        </c:forEach>
    </table>
</section>
</body>
</html>