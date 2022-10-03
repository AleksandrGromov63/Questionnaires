<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Главная</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <%--
        <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
    --%>
</head>
<body>
<div>
    <h3>${pageContext.request.userPrincipal.name}</h3>
    <sec:authorize access="!isAuthenticated()">
        <h4><a href="/login">Войти</a></h4>
        <h4><a href="/registration">Зарегистрироваться</a></h4>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <h4><a href="/logout" style="color: orangered">Выйти</a></h4>
    </sec:authorize>
    <sec:authorize access="hasRole('USER')">
        <h4><a href="/user/questionnaires">Пройти опрос</a></h4>
    </sec:authorize>
    <sec:authorize access="hasRole('ADMIN')">
        <h4><a href="/admin/constructor">Создать анкету</a></h4>
        <h4><a href="/admin/questionnaires">Редактировать анкету</a></h4>
        <h4><a href="/admin/questionnaires">Пройти опрос</a></h4>
        <h4><a href="/admin/allUsers">Ответы пользователей</a></h4>
    </sec:authorize>
</div>
</body>
</html>
