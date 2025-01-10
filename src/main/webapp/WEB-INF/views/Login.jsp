<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Guess the Number</title>
    <link rel="stylesheet" href="css/Style.css">
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h2>Login</h2>
            <form action="loginplayear" method="POST">
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Enter your email" required>
                
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Enter your password" required>
                
                <button type="submit" class="btn">Login</button>
                <p>Don't have an account? <a href="signup">Sign up</a></p>
            </form>
            <span style="color: red;">${error }</span>
        </div>
    </div>
</body>
</html>
