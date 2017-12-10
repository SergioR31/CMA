<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<c:import url="/metaLinks.jsp"></c:import>
	
	<title>Home Comercial</title>
</head>

<body>

	<c:import url="/nav.jsp"/>
		
	<div class="container-fluid mimin-wrapper">
		<div id="content">
			<div class="panel box-shadow-none content-header">
				<div class="panel-body">
					<div class="col-md-12">
					
						<p>Usuario: <%=request.getRemoteUser()%></p> 
						<p>Usuario: <%=request.getUserPrincipal()%></p>
					
					</div>
				</div>
			</div>
			
			
		</div>
	</div>
	
</body>

<c:import url="/scripts.jsp"/>

</html>