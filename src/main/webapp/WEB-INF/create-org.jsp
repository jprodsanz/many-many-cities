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
    <h1 class="title">Create Org | States & Cities</h1>

    <nav class="d-flex justify-content-around pb-2">
      <!-- Add -->
      <a href="/states/create" class="btn btn-outline-primary">Create State</a>
      <!-- Create City -->
      <a href="/cities//create" class="btn btn-outline-primary">Create City</a>
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
      <h1 class="text-center">Create ORG  </h1>
      <h3 class="text-danger"> <c:out value="${error}"/></h3>
      <form:form action="/organizations/create" method="POST" modelAttribute="organization">
        <!-- Organization Name  input -->
        <div class="mb-3">
          <form:label for="orgName" class="form-label" path="orgName">Org Name </form:label>
          <form:input style="width:250px;" type="text" class="form-control" id="orgName" aria-describedby="orgName" path="orgName" />
          <form:errors path="orgName" class="text-danger"/>
        </div>
        <!-- Select A State -->
        <div class="mb-3">
          <form:label for="city" class="form-label" path="city">City </form:label>
          <form:errors path="city" class="text-danger"/>
          <form:select style="width:250px;" type="text" class="form-select" id="city" aria-describedby="city" path="city">
            <option disabled selected> --- Select a City --- </option>
            <!-- List of type city from a find all method -->
            <c:forEach var="city" items="${cities}">
              <option value="${city.id}">
                <c:out value="${city.cityName}"/>
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
