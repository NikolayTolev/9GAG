<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Simple Model</title>
    <link rel="stylesheet" href="css/style2.css">
</head>
<body>
<h1>Hey man</h1>
    <script src="js/main.js"></script>
    <c:forEach var="post" items="${posts}"  >
    <div id="${post.id}" class="model">
        <div class="model-content" style=>
            <div class="model-header">
                 <span class="closeBtn">&times;</span>
                 <h2>${post.title}</h2>
            </div>
            <div class="model-body">
            <img src=">${post.imageURL}"/>    
            </div>
            <div class="model-footer">
                <button id="like" class="lButton">L</button>
                <button id="like" class="dButton">D</button>
                <button id="like" class="cButton">C</button>
            </div>
        </div>
    </div>
    </c:forEach>
    
</body>
</html>