<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add book</title>
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

<section class="container">
    <form:form modelAttribute="book" class="form-horizontal">

        <fieldset>
            <legend>Add new book</legend>

            <div class="form-group">
                <label for="title" class="control-label col-lg-2">Title</label>
                <div class="col-lg-10">
                    <form:input path="title" id="title" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label for="author" class="control-label col-lg-2">Author</label>
                <div class="col-lg-10">
                    <form:input path="author" id="author" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label for="price" class="control-label col-lg-2">Price</label>
                <div class="col-lg-10">
                    <form:input path="price" id="price" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="category">Category</label>
                <div class="col-lg-10">
                    <form:input id="category" path="category" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2" for="unitsInStock">Units In Stock</label>
                <div class="col-lg-10">
                    <form:input id="unitsInStock" path="unitsInStock" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" class="btn-primary" value="Add">
                </div>
            </div>
        </fieldset>

    </form:form>
</section>

</body>
</html>
