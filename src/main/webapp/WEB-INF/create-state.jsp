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
    <h1 class="title">State and Cities</h1>

    <nav class="d-flex justify-content-around pb-2">
      <!-- Add -->
      <a href="/cities/create" class="btn btn-outline-primary">Create City</a>
      <!-- Dashboard -->
      <a href="/" class="btn btn-outline-primary">Dashboard</a>
      <!-- Logout  -->
      <a href="/user/logout" class="btn btn-outline-danger">Logout</a>
    </nav>
  </div>
</div>
<div class="container">
  <div class="row">
    <div class="col-12">
      <h1 class="text-center">Create State </h1>
      <h3 class="text-danger"> <c:out value="${error}"/></h3>
      <form:form action="/states/create" method="POST" modelAttribute="state">
        <!-- Name  input -->
        <div class="mb-3">
          <form:label for="stateName" class="form-label" path="stateName">Name</form:label>
          <form:input style="width:250px;" type="text" class="form-control" id="stateName" aria-describedby="stateName" path="stateName" />
          <form:errors path="stateName" class="text-danger"/>
        </div>
        <!-- Abbreviation  input -->
        <div class="mb-3">
          <form:label for="abbreviation" class="form-label" path="abbreviation">Abbreviation</form:label>
          <form:input style="width:250px;" type="text" class="form-control" id="abbreviation" aria-describedby="abbreviation" path="abbreviation" />
          <form:errors path="abbreviation" class="text-danger"/>
        </div>
        <!-- Submit button -->
        <button type="submit" class="btn btn-outline-success">Add</button>
      </form:form>
    </div>
  </div>
</div>
</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<%--<script type="text/javascript" src="/js/app.js"></script>--%>
</html>
