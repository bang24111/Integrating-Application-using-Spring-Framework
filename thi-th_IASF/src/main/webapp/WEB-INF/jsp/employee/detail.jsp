<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../../../common/admin.jsp" %>
<html xmlns:th="https://www.thymeleaf.org">
<head>
    <title>Product List</title>
</head>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
<body>
<div class="container">
    <div class="container">
        <h2>Employee Detail</h2>
        <hr>

        <dl class="row">
            <dt class="col-sm-3">ID:</dt>
            <dd class="col-sm-9" th:text="${employee.id}"></dd>

            <dt class="col-sm-3">Name:</dt>
            <dd class="col-sm-9" th:text="${employee.name}"></dd>

            <dt class="col-sm-3">Age:</dt>
            <dd class="col-sm-9" th:text="${employee.age}"></dd>

            <dt class="col-sm-3">Salary:</dt>
            <dd class="col-sm-9" th:text="${employee.salary}"></dd>
        </dl>

        <div class="flex-content">
            <a href="/employees" class="btn btn-primary">Back to Employee List</a>
        </div>
    </div>
</div>
</body>
</html>
