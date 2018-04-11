<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Books</title>
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
        <div class="col-sm-6 col-md-3">
            <div class="thumbnail">
                <div class="caption">
                    <h3>${book.title}</h3>
                    <p>By ${book.author}</p>
                    <p>${book.price} USD</p>
                    <p>Available ${book.unitsInStock} units in stock</p>
                </div>
            </div>
        </div>
    </div>
</section>

</body>
</html>
