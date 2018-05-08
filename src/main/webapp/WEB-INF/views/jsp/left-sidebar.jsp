<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<link rel="stylesheet" href="css/main.css">

   <div class="col-sm-2 sidenav-left">
   	<div id="nav-title">Sections</div>
     <c:forEach var="section" items="${sections}">
       <div class="nav-item"><a href="${section.id}" style="color:white;">${section.name}</a></div>
     </c:forEach>
   </div>