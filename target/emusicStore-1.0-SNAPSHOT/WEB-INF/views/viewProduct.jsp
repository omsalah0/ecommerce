<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="/WEB-INF/views/templates/header.jsp" %>


<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Product Detail</h1>

            <p class="lead">Here is the detail information of the product!</p>
        </div>

        <div class="container" ng-app="cartApp">
            <div class="row">
                <div class="col-md-5">
                    <img src="<c:url value="/resources/images/${product.productID}.png"/>" alt="image"
                         style="width:100%; height: 100%"/>
                </div>

                <div class="col-md-5">
                    <h3>${product.productName}</h3>
                    <p>${product.productDescription}</p>
                    <p>
                        <strong>Manufacturer</strong> : ${product.productManufacturer}
                    </p>
                    <p>
                        <strong>Category</strong> : ${product.productCategory}
                    </p>
                    <p>
                        <strong>Condition</strong> : ${product.productCondition}
                    </p>
                    <h4>${product.productPrice} EGY</h4>
                </div>
                <br>

                <c:set var="role" scope="page" value="${param.role}"/>
                <c:set var="url" scope="page" value="/product/productList"/>


                <p ng-controller="cartCtrl">
                    <a href="<c:url value="${url}" />" class="btn btn-default">Back</a>
                    <br><br><!--add link to cart page -->
                    <a href="" class="btn btn-warning btn-lg"
                       ng-click="addToCart('${product.productID}')"><span
                            class="glyphicon glyphicon-shopping-cart"></span>ADD TO CART
                    </a>
                    <br><br>
                    <a href="<c:url value="/customer/cart" />"
                       class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span>View Cart</a>
                </p>

            </div>
        </div>


        <script src="<c:url value="/resources/js/controller.js"/> "></script>
        <%@include file="/WEB-INF/views/templates/footer.jsp" %>
