<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard - Guess the Number</title>
    <link rel="stylesheet" href="css/Style2.css">
</head>
<body>
    <div class="dashboard-container">
    
    	<c:forEach var="image" items="${myimages}">
            <div style="display: inline-block; margin: 10px;">
                <img src="${image}" alt="Uploaded Image" style="width: 150px; height: auto; border: 1px solid #ccc;">
            </div>
        </c:forEach>

        <h1>Welcome to Guess the Number!</h1>
        <div class="button-container">
            <form action="playgame" method="GET">
            	<input type="hidden" name="userid" value='${sessionScope.id}'>
            	<input type="hidden" name="usercredits" value='${sessionScope.userCredits}'>
            	<input type="hidden" name="useremail" value='${sessionScope.userEmail}'>
                <button type="submit" class="dashboard-btn">Play Game</button>
            </form>
            <form action="leaderboard" method="GET">
            	<input type="hidden" name="userid" value='${sessionScope.id}'>
                <button type="submit" class="dashboard-btn">Leaderboard</button>
            </form>
            <form action="login" method="GET">
                <button type="submit" class="dashboard-btn" style="background: #f44336">Logout</button>
            </form>
        </div>
    </div>
</body>
</html>
