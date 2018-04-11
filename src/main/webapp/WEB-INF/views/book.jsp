<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${book.title}</title>
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>

<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Books</h1>
        </div>
    </div>
</section>

<section class="container">
    <div class="row">
        <div class="col-md-5">
            <h3>${book.title}</h3>
            <p>by ${book.author}</p>
            <p><strong>Category:</strong> ${book.category}</p>
            <p><strong>Available in stock:</strong> ${book.unitsInStock}</p>
            <h4>${book.price} USD</h4>
            <a href="<spring:url value="/books" />" class="btn btn-default">
                <span class="glyphicon glyphicon-hand-left"></span> back
            </a>
            <a href="#" class="btn btn-warning btn-large">
                <span class="glyphicon glyphicon-shopping-cart"> Order</span>
            </a>
        </div>
    </div>
</section>

</body>
</html>
