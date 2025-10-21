<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book List</title>
</head>
<body>
<h2>Books</h2>
<a href="BookServlet?action=new">Add New Book</a><br/><br/>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Actions</th>
    </tr>
    <c:forEach var="book" items="${list}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td>
                <a href="BookServlet?action=edit&id=${book.id}">Edit</a>
                <a href="BookServlet?action=delete&id=${book.id}" onclick="return confirm('Delete this book?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
