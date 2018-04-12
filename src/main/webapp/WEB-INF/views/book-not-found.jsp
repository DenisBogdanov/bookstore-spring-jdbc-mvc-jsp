<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>404 | Book not found</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1 class="alert alert-danger">There is no book with id ${invalidBookId}</h1>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <p>${url}</p>
        <p>${exception}</p>
    </div>
    <div class="container">
        <p>
            <a href="<spring:url value="/products" />" class="btn btnprimary">
                <span class="glyphicon-hand-left glyphicon"></span>
                products
            </a>
        </p>
    </div>
</section>

</body>
</html>
