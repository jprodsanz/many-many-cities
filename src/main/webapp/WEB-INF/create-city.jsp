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
    <title> Create City  </title>
  <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<%--  <link rel="stylesheet" href="/css/main.css"> --%>
</head>
<body>
<div class="container">
  <div class="row pt-4 mb-4">
    <div class="col-12 d-flex align-items-center justify-content-evenly"></div>
    <h1 class="title">Cities and States</h1>

    <nav class="d-flex justify-content-around pb-2">
      <!-- Add -->
      <a href="/states/create" class="btn btn-outline-primary">Create State</a>
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
      <h1 class="text-center">Create City </h1>
      <h3 class="text-danger"> <c:out value="${error}"/></h3>
      <form:form action="/cities/create" method="POST" modelAttribute="city">
        <!-- Name  input -->
        <div class="mb-3">
          <form:label for="cityName" class="form-label" path="cityName">Name</form:label>
          <form:input style="width:250px;" type="text" class="form-control" id="cityName" aria-describedby="cityName" path="cityName" />
          <form:errors path="cityName" class="text-danger"/>
        </div>
        <!-- Select A State -->
        <div class="mb-3">
          <form:label for="state" class="form-label" path="state">State</form:label>
          <form:errors path="state" class="text-danger"/>
          <form:select style="width:250px;" type="text" class="form-select" id="state" aria-describedby="state" path="state">
            <option disabled selected> --- Select a State --- </option>
            <!-- List of type state from a find all method -->
            <c:forEach var="state" items="${states}">
              <option value="${state.id}">
                <c:out value="${state.stateName}"/>
              </option>
            </c:forEach>
          </form:select>
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
