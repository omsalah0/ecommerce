<%@ include file="/WEB-INF/views/templates/header.jsp" %>


<div class="container">
    <section>
        <div class="jumbotron">
            <div class="container">
                <h1>Shopping cart</h1>
            </div>
            <p>Check All Products that you add it</p>
        </div>
    </section>
    <div class="row" ng-app="cartApp">
        <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">
            <div class="col-sm-12 col-md-10 col-md-offset-1">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Product</th>
                        <th>Quantity</th>
                        <th class="text-center">Price</th>
                        <th class="text-center">Total</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody ng-repeat="item in cart.cartItems">
                    <tr>
                        <td class="col-sm-8 col-md-6">
                            <div class="media">
                                <a class="thumbnail pull-left text-center" href="#"> <img class="media-object"
                                                                                          src="<c:url value="/resources/images/{{item.product.productID}}.png"/>"
                                                                                          style="width: 72px; height: 72px;"
                                                                                          alt="img">
                                </a>
                                <div class="media-body">
                                    <h4 class="media-heading"><a href="#">{{item.product.productName}}</a></h4>
                                    <h5 class="media-heading"> by <a href="#">{{item.product.productManufacturer}}</a>
                                    </h5>
                                    <span>Status: </span><span class="text-success"><strong>In Stock</strong></span>
                                </div>
                            </div>
                        </td>
                        <td class="col-sm-1 col-md-1" style="text-align: center">
                            <input type="text" class="form-control" value="{{item.quantity}}">
                        </td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>{{item.product.productPrice}} LE</strong></td>
                        <td class="col-sm-1 col-md-1 text-center"><strong>{{item.totalPrice}} LE</strong></td>
                        <td class="col-sm-1 col-md-1">
                            <a class="btn btn-danger" href=""
                               ng-click="removeFromCart(item.product.productID)">
                                <span class="glyphicon glyphicon-remove"></span> Remove
                            </a>
                        </td>
                    </tr>
                    </tbody>
                </table>
                <h3 class="text-right">Total</h3>
                <h3 class="text-right"><strong>{{calGrandTotal()}} LE</strong></h3>
                <a class=" btn btn-default " href="<c:url value="/product/productList"/>">
                    <span class="glyphicon glyphicon-shopping-cart"></span> Continue Shopping
                </a>

                <a class="btn btn-success">
                    Checkout <span class="glyphicon glyphicon-play text-right"></span>
                </a>
            </div>
        </div>
    </div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
<script src="<c:url value="/resources/js/controller.js"/> "></script>
<%@ include file="/WEB-INF/views/templates/footer.jsp" %>