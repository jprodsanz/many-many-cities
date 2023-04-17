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
    <h1 class="title">States and Cities </h1>

    <nav class="d-flex justify-content-around pb-2">
      <!-- Add -->
      <a href="/states/create" class="btn btn-outline-primary">Create State</a>
      <!-- Add -->
      <a href="/cities/create" class="btn btn-outline-primary">Create City</a>
      <!-- Dashboard -->
      <a href="/organizations/create" class="btn btn-outline-primary">Create an Organization</a>
      <!-- Dashboard -->
      <a href="/person/create" class="btn btn-outline-primary">Create a Person</a>
    </nav>
  </div>
</div>
<div class="container">
  <div class="row">
    <h3>
      Hello, <c:out value="${user.username}" />
    </h3>
    <div class="col-12 d-flex align-items-baseline justify-content-evenly">
      <table class="table table-striped table-bordered text-center">
        <thead class="table-dark">
        <tr>

          <th scope="col">State Name </th>
          <th scope="col">Abbreviation</th>
          <th scope="col">Actions</th>

        </tr>
        </thead>
        <tbody>
          <c:forEach var="state" items="${states}">
          <tr>
            <td>
             <h3>
               <c:out value="${state.stateName}"/>
             </h3>
              <ul class="list-unstyled">
                <c:forEach var="city" items="${state.cities}">
                  <li>
                    <a href="/cities/${city.id}/view">
                      <c:out value="${city.cityName}"></c:out>
                    </a>

                  </li>
                </c:forEach>
              </ul>
            </td>
            <td>
             <c:out value="${state.abbreviation}"/>
            </td>
            <td>
              <a href="/states/delete/${state.id}" class="btn btn-outline-danger">Delete</a>
            </td>

          </tr>
        </c:forEach>
        </tbody>
      </table>
    </div>
  </div>
</div>
</body>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<%--<script type="text/javascript" src="/js/app.js"></script>--%>
</html>
