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
    <h1 class="title">City Organizations </h1>

    <nav class="d-flex justify-content-around pb-2">
      <!-- Add -->
      <a href="/states/create" class="btn btn-outline-primary">Create State</a>
      <!-- Add -->
      <a href="/cities/create" class="btn btn-outline-primary">Create City</a>
      <!-- Add -->
      <a href="/organizations/create" class="btn btn-outline-primary">Create Organizations</a>
      <!-- Dashboard -->
      <a href="/" class="btn btn-outline-primary">Dashboard</a>
    </nav>
  </div>
</div>
<div class="container">
  <div class="row">
    <div class="col-12">
      <h1>
        <c:out value="${oneCity.cityName}" />
      </h1>
      <p>
        <c:out value="${oneCity.cityName}" /> is in <c:out value="${oneCity.state.stateName}" />
      </p>
      <h2> Organizations</h2>
      <ul class="list-unstyled">
        <c:forEach var="org" items="${oneCity.organizations}">
          <li>
              <c:out value="${oneCity.cityName}"></c:out>
              <c:out value="${org.orgName}"></c:out>
          </li>
        </c:forEach>
      </ul>
      <h2> Citizens </h2>
      <ul class="list-unstyled">
        <c:forEach var="citizen" items="${oneCity.citizens}">
          <li>
              <a href="/person/${citizen.id}">
                <c:out value="${citizen.firstName}"></c:out>
              </a>
          </li>
        </c:forEach>
      </ul>
    </div>
  </div>
</div>
</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<%--<script type="text/javascript" src="/js/app.js"></script>--%>
</html>
