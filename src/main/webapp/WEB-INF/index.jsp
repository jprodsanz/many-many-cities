<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!-- Formatting (dates) -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<html>
<head>
    <title> Dashboard </title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<%--  <link rel="stylesheet" href="/css/main.css"> --%>
</head>
<body>
<div class="container">
  <div class="row pt-4 mb-4">
    <div class="col-12 d-flex align-items-center justify-content-evenly"></div>
    <h1 class="title">Welcome to the Dashboard</h1>

    <nav class="d-flex justify-content-around pb-2">
      <!-- Add -->
      <a href="/band/create" class="btn btn-outline-primary">Create Band</a>
      <!-- Dashboard -->
      <a href="/" class="btn btn-outline-primary">Dashboard</a>
      <!-- Logout  -->
      <a href="/user/logout" class="btn btn-outline-danger">Logout</a>
    </nav>
  </div>
</div>
</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<%--<script type="text/javascript" src="/js/app.js"></script>--%>
</html>
