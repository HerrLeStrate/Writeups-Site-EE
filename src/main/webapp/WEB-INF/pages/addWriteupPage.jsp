<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new writeup</title>
    <jsp:include page="../templates/scripts.jsp"/>
</head>
<body>
    <jsp:include page="../templates/header.jsp"/>
    <div class="container">
        <c:url value="/writeup/add" var="add"/>
        <form action="${add}" method="post">
            <input type="hidden" name="author" id="author" value="admin">
            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <span class="input-group-text">Title</span>
                </div>
                <input type="text" class="form-control" name="title" id="title">
            </div>

            <div class="input-group">
                <div class="input-group-prepend">
                    <span class="input-group-text">Content</span>
                </div>
                <textarea class="form-control" name="content" id="content"></textarea>
            </div>
        <input type="submit" class="btn btn-success" value="Add!">
        </form>
    </div>
    <jsp:include page="../templates/footer.jsp"/>
</body>
</html>
