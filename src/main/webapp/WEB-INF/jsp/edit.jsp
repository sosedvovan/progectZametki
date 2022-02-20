<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ page import="com.github.sosedvovan.model.Zapis" %>--%>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Edit</title>
</head>
<body>
<section>
    <form method="post" action="zametki" enctype="application/x-www-form-urlencoded">
        <jsp:useBean id="oldZ" type="com.github.sosedvovan.model.Zapis" scope="request"/>
        <input type="hidden" name="actionoutpost" value="edit">
        <h2>Редактирование заметки</h2>
        <br>
        <dl>
            <dt>Номер записи:</dt>
            <dd><input type="text" value="${oldZ.id}" name="id"></dd>
        </dl>
        <dl>
            <dt>Дата-время:</dt>
            <dd><input type="text" value="${oldZ.dateTime}" name="dateTime"></dd>
        </dl>
        <dl>
            <dt>description1:</dt>
            <dd><input type="text" name="description1" size=100 value="${oldZ.description1}"></dd>
        </dl>
        <dl>
            <dt>description2:</dt>
<%--            <dd><input type="text" name="description2" size=100 value="${oldZ.description2}"></dd>--%>
             <dd><textarea name="description2" rows=5 cols=75 ><%=oldZ.getDescription2()%></textarea></dd>
        </dl>

        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()">Отменить</button>


    </form>


</section>
</body>
</html>
