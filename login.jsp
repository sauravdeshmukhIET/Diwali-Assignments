<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
</head>
<body>
    <h2>Login</h2>
    <form action="LoginServlet" method="post">
        Login ID: <input type="text" name="loginId" required /><br/><br/>
        Password: <input type="password" name="password" required /><br/><br/>
        <input type="submit" value="Login" />
    </form>
    <p style="color:red;"><%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %></p>
</body>
</html>
