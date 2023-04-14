<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit book</title>
</head>

<body>
<c:url var="edit_url" value="/admin/books/edit"/>

<form:form method="post" modelAttribute="book" action="${edit_url}">

    <form:hidden path="id"/>
    <form:label path="title">Title</form:label>
    <form:input path="title"/>
    <form:errors path="title"/><br/>

    <form:label path="author">Author</form:label>
    <form:input path="author"/>
    <form:errors path="author"/><br/>

    <form:label path="isbn">ISBN</form:label>
    <form:input path="isbn"/>
    <form:errors path="isbn"/><br/>

    <form:label path="publisher">publisher</form:label>
    <form:input path="publisher"/>
    <form:errors path="publisher"/><br/>

    <form:label path="type">type</form:label>
    <form:input path="type"/>
    <form:errors path="type"/><br/>

    <input type="submit" value="Save">

</form:form>

</body>
</html>