<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Play Game</title>
    <link rel="stylesheet" href="css/style3.css">
</head>
<body>
    <div class="game-container">
        <h1>Guess the Number</h1>
        <p>Try to guess the randomly generated number between 1 and 10!</p>

        <!-- User Credits -->
        <p class="credits">Your Credits: ${sessionScope.userCredits}</p>
        
        <form method="POST" action="checknum">
            <input type="number" name="num" min="1" max="100" placeholder="Enter your guess" required>
            <input type="hidden" name="userid" value="${sessionScope.id}">
            <input type="hidden" name="email" value="${sessionScope.userEmail}">
            <input type="hidden" name="credits" value="${sessionScope.userCredits}">
            <button type="submit">Check Number</button>
        </form>

        <a href="userdashboard" class="back-link">Back to Dashboard</a>

        <div class="alert" id="alert">
            <!-- Success/Error Message will appear here -->
        </div>
    </div>
</body>
</html>
