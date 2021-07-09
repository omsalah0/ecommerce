<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tag" uri="http://www.springframework.org/tags" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>


<div class="container-wrapper">
    <div class="container">

        <div class="page-header">
            <h1>Product Inventory Page</h1>
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

                        <td><img src="<c:url value="/resources/images/${product.productID}.png"/>" style="width: 50%"
                                 alt="image"></td>
                        <td>${product.productName}</td>
                        <td>${product.productCategory}</td>
                        <td>${product.productCondition}</td>
                        <td>${product.productPrice} LE</td>
                        <td>
                            <a href="<tag:url value="/productList/viewProduct/${product.productID}"/>">
                                <span class="glyphicon glyphicon-info-sign"></span>
                            </a>&#8287;&#8287;
                            <a href="<tag:url value="/admin/productInventory/delete/${product.productID}"/>"
                               onclick="if (!(confirm('Are you sure you want to delete this Product?'))) return false">
                                <span class="glyphicon glyphicon-trash"></span>
                            </a>&#8287;&#8287;
                            <a href="<tag:url value="/admin/update/updateProduct/${product.productID}"/>">
                                <span class="glyphicon glyphicon-pencil"></span>
                            </a>

                        </td>

                    </tr>
                </c:forEach>

            </table>
            <a href="<c:url value="/admin/productInventory/addProduct"/>" class="btn btn-primary btn-lg">Add Product</a>
        </div>


<%@ include file="/WEB-INF/views/templates/footer.jsp" %>