<%@page import="main.vo.PaisVO" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
	<c:import url="/fragments/metaLinks.jsp"></c:import>
	
	<title>Pais</title>
	
</head>

<body id="mimin" class="dashboard">
 
	<c:import url="/fragments/nav.jsp"/>
	
	<c:import url="/fragments/leftMenuAdmin.jsp"/>
	
	<div class="container-fluid mimin-wrapper">	
		<div id="content">	
			<div class="panel box-shadow-none content-header">
				<div class="panel-body">
					<div class="col-md-12">
						<c:if test="${accion == 'crear'}">
							<h3 class="animated fadeInLeft">Crear Pais</h3>
						</c:if>
						<c:if test="${accion == 'modificar'}">
							<h3 class="animated fadeInLeft">Modificar Pais</h3>
						</c:if>	
					</div>
				</div>
			</div>

			<div class="col-md-12 padding-0">
				<div class="col-md-12">
					<div class="panel">
						<div class="panel-heading">
							<h4>Datos</h4>
						</div>
						
						<div class="panel-body">
							<div class="col-md-12">
								<form class="cmxform" action="<%=request.getContextPath()%>/admin/pais">
									<input type="hidden" name="id_pais" value=${id_pais }>
									<div class="col-md-12">
										<div class="form-group form-animate-text" style="margin-top:40px !important;">
											<c:if test="${accion == 'crear'}">
												<input type="text" class="form-text" id="p_nombre" name="nombre" required aria-required="true">
											</c:if>
											<c:if test="${accion == 'modificar'}">
												<input type="text" class="form-text" id="p_nombre" name="nombre" required aria-required="true" value="${nombre }">
											</c:if>
											<span class="bar"></span>
											<label>Nombre del Pais</label>
										</div>		
									</div>
									
									<div class="col-md-12">
										<c:if test="${accion == 'crear'}">
											<input type="hidden" name="opcion" value="insertar">
											<button class="submit btn btn-success">Crear</button>
										</c:if>
										<c:if test="${accion == 'modificar'}">
											<input type="hidden" name="opcion" value="actualizar">
											<button class="submit btn btn-warning">Modificar</button>
										</c:if>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>

<script type="text/javascript">
window.onload = function(){
    var activarMenu = 'menu-paises';
    
    document.getElementById(activarMenu).className = 'active ripple';
    
};
</script>

<c:import url="/fragments/scripts.jsp"/>

</html>