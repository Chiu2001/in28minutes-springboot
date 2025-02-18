<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="BIG5">
<link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
<title>List Todos Page</title>
</head>
<body>
	<div class="container">
	    <h1>Your Todos are:</h1>
	    <table class="table">
	        <thead>
	            <tr>
	                <th>Id</th>
	                <th>Username</th>
	                <th>Description</th>
	                <th>Target Date</th>
	                <th>Is Done?</th>
	            </tr>
	        </thead>
	        <tbody>
	            <c:forEach var="todo" items="${todos}">
	                <tr>
	                    <td>${todo.id}</td>
	                    <td>${todo.username}</td>
	                    <td>${todo.description}</td>
	                    <td>${todo.targetDate}</td>
	                    <td>${todo.done}</td>
	                    <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">DELETE</a></td>
	                </tr>
	            </c:forEach>
	        </tbody>
	    </table>
	    <a href="add-todo" class="btn btn-success">Add Todo</a>
    </div>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
	<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>
