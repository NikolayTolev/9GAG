<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="css/profile.css">
<script src="js/profile.js"></script>
<title>Profile</title>
</head>
<body>

	<c:import url="navbar.jsp"></c:import>
	<div class="container-fluid text-center">
		<div class="row content">
			<c:import url="left-sidebar.jsp"></c:import>
			<div class="col-sm-8 text-left"> 
				<div class="flex-row">
					<div class="flex-1"></div>
				   <img src="img/${sessionScope.user.photo}" style="width: 100px; height: 100px; margin: 20px;"/>
				   
					<div><h2>${sessionScope.user.username}</h2></div>
					<div class="flex-1"></div>
				</div>
		
	<div id="flip-tabs">
		<ul id="flip-navigation">
			<li class="profile-tab selected" onclick="selectPosts()" id="postsBtn">
				<a href="javascript://" id="tab-0" class="profile-tab">Posts</a>
			</li>
			<li class="profile-tab" id="votedBtn">
				<a href="javascript://" id="tab-1" onclick="selectVoted()" class="profile-tab">Voted
			</a>
			</li>
			<li class="profile-tab" id="commentedBtn">
				<a href="javascript://" id="tab-2" onclick="selectCommented()" class="profile-tab">Commented</a>
			</li>
		</ul>

		<div id="flip-container">
			<div id="postsTab">
			</div>
			<div id="votedTab" class="tab-hidden">
			</div>
			<div id="commentedTab" class="tab-hidden">
			</div>
		</div>
	</div>
			</div>
			<c:import url="right-sidebar.jsp"></c:import>
		</div>
	</div>
	
</body>
</html>