<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Writeup</title>
    <jsp:include page="../templates/scripts.jsp"/>
</head>
<body>
    <jsp:include page="../templates/header.jsp"/>
    <div class="container">
        <div class="card">
            <div class="card-header">
                ${writeup.title}
            </div>
            <div class="card-body">
                At ${writeup.date} by ${writeup.author}
            </div>

            <div class="card-text">
                ${writeup.content}
            </div>

            <div class="card-body">
                <c:url value="edit" var="edit"/>
                <a class="btn btn-primary" href="${writeup.id}/${edit}" role="button">Edit</a>
                <c:url value="delete" var="delete"/>
                <a class="btn btn-danger" href="${writeup.id}/${delete}" role="button">Delete</a>
            </div>
        </div>
    </div>
    <jsp:include page="../templates/footer.jsp"/>
</body>
</html>
