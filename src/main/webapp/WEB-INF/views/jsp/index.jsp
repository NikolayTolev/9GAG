<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <title>9GAG</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  
  <base href="http://localhost:8080/9gag.com/">
</head>
<body>

 <c:import url="navbar.jsp"></c:import>
 
 
<div class="container-fluid text-center">    
  <div class="row content">
  <c:import url="left-sidebar.jsp"></c:import>
    <div class="col-sm-8 text-left"> 
      <h1>Welcome</h1>
      <p></p>
      <hr>
      <h3>Test</h3>
      <p>Lorem ipsum...</p>
    </div>
  <c:import url="right-sidebar.jsp"></c:import>
  </div>
</div>

<footer class="container-fluid text-center">
  <p>Footer Text</p>
</footer>

</body>
</html>
