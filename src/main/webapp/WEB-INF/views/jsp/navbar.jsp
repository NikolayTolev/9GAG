<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
 <link rel="stylesheet" href="css/main.css">
 <link rel="stylesheet" href="css/index.css">
 
 
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand"><span style="color: #AB0707"><b>FUN</b></span><span style="color: white"><i>FACTORY</i></span></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li><a href="#">Home</a></li>
        <li><a href="#">Videos <span class="glyphicon glyphicon-film"></span></a></li>
        <form class="navbar-form navbar-left" action="/action_page.php">
		  <div class="input-group">
		    <input type="text" class="form-control" placeholder="Search">
		    <div class="input-group-btn">
		      <button class="btn btn-default" type="submit">
		        <i class="glyphicon glyphicon-search"></i>
		      </button>
		    </div>
		  </div>
		</form>
      </ul>
      <c:choose>
		  <c:when test="${sessionScope.username != null}">
		    	<ul class="nav navbar-nav navbar-right">
        			<li >
        				<div class="dropdown" style="display: inline-block">
					 	<img src="https://vignette.wikia.nocookie.net/epicrapbattlesofhistory/images/4/4a/Mr-Bean-Meme.jpg/revision/latest?cb=20160912174428" class="img-circle" id="dropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
							 <ul class="dropdown-menu" aria-labelledby="dropdownMenu">
							   <li><a class="dropdown-item">Profile</a></li>
							   <li><a class="dropdown-item">Settings</a></li>
							   <li><a class="dropdown-item" onclick="location.href='logout'">Log out</a></li>
							 </ul>
						</div>
        			</li>
        			<li><button id="uploadButton" class="btn btn-danger navbar-btn">+ Upload</button></li>
      			</ul>
		  </c:when>
		  <c:otherwise>
		         <ul class="nav navbar-nav navbar-right">
        			<li><a onclick="location.href='showlogin'"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        			<li ><a onclick="location.href='showRegister'"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      			</ul>
		  </c:otherwise>
	 </c:choose>
    </div>
  </div>
</nav>