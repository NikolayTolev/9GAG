<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="<c:url value="/css/post.css" />" rel="stylesheet">
<link href="<c:url value="/css/upload.css" />" rel="stylesheet">
<base href="http://localhost:8080/9gag.com/">
<title>Videos</title>
</head>
<body>

	<c:import url="navbar.jsp"></c:import>

	<div class="container-fluid text-center">
		<div class="row content">
			<c:import url="left-sidebar.jsp"></c:import>
			<div class="col-sm-8 text-center">
				<c:forEach var="video" items="${videos}">
					<tr>
						<div class="tp">
							<h2 onclick="openModel(${video.id})">${video.title}${video.id}
							</h2>
						</div>
						<div>
							<video>
								<source src="img/${video.imageURL}" onclick="openModel(${video.id})" style="max-width: 600px;">
							</video>
						</div>
						<div id="${video.id}" onclick="countPoints(${video.id})">
							click to see points</div>
						<div id="${video.id}+c"></div>
						<div class="tf">
							<button class="L" onclick="upvotePost(${video.id})">L</button>
							<button class="D">D</button>
							<button class="C" onclick="openModel(${video.id})">C</button>
						</div>
					</tr>
				</c:forEach>
			</div>
			<c:import url="right-sidebar.jsp"></c:import>
		</div>
	</div>

<script src="<c:url value="/js/post.js" />"></script>
<script src="<c:url value="/js/upload.js" />"></script>
</body>
</html>