<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="utf-8">
	<meta name="description" content="Miminium Admin Template v.1">
	<meta name="author" content="Isna Nur Azis">
	<meta name="keyword" content="">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	
	<!-- start: Css -->
	<link rel="stylesheet" type="text/css" href="asset/css/bootstrap.min.css">
	
	<!-- plugins -->
	<link rel="stylesheet" type="text/css" href="asset/css/plugins/font-awesome.min.css"/>
	<link rel="stylesheet" type="text/css" href="asset/css/plugins/simple-line-icons.css"/>
	<link rel="stylesheet" type="text/css" href="asset/css/plugins/animate.min.css"/>
	<link rel="stylesheet" type="text/css" href="asset/css/plugins/icheck/skins/flat/aero.css"/>
	<link href="asset/css/style.css" rel="stylesheet">
	
	<!-- end: Css -->
	
	<link rel="shortcut icon" href="asset/img/logo.png">
</head>

<body id="mimin" class="dashboard form-signin-wrapper">
	<div class="container">
		<form class="form-signin" method="post" action="j_security_check" name="formLogin">
			<div class="panel periodic-login">
				<div class="panel-body text-center">
					<h1>CMA</h1>
					
					<i class="icons icon-arrow-down"></i>
					<div class="form-group form-animate-text" style="margin-top:40px !important;">
						<input id="user" name="j_username" type="text" class="form-text" required>
						<span class="bar"></span>
                    	<label>Usuario</label>
					</div>
					
					<div class="form-group form-animate-text" style="margin-top:40px !important;">
						<input id="password" name="j_password" type="password" class="form-text" required>
						<span class="bar"></span>
						<label>Contraseña</label>
					</div>
					<label class="pull-left">
						<input type="checkbox" class="icheck pull-left" name="checkbox1"/> Remember me
					</label>
					<input type="submit" class="btn col-md-12" value="Login"/>
				</div>
				
				<div class="text-center" style="padding:5px;">
					<a href="forgotpass.html">Forgot Password </a>
					<a href="reg.html">| Signup</a>
				</div>
			</div>
		</form>
	</div>
	<!-- end: Content -->
	
	<!-- start: Javascript -->
	<script src="asset/js/jquery.min.js"></script>
	<script src="asset/js/jquery.ui.min.js"></script>
	<script src="asset/js/bootstrap.min.js"></script>

	<script src="asset/js/plugins/moment.min.js"></script>
	<script src="asset/js/plugins/icheck.min.js"></script>
	
	<!-- custom -->
	<script src="asset/js/main.js"></script>
	<script type="text/javascript">
	
	function login(){
		var user = document.getElementById("user");
		var pass = document.getElementById("password");
		if(user == null || user.value == ""){
			alert("El campo usuario no debe estar vacio");
			user.focus();
			return;
		}
		if(pass == null || pass.value==""){
			alert("El campo password no debe estar vacio");
			pass.focus();
			return;
		}
		
		document.forms["formLogin"].action = "j_security_check";
		document.forms["formLogin"].submit();
	}
	</script>
	
	<script type="text/javascript">
		$(document).ready(function(){
			$('input').iCheck({
				checkboxClass: 'icheckbox_flat-aero',
				radioClass: 'iradio_flat-aero'
			});
		});
     </script>
     <!-- end: Javascript -->
     
</body>
</html>