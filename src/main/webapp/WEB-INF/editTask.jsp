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
    <title>Edit Task</title>
</head>
<body>
<header>
    <%@ include file="part/header.jsp" %>
</header>
<div class="container">
    <h1 align="center"> Edit - ${task.title} </h1>
    <form action="${contextPath}/updateTask" name="user" method="POST">
        <input type="hidden" value="${task.id}" id="id" name="id">
        <div class="form-group">
            <label for="title" class="mb-2 mr-sm-2">Title:</label>
            <input type="text" class="form-control" id="title" placeholder="Title" name="title" value="${task.title}">
        </div>
        <div class="form-group">
            <label for="explanation" class="mb-2 mr-sm-2">Explanation:</label>
            <input type="text" class="form-control" id="explanation" placeholder="Explanation" name="explanation"
                   value="${task.explanation}">
        </div>
        <div class="form-group">
            <label for="dueDate" class="mb-2 mr-sm-2">Due date:</label>
            <input type="date" class="form-control" id="dueDate" placeholder="Due date" name="dueDate"
                   value="${task.dueDate}">
        </div>

        <div class="form-group">
            <label for="status" class="cols-sm-2 control-label">Status</label>
            <select name="status" class="custom-select" id="status">
                <option>NOT_STARTED</option>
                <option>STARTED</option>
                <option>FINISHED</option>
            </select>
        </div>

        <br/>
        <button type="submit" class="btn btn-primary mb-2">Submit</button>

    </form>
</div>
</body>
</html>