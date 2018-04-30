<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

<c:import url="navbar.jsp"></c:import>

<div class="container-fluid text-center">    
  <div class="row content">
  <c:import url="left-sidebar.jsp"></c:import>
    <div class="col-sm-8 text-center"> 
      <h4 style="color: red">${error}</h4>
		<h1>Login</h1>
		<form action="login" method="post">
			<table align="center">
			<tr>
				<td><i>Username </i></td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td><i>Password </i></td>
				<td><input type="password" name="password"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="Login"></td>
			</tr>
		</table>
		Don't have an account? <a href="showRegister"> Register here</a>
		</form>
    </div>
  <c:import url="right-sidebar.jsp"></c:import>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>
</body>
</html>