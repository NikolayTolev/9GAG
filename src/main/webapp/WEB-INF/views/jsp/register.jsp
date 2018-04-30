<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>
 <c:import url="navbar.jsp"></c:import>
	<div align="center">
		<h4 style="color: red">${error}</h4>
			<h1>Register</h1>
			<form action="register" method="post">
				<table>
				<tr>
					<td>
						<i>First name</i>
					</td>
					<td>
						<input type="text" name="firstName" required/>
					</td>
				</tr>
				<tr>
					<td>
						<i>Last name</i>
					</td>
					<td>
						<input type="text" name="lastName" required/>
					</td>
				</tr>
				<tr>
					<td>
						<i>Username</i>
					</td>
					<td>
						<input type="text" name="username" required/>
					</td>
				</tr>
				<tr>
					<td>
						<i>Password</i>
					</td>
					<td>
						<input type="password" name="password" required/>
					</td>
				</tr>
				<tr>
					<td>
						<i>Confirm password</i>
					</td>
					<td>
						<input type="password" name="password2" required/>
					</td>
				</tr>
				<tr>
					<td>
						<i>Email</i>
					</td>
					<td>
						<input type="email" name="email" required/>
					</td>
				</tr>
				<tr>
					<td><input type="submit" value="Register"></td>
				</tr>
			</table>
			Already have an account?<a href="showlogin"> Login here</a>
			</form>
		</div>
</body>
</html>