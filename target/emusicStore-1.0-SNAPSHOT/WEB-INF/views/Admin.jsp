<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>


<div class="container-wrapper">
    <div class="container">

        <div class="page-header">
            <h1>Administrator Page</h1>


            <p class="lead">You are in Administrator page you can modify products</p>
        </div>
        <h2>
            Welcome
            <security:authentication property="principal.username"/>

        </h2>

        <h3>
            <a href="<c:url value="/admin/productInventory"/> ">Product Inventory</a>
        </h3>


<%@ include file="/WEB-INF/views/templates/footer.jsp" %>