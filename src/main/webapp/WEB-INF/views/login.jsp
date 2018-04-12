<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Books</h1>
            <p>Add book</p>
        </div>
    </div>
</section>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        Please sign in
                    </h3>
                </div>
                <div class="panel-body">
                    <c:if test="${not empty error}">
                        <div class="alert alert-danger">
                            <spring:message code="AbstractUserDetailsAuthenticationProvider.badCredentials"/>
                            <br>
                        </div>
                    </c:if>

                    <form action="<c:url value="/j_spring_security_check"/>" method="post">

                        <fieldset>
                            <div class="form-group">
                                <input type="text" class="form-control" placeholder="User Name" name="j_username">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" placeholder="Password" name="j_password"
                                       value="">
                            </div>
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="Login">
                        </fieldset>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
