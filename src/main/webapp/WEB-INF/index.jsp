<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task App</title>
<head>
<%@ include file="part/head.jsp" %>
</head>
<body>
<header>
<%@ include file="part/header.jsp" %>
</header>
<div class="container">
<h1 align="center">Task Details</h1>

  <table class="table">
    <thead class="thead-dark">
    <tr>
    <th scope="col">Title</th>
    <th scope="col">Explanation</th>
    <th scope="col">Start Date</th>
    <th scope="col">Due Date</th>
    <th scope="col">Status</th>
    <th colspan="2">Action</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${listTask}" var="task">
  <tr>
    <td>${task.title}</td>
    <td>${task.explanation}</td>
    <td>${task.startDate}</td>
    <td>${task.dueDate}</td>
    <td>${task.status}</td>
    <td><a href="${contextPath}/editTask/${task.id}">Update</a></td>
    <td><a href="${contextPath}/deleteTask/${task.id}">Delete</a></td>
  </tr>
  </c:forEach>
  </tbody>
</table>

</div>
</body>
</html>