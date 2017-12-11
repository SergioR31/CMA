<%@page import="main.vo.PaisVO" %>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
	<c:import url="/fragments/metaLinks.jsp"></c:import>
	
	<title>Lista Paises</title>
	
</head>

<body id="mimin" class="dashboard">
 
	<c:import url="/fragments/nav.jsp"/>
	
	<c:import url="/fragments/leftMenuAdmin.jsp"/>
	
	<div class="container-fluid mimin-wrapper">
		<div id="content">
		
			<div class="panel box-shadow-none content-header">
				<div class="panel-body">
					<div class="col-md-12">
						<h3 class="animated fadeInLeft">Lista Paises</h3>
					</div>
				</div>
			</div>

			<div class="col-md-12 padding-0">
				<div class="col-md-12">
					<div class="panel">
						<div class="panel-heading">
							<div style="position:absolute; right:30px">
								<form action = "<%=request.getContextPath()%>/admin/pais">
									<input type="hidden" name="opcion" value="crear">
									<button class="btn btn-success">Crear Pais</button>
								</form>
							</div>
							<h4>Paises</h4>
						</div>
						
						<div class="panel-body">
							<div class="responsive-table">
								<div id="datatables-example_wrapper" class="dataTables_wrapper form-inline dt-bootstrap no-footer">
									<div class="row">
										<div class="col-sm-12">
											<table id="datatables-example" class="table table-striped table-bordered dataTable no-footer" role="grid" aria-describedby="datatables-example_info" style="width: 100%;">
												<thead>
													<tr role="row">
														<th class="sorting_asc" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="1" aria-sort="ascending" aria-label="Nombre: activate to sort column descending" style="width: 93px; text-align:center;">
															Nombre
														</th>
														<th class="sorting" tabindex="0" aria-controls="datatables-example" rowspan="1" colspan="2" aria-label="Opciones: activate to sort column ascending" style="width: 154px; text-align:center;">
															Opciones
														</th>
													</tr>
												</thead>
												<tbody>
													<c:if test="${not empty listaPaises}">
														<c:forEach items="${listaPaises}" var="pais">
															<tr role="row">
																<td class="sorting_1" style="text-align:center;">${pais.nombre }</td>
																
																<td style="width:10%">
																	<form action = "<%=request.getContextPath()%>/pais">
																		<input type="hidden" name="opcion" value="modificar">
																		<button name="nombre_pais" class="btn btn-warning" value=${pais.id }>Modificar</button>
																	</form>	
																</td>
																<td style="width:10%">
																	<form>
																		<input type="hidden" name="opcion" value="eliminar">
																		<button onclick="if (confirm('Seguro que quieres eliminar el pais ${pais.nombre }?')) { form.action = '<%=request.getContextPath()%>/pais'; } else { return false; }" name="id_pais" class="btn btn-danger" value=${pais.id }>Eliminar</button>
																	</form>
																</td>
															</tr>
														</c:forEach>
													</c:if>
												</tbody>
											</table>
										</div>
									</div>
								</div>
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
    var respuesta = '${respuesta}';
    
    document.getElementById(activarMenu).className = 'active ripple';
    
    if (respuesta != null && respuesta != ""){
		alert(respuesta);
	}
};
</script>

<c:import url="/fragments/scripts.jsp"/>

</html>