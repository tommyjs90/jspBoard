<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
		<meta name="description" content="">
		<meta name="author" content="">
		<link rel="icon" href="../../favicon.ico">
		
		<title>Signin Template for Bootstrap</title>
		
		<!-- Bootstrap core CSS -->
		<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		
		<!-- Custom styles for this template -->
		<link href="/css/signin.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
		
		<%@include file="/common/jquery.jsp" %>
	
	</head>
	
	<body style="padding-top:150px">
	
		<!-- container //-->
		<div class="container">
		
			<!-- login form //-->
			<form class="form-signin border-box" action="/loginServlet" method="post">
	      
				<!-- <h2 class="form-signin-heading">LOGIN</h2> -->
				<div class="signin-head">
					<div class="logo">Z</div>
					<h3>JSP BOARD WEBSITE</h3>
				</div>
	        
				<!-- id input -->
				<label for="userId" class="sr-only">User ID</label>
				<input type="text" id="userId" name="userId" class="form-control marbtm-10" placeholder="User ID" required autofocus value="${param.userId }">
	        
	        	<!-- password input -->
				<label for="password" class="sr-only">Password</label>
				<input type="password" id="pass" name="pass" class="form-control" placeholder="Password" required>
	        
	        	<!-- checkbox -->
				<div class="checkbox">
					<label>
						<input type="checkbox" id="rememberMe" name="rememberMe" value=""> Remember me
					</label>
				</div>
	        
				<!-- sign in button -->
				<button class="btn btn-lg btn-primary btn-block martop-20" type="submit">Sign in</button>
				
				<!-- copyright -->
				<div class="copyright">&copy; 2018 ZCHU. all right reserved.</div>
	      </form>
	      <!--// login form -->
	
		</div>
		<!--// container -->
	
	</body>
</html>
