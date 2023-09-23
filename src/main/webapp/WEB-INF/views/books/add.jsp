<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form method="post" modelAttribute="book">
    isbn: <form:input path="isbn"/>
    title: <form:input path="title"/>
    author: <form:input path="author"/>
    publisher: <form:input path="publisher"/>
    type: <form:input path="type"/>
    <button type="submit">save</button>
</form:form>
</body>
</html>
