<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<title>Verification page</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="<c:url value="/css/post.css" />" rel="stylesheet">
<link href="<c:url value="/css/upload.css" />" rel="stylesheet">
<base href="http://localhost:8080/9gag.com/">
</head>
<body>

	<c:import url="navbar.jsp"></c:import>
	<div class="container-fluid text-center">
		<div class="row content">
			<c:import url="left-sidebar.jsp"></c:import>
			<div class="col-sm-8 text-center">
				<h5 style="color: red">
					<i>${error}</i>
				</h5>
				<form action="activate" method="post">
					<label><b>Insert username here:</b></label>
					<input type="text" name="username"><br />
					<label><b>Insert the code here:</b></label>
					<input type="text" name="code">
					<input type="submit" value="Submit">
				</form>
			</div>
			<c:import url="right-sidebar.jsp"></c:import>
		</div>
	</div>

	<script src="<c:url value="/js/post.js" />"></script>
</body>
</html>