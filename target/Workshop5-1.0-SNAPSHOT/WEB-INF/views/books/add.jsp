<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
  <title>Add book</title>
</head>
<body>

<h3>Book add</h3>

<form:form method="post" modelAttribute="book">

  <div>Title: <form:input path="title"/>
    <form:errors path="title"/></div>
  <div>Author: <form:input path="author"/>
    <form:errors path="author"/></div>
  <div>Isbn: <form:input path="isbn"/>
    <form:errors path="isbn"/></div>
  <div>Publisher: <form:input path="publisher"/>
    <form:errors path="publisher"/></div>
  <div>Type: <form:input path="type"/>
    <form:errors path="type"/></div>
  <input type="submit" value="Save">
</form:form>

</body>
</html>