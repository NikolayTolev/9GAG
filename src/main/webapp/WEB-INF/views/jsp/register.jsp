<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
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
				<h1>Register</h1>
				<form action="register" method="post">
					<table align="center">
						<tr>
							<td><i>First name&nbsp;</i></td>
							<td><input type="text" name="firstName" required /></td>
						</tr>
						<tr>
							<td><i>Last name&nbsp;</i></td>
							<td><input type="text" name="lastName" required /></td>
						</tr>
						<tr>
							<td><i>Username&nbsp;</i></td>
							<td><input type="text" name="username" required /></td>
						</tr>
						<tr>
							<td><i>Password&nbsp;</i></td>
							<td><input type="password" name="password" required /></td>
						</tr>
						<tr>
							<td><i>Confirm password&nbsp;</i></td>
							<td><input type="password" name="password2" required /></td>
						</tr>
						<tr>
							<td><i>Email&nbsp;</i></td>
							<td><input type="email" name="email" required /></td>
						</tr>
						<tr>
							<td>Gender&nbsp;</td>
							<td><select style="width: 179px; height: 30px" name="gender">
									<c:forEach var="gender" items="${genders}">
										<option value="${gender.id}">${gender.type}</option>
									</c:forEach>
							</select></td>
						</tr>
						<tr>
							<td><input type="submit" value="Register"></td>
						</tr>
					</table>
					Already have an account?<a href="showlogin">&nbsp;Login here</a>
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