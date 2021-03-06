<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1,shrink-to-fit=no">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/carousel/">

    <link rel="canonical" href="https://getbootstrap.com/docs/4.5/examples/sticky-footer/">

    <title>E Music Shop</title>

    <!-- angular -->
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.min.css"/>" rel="stylesheet">

    <link href="<c:url value="/resources/css/main.css"/>" rel="stylesheet">


</head>
<!-- NAVBAR
================================================== -->
<body class="d-flex flex-column h-100">
<div class="navbar-wrapper">
    <div class="container">

        <nav class="navbar navbar-inverse navbar-static-top">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar"
                            aria-expanded="false" aria-controls="navbar">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="<c:url value="/"/>">Music Store</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="<c:url value="/product/productList" />">Products</a></li>
                        <li><a href="#">About</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                    <ul class="nav navbar-nav pull-right">
                        <security:authorize access="hasRole('ADMIN')">
                            <li class="text-right"><a href="<c:url value="/admin"/> ">Admin</a></li>
                        </security:authorize>

                        <security:authorize access="!hasRole('CUSTOMER')">
                            <li class="text-right"><a href="<c:url value="/registration"/> ">Register</a></li>
                            <li class="text-right"><a href="<c:url value="/loginPage"/> ">Login</a></li>
                        </security:authorize>
                        <security:authorize
                                access="hasRole('CUSTOMER')"> <!-- we can use instead jstl with pageContext.request.userPrincipal -->


                            <li class="text-right">Welcome <b>${pageContext.request.userPrincipal.name}</b></li>
                            <li class="text-right"><a href="${pageContext.request.contextPath}/customer/cart">My
                                Cart</a></li>
                            <li class="text-right">
                                <form:form method="post" action="${pageContext.request.contextPath}/logout">
                                    <input type="submit" value="Logout" class="btn btn-primary mb-2">
                                </form:form>
                                <!-- Add Cart button -->
                            </li>
                        </security:authorize>


                    </ul>
                </div>
            </div>
        </nav>

    </div>
</div>

