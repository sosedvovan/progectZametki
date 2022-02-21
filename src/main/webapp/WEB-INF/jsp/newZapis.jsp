<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.github.sosedvovan.model.Zapis" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%--<jsp:useBean id="zapis" type="com.github.sosedvovan.model.Zapis" scope="request"/>--%>
    <title>Add</title>
</head>
<body>
<section>
    <h2>Добавление новой заметки</h2>
    <form method="post" action="zametki" enctype="application/x-www-form-urlencoded">
        <jsp:useBean id="emptyZapis" type="com.github.sosedvovan.model.Zapis" scope="request"/>
        <input type="hidden" name="actionoutpost" value="add">
<%--        <dl>--%>
<%--            <dt>Номер записи:</dt>--%>
<%--            <dd><input type="text" value="${emptyZapis.id}" name="id"></dd>--%>
<%--        </dl>--%>
        <input type="hidden" value="${emptyZapis.id}" name="id">
        <dl>
            <dt>Дата-время:</dt>
            <dd><input type="text" value="${emptyZapis.dateTime}" name="dateTime"></dd>
        </dl>
        <dl>
            <dt>description1:</dt>
            <dd><input type="text" name="description1" size=100 value="${emptyZapis.description1}"></dd>
        </dl>
        <dl>
            <dt>description2:</dt>
<%--            <dd><input type="text" name="description2" size=100 value="${emptyZapis.description2}"></dd>--%>
             <dd><textarea name="description2" rows=5 cols=75 value="${emptyZapis.description2}"></textarea></dd>
        </dl>

        <button type="submit">Сохранить</button>
        <button onclick="window.history.back()">Отменить</button>

    </form>
</section>
</body>
</html>