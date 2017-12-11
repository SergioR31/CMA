<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<nav class="navbar navbar-default header navbar-fixed-top">
	<div class="col-md-12 nav-wrapper">
		<div class="navbar-header" style="width:100%;">
			<a href="index.html" class="navbar-brand"><b>CMA</b></a>
			<ul class="nav navbar-nav navbar-right user-nav">
				<li class="user-name" style="padding-top: 5px">
                	<span>${pageContext.request.userPrincipal.name}</span>
                	<a href="../index.jsp" style="padding:0; text-align: right">Cerrar Sesion</a>
                </li>
					
				<li class="dropdown avatar-dropdown">
					<img src="../asset/img/avatar.jpg" class="img-circle avatar" alt="user name" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true"/>
				</li>
			</ul>
		</div>
	</div>
</nav>