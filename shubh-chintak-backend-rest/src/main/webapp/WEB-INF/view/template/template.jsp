<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Shubh-Chinktak</title>
<link rel="icon"
	href="<c:url value='/resources/images/icons/favicon.ico'/>">

<!-- Bootstrap Core CSS -->
<link
	href="<c:url value='/resources/vendor/bootstrap/css/bootstrap.min.css'/>"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link
	href="<c:url value='/resources/vendor/metisMenu/metisMenu.min.css'/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value='/resources/dist/css/sb-admin-2.css'/>"
	rel="stylesheet">

<!-- Morris Charts CSS -->
<link href="<c:url value='/resources/vendor/morrisjs/morris.css'/>"
	rel="stylesheet">

<!-- Custom Fonts -->
<link
	href="<c:url value='/resources/vendor/font-awesome/css/font-awesome.min.css'/>"
	rel="stylesheet" type="text/css">


<!-- /#wrapper -->

<!-- jQuery -->
<script src="<c:url value='/resources/vendor/jquery/jquery.min.js'/>"></script>

<!-- Bootstrap Core JavaScript -->
<script
	src="<c:url value='/resources/vendor/bootstrap/js/bootstrap.min.js'/>"></script>

<!-- Metis Menu Plugin JavaScript -->
<script
	src="<c:url value='/resources/vendor/metisMenu/metisMenu.min.js'/>"></script>

 <!-- Morris Charts JavaScript -->
<%--<script src="<c:url value='/resources/vendor/raphael/raphael.min.js'/>"></script>
<script src="<c:url value='/resources/vendor/morrisjs/morris.min.js'/>"></script>
<script src="<c:url value='/resources/data/morris-data.js'/>"></script>
 --%>
<!-- Custom Theme JavaScript -->
<script src="<c:url value='/resources/dist/js/sb-admin-2.js'/>"></script>


<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
	<div id="wrapper">
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">

		<div class="header">
			<tiles:insertAttribute name="header" />
		</div>
		<div class="menu">
			<tiles:insertAttribute name="menu" />
		</div>
		</nav>
		<div id="page-wrapper">
			<div class="body">
				<tiles:insertAttribute name="body" />
			</div>
		</div>
		<!-- /#page-wrapper -->
		<div class="footer">
			<tiles:insertAttribute name="footer" />
		</div>
	</div>

</body>