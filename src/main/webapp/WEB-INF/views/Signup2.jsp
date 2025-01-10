<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sign Up - Guess the Number</title>   
    <link rel="stylesheet" href="css/Style.css">
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h2>Sign Up</h2>
            <form action="adduser2" method="POST" enctype="multipart/form-data">
                <label for="name">Name</label>
                <input type="text" id="name" name="name" placeholder="Enter your name" required>
                
                <label for="email">Email</label>
                <input type="email" id="email" name="email" placeholder="Enter your email" required>
                
                <label for="password">Password</label>
                <input type="password" id="password" name="password" placeholder="Create a password" required>
                
                <label for="pr">Profile Pic: </label>
                <input type="file" id="file" name="profilePic" multiple required>
                
                <button type="submit" class="btn">Sign Up</button>
                <p>Already have an account? <a href="login">Login</a></p>
            </form>
        </div>
    </div>
</body>
</html>
