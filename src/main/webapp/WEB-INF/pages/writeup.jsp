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
    <c:forEach var="writeup" items="${writeups}">
        <div class="card text-center">
            <div class="card-header">
                By ${writeup.author}
            </div>
            <div class="card-body">
                <p class="card-text">${writeup.title}</p>
                <a href="${writeup.id}" class="btn btn-primary">Read</a>
            </div>
            <div class="card-footer text-muted">
                At ${writeup.date}
            </div>
        </div>
    </c:forEach>
</div>
<jsp:include page="../templates/footer.jsp"/>
</body>
</html>
