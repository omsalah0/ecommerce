<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <style>
        .login-form {
            width: 340px;
            margin: 50px auto;
            font-size: 15px;
        }

        .login-form form {
            margin-bottom: 15px;
            background: #f7f7f7;
            box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
            padding: 30px;
        }

        .login-form h2 {
            margin: 0 0 15px;
        }

        .form-control, .btn {
            min-height: 38px;
            border-radius: 2px;
        }

        .btn {
            font-size: 15px;
            font-weight: bold;
        }

        .error {
            color: red;
        }

        .success {
            color: green;
        }
    </style>
</head>
<body>

<button type="button" class="btn btn-default btn-lg"
        onclick="window.location.href='${pageContext.request.contextPath}/'">
    <span class="fa fa-th-large" aria-hidden="true"></span> Home
</button>

<div class="login-form">
    <form action="${pageContext.request.contextPath}/authenticateUser" method="post">
        <h2 class="text-center">Log in</h2>

        <c:if test="${param.error !=null}">
            <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                Invalid username and password.
            </div>

        </c:if>
        <c:if test="${param.logout !=null}">
            <div class="alert alert-success col-xs-offset-1 col-xs-10">
                You have been logged out.
            </div>
        </c:if>

        <div class="form-group">
            <input type="text" name="username" class="form-control" placeholder="Username" required="required">
        </div>
        <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" required="required">
        </div>
        <div class="form-group">
            <input type="submit" value="Log in" class="btn btn-primary btn-block">
        </div>
        <div class="clearfix">
            <label class="float-left form-check-label"><input type="checkbox"> Remember me</label>
            <a href="#" class="float-right">Forgot Password?</a>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">

    </form>
    <p class="text-center"><a href="${pageContext.request.contextPath}/registration">Create an Account</a></p>
</div>
</body>
</html>