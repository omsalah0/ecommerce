<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>


<div class="container-wrapper">
    <div class="container">

        <div class="page-header">
            <h1>All Products</h1>
            <table class="table table-striped table-hover">
                <thead class="thead-dark">
                <tr class="bg-primary">
                    <th>Photo Thumb</th>
                    <th>Product Name</th>
                    <th>Category</th>
                    <th>Condition</th>
                    <th>Price</th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach var="product" items="${products}">
                    <tr>

                        <td><img src="<c:url value="/resources/images/${product.productID}.png"/>"
                                 style="width: 50%" alt="image"></td>
                        <td>${product.productName}</td>
                        <td>${product.productCategory}</td>
                        <td>${product.productCondition}</td>
                        <td>${product.productPrice} LE</td>
                        <td>
                            <a href="<tag:url value="/product/viewProduct/${product.productID}"/>">
                                <span class="glyphicon glyphicon-info-sign"></span>
                            </a>
                        </td>

                    </tr>
                </c:forEach>

            </table>

            <p class="lead">Checkout all the awesome products now!</p>
        </div>


<%@ include file="/WEB-INF/views/templates/footer.jsp" %>