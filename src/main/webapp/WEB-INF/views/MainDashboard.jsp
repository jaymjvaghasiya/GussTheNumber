<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Leaderboard - Guess the Number</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;700&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="css/style4.css">
</head>

<body>
    <div class="container">
        <!-- User Details Section -->
        <div class="user-details">
            <h2>Your Details</h2>
            <p><strong>ID:</strong> ${user.getId()}</p>
            <p><strong>Name:</strong> ${user.getName()}</p>
            <p><strong>Email:</strong> ${user.getEmail()}</p>
            <p><strong>Credits:</strong> ${user.getCredits()}</p>

            <!-- Back to Dashboard Button -->
            <a href="userdashboard" class="back-button">Back to Dashboard</a>
        </div>

        <!-- Leaderboard Section -->
        <div class="leaderboard">
            <h2>Leaderboard</h2>
            <table>
                <thead>
                    <tr>
                        <th>#</th>
                        <th>Name</th>
                        <th>Credits</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="player" items="${players}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${player.name}</td>
                            <td>${player.credits}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>

</html>
