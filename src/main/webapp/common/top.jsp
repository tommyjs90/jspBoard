<%@ page import="kr.or.ddit.student.model.StudentVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	
	<title>Jsp</title>
	
	<%@include file="/common/jquery.jsp" %>
	
	<!-- Custom styles for this template -->
	<script src="/bootstrap/js/bootstrap.js"></script>
	
	<!-- Bootstrap core CSS -->
	<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
	
	<!-- design CSS -->
	<link href="/css/dashboard.css" rel="stylesheet">
	<link href="/css/blog.css" rel="stylesheet">
	<link href="/css/style.css" rel="stylesheet">
	
	<!-- font-awesome CSS -->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css">

</head>

<body>
	
	<!-- top bar //-->
	<nav class="navbar navbar-fixed-top navbar-top navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
		
			<button type="button" id="sidebarCollapse" class="btn btn-info">
				<i class="fas fa-align-left"></i>
				<span>Toggle Sidebar</span>
			</button>
			<button class="btn btn-dark d-inline-block d-lg-none ml-auto" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
				<i class="fas fa-align-justify"></i>
			</button>
		
			<div class="navbar-collapse collapse" id="navbarSupportedContent">
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">
							<c:if test="${studentVo.std_id != null}">${studentVo.std_id }</c:if>
							<span class="caret"></span>
						</a>
						<ul class="dropdown-menu" role="menu">
							<li><a href="/logout">LOGOUT</a></li>
						</ul>
					</li>
				</ul>
			</div>
			
		</div>
	</nav>
	<!--// top bar -->
	
	
