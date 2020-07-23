<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html>
<head>
    <%@ include file="part/head.jsp" %>
    <meta charset="ISO-8859-1">
    <title>Task Forms</title>
    <style>
        .error{
            color : red;
        }
    </style>
</head>
<body>
<header>
    <%@ include file="part/header.jsp" %>
</header>

<div class="container">
    <h1 align="center">New Task</h1>

    <form:form action="/saveTask"  method="POST" modelAttribute="task">
        <div class="form-group">
            <label for="title">Title:</label>
            <form:input placeholder="Title" class="form-control" path="title"/>
            <form:errors path="title" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="explanation">Explanation:</label>
            <form:input  placeholder="Explanation" class="form-control" path="explanation"/>
            <form:errors path="explanation" cssClass="error"/>
        </div>

        <div class="form-group">
            <label for="dueDate">Due date:</label>
            <form:input type="date" placeholder="Due date" class="form-control" path="dueDate"/>
            <form:errors path="dueDate" cssClass="error"/>
        </div>
        <br/>
        <button type="submit" class="btn btn-primary mb-2">Submit</button>
    </form:form>
</div>

</body>
</html>