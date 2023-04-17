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
  <title>Login</title>
  <%--    Bootstrap--%>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container pt-4 mb-4">
  <div class="row">
    <div class="col-12 d-flex align-items-center justify-content-evenly">
      <div class="container">
        <h1 class="display-1 text-center" >Sign up </h1>
        <form:form action="/user/register" method="POST" modelAttribute="user">
          <div class="mb-3">
            <form:label for="username" class="form-label" path="username">Username:</form:label>
            <form:input style="width:250px;" type="text" class="form-control" id="username" aria-describedby="username" path="username"/>
            <form:errors path="username" class="text-danger"/>
          </div>
          <div class="mb-3">
            <form:label for="email" class="form-label" path="email">Email:</form:label>
            <form:input style="width:250px;" type="email" class="form-control" id="email" aria-describedby="email" path="email"/>
            <form:errors path="email" class="text-danger"/>
          </div>
          <div class="mb-3">
            <form:label for="password" class="form-label" path="password">Password:</form:label>
            <form:input style="width:250px;" type="password" class="form-control" id="password" aria-describedby="password" path="password"/>
            <form:errors path="password" class="text-danger"/>
          </div>
          <div class="mb-3">
            <form:label for="confirmPass" class="form-label" path="confirmPass"> Confirm Password:</form:label>
            <form:input style="width:250px;" type="password" class="form-control" id="confirmPass" aria-describedby="confirmPass" path="confirmPass"/>
            <form:errors path="confirmPass" class="text-danger"/>
          </div>
          <button type="submit" class="btn btn-outline-primary">Register</button>
        </form:form>
        <div>
          <small class="text-muted ">
            Already have an account?
            <a class="ml-2"href="/user/login">Login</a>
          </small>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</html>