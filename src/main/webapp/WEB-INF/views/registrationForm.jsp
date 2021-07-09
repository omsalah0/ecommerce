<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">

    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
          integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ" crossorigin="anonymous">

    <title>Sign Up</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        body {
            color: #fff;
            background: #f8f1ed;
            font-family: 'Roboto', sans-serif;
        }

        .form-control {
            height: 40px;
            box-shadow: none;
            color: #969fa4;
        }

        .form-control:focus {
            border-color: #5cb85c;
        }

        .form-control, .btn {
            border-radius: 3px;
        }

        .signup-form {
            width: 450px;
            margin: 0 auto;
            padding: 30px 0;
            font-size: 15px;
        }

        .error {
            color: red;
        }

        .signup-form h2 {
            color: #636363;
            margin: 0 0 15px;
            position: relative;
            text-align: center;
        }

        .signup-form h2:before, .signup-form h2:after {
            content: "";
            height: 2px;
            width: 30%;
            background: #d4d4d4;
            position: absolute;
            top: 50%;
            z-index: 2;
        }

        .signup-form h2:before {
            left: 0;
        }

        .signup-form h2:after {
            right: 0;
        }

        .signup-form .hint-text {
            color: #999;
            margin-bottom: 30px;
            text-align: center;
        }

        .signup-form form {
            color: #999;
            border-radius: 3px;
            margin-bottom: 15px;
            background: #f2f3f7;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }

        .signup-form .form-group {
            margin-bottom: 20px;
        }

        .signup-form input[type="checkbox"] {
            margin-top: 3px;
        }

        .signup-form .btn {
            font-size: 16px;
            font-weight: bold;
            min-width: 140px;
            outline: none !important;
        }

        .signup-form .row div:first-child {
            padding-right: 10px;
        }

        .signup-form .row div:last-child {
            padding-left: 10px;
        }

        .signup-form a {
            color: #fff;
            text-decoration: underline;
        }

        .signup-form a:hover {
            text-decoration: none;
        }

        .signup-form form a {
            color: #5cb85c;
            text-decoration: none;
        }

        .signup-form form a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
<button type="button" class="btn btn-default btn-lg"
        onclick="window.location.href='${pageContext.request.contextPath}/'">
    <span class="fa fa-th-large" aria-hidden="true"></span> Home
</button>
<div class="signup-form">
    <form:form action="${pageContext.request.contextPath}/registration" method="post" modelAttribute="customer">
        <h2>Register</h2>
        <p class="hint-text">Create your account. It's free and only takes a minute.</p>
        <div class="form-group">
            <form:input type="text" class="form-control" name="first_name" placeholder="Full Name" required="required"
                        path="customerName"/>
        </div>

        <div class="form-group">
            <form:input type="email" class="form-control" name="email" placeholder="Email" required="required"
                        path="email"/>
            <c:if test="${message!=null}">
                <p class="error">${message}</p>
            </c:if>

        </div>

        <div class="form-group">
            <form:input type="password" class="form-control" name="password" placeholder="Password" required="required"
                        path="password"/>


        </div>

        <div class="form-group">
            <form:input type="password" class="form-control" name="confirmPassword" placeholder="Confirm Password"
                        required="required"
                        path="confirmPassword"/>
            <c:if test="${passwordNotMatch!=null}">
                <p class="error">${passwordNotMatch}</p>
            </c:if>
        </div>

        <div class="form-group">
            <form:input type="number" class="form-control" name="phonenumber" placeholder="phone Number"
                        required="required" path="numberOfPhone"/>
        </div>

        <div class="form-group">
            <form:input type="text" class="form-control" name="username" placeholder="Username" required="required"
                        path="username"/>
            <c:if test="${message!=null}">
                <p class="error">${message}</p>
            </c:if>
        </div>

        <h3>Billing Address</h3>

        <div class="form-group">
            <form:input type="text" class="form-control" name="streetName" placeholder="Street Name"
                        path="billingAddress.streetName"/>
        </div>

        <div class="form-group">
            <form:input type="text" class="form-control" name="apartmentNumber" placeholder="Apartment Number"
                        path="billingAddress.apartmentNumber"/>
        </div>

        <div class="form-group">
            <form:input type="text" class="form-control" name="country" placeholder="Country"
                        path="billingAddress.country"/>
        </div>


        <div class="form-group">
            <form:input type="text" class="form-control" name="city" placeholder="City"
                        path="billingAddress.city"/>
        </div>


        <div class="form-group">
            <form:input type="text" class="form-control" name="state" placeholder="State"
                        path="billingAddress.state"/>
        </div>


        <div class="form-group">
            <form:input type="text" class="form-control" name="zipCode" placeholder="zipCode"
                        path="billingAddress.zipCode"/>
        </div>

        <h3>Shopping Address</h3>

        <div class="form-group">
            <form:input type="text" class="form-control" name="streetName" placeholder="Street Name"
                        path="shoppingAddress.streetName"/>
        </div>

        <div class="form-group">
            <form:input type="text" class="form-control" name="apartmentNumber" placeholder="Apartment Number"
                        path="shoppingAddress.apartmentNumber"/>
        </div>

        <div class="form-group">
            <form:input type="text" class="form-control" name="country" placeholder="Country"
                        path="shoppingAddress.country"/>
        </div>


        <div class="form-group">
            <form:input type="text" class="form-control" name="city" placeholder="City"
                        path="shoppingAddress.city"/>
        </div>


        <div class="form-group">
            <form:input type="text" class="form-control" name="state" placeholder="State"
                        path="shoppingAddress.state"/>
        </div>


        <div class="form-group">
            <form:input type="text" class="form-control" name="zipCode" placeholder="zipCode"
                        path="shoppingAddress.zipCode"/>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block">Register Now</button>
        </div>
    </form:form>
    <div class="text-center">Already have an account? <a href="${pageContext.request.contextPath}/loginPage">Sign in</a>
    </div>
</div>
</body>
</html>