<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book Form</title>
</head>
<body>
<h2>${book != null ? "Edit Book" : "Add Book"}</h2>
<form action="BookServlet" method="post">
    <input type="hidden" name="action" value="${book != null ? 'update' : 'insert'}"/>
