<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
<tr>
<th>isbn</th>
<th>title</th>
<th>author</th>
<th>publisher</th>
<th>type</th>
</tr>
<tbody>
    <tr>
        <td><c:out value="${book.isbn}"/></td>
        <td><c:out value="${book.title}"/></td>
        <td><c:out value="${book.author}"/></td>
        <td><c:out value="${book.publisher}"/></td>
        <td><c:out value="${book.type}"/></td>
    </tr>
</tbody>
</table>
<a href="<c:url value="/admin/books/all"/>">bookList</a>
</body>
</html>
