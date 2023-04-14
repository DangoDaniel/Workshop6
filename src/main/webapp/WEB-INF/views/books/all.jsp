<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Book List</title>
</head>
<body>

<table border="1">
    <thead>
    <th>id</th>
    <th>title</th>
    <th>author</th>
    <th>isbn</th>
    <th>publisher</th>
    <th>type</th>
    <th>actions</th>
    </thead>
    <tbody>
    <c:forEach items="${books}" var="book">
        <tr>
            <td><c:out value="${book.id}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.publisher}"/></td>
            <td><c:out value="${book.type}"/></td>
            <td><a href="<c:out value="edit/${book.id}"/>">Edit</a>
                <a href="<c:out value="delete/${book.id}"/>">Delete</a>
                <a href="<c:out value="details/${book.id}"/>">Details</a>
            </td>
        </tr>

    </c:forEach>
    <tr>
        <td><a href="<c:out value="add"/>">Add book</a>
    </tr>
    </tbody>
</table>
</body>
</html>