<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

	<c:import url="/fragments/metaLinks.jsp"></c:import>
	
	<title>Home Admininstrador</title>
</head>
	
<body>
		
	<c:import url="/fragments/nav.jsp"/>
	
	<c:import url="/fragments/leftMenuAdmin.jsp"/>
		
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

<script type="text/javascript">
window.onload = function(){
    var activarMenu = 'menu-inicio';
    document.getElementById(activarMenu).className = 'active ripple';
};
</script>

<c:import url="/fragments/scripts.jsp"/>

</html>