<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>

	<% if (request.isUserInRole("ADMINISTRADOR"))
	{
	%>
	<%response.sendRedirect("pages/admin/home.jsp");%>
	<% } %>
	
	<% if (request.isUserInRole("COMERCIAL"))
	{
	%>
	<%response.sendRedirect("pages/comercial/home.jsp");%>
	<% } %>

</body>
</html>