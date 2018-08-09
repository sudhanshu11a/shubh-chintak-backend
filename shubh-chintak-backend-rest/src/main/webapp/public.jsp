<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="Sudhanshu Sharma">
<link rel="icon"
	href="<c:url value='/resources/images/icons/favicon.ico'/>">

<title>Shubh-Chintak</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value='/resources/css/bootstrap.min.css'/>"
	rel="stylesheet">

<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<link
	href="<c:url value='/resources/css/ie10-viewport-bug-workaround.css'/>"
	rel="stylesheet">

<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
<!--[if lt IE 9]><script src="js/ie8-responsive-file-warning.js"></script><![endif]-->
<script
	src="<c:url value='/resources/js/ie-emulation-modes-warning.js'/>"></script>

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<!-- Custom styles for this template -->
<link href="<c:url value='/resources/css/carousel.css'/>"
	rel="stylesheet">
</head>
<!-- ============NAVBAR========== -->
<body>
	<div class="navbar-wrapper">
		<div class="container">

			<nav class="navbar navbar-inverse navbar-static-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">Shubh-Chintak</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="active"><a href="#">Home</a></li>
						<li><a href="#about">About</a></li>
						<li><a href="#contact">Contact</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button" aria-haspopup="true"
							aria-expanded="false">Dropdown <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li><a href="#">Action</a></li>
								<li><a href="#">Another action</a></li>
								<li><a href="#">Something else here</a></li>
								<li role="separator" class="divider"></li>
								<li class="dropdown-header">Nav header</li>
								<li><a href="#">Separated link</a></li>
								<li><a href="#">One more separated link</a></li>
							</ul></li>
					</ul>
					<ul><a class="btn btn-lg btn-primary" href="loginPage" role="button">Join Us</a></ul>
				</div>
			</div>
			</nav>

		</div>
	</div>


	<!-- =============Carousel============ -->
	<div id="myCarousel" class="carousel slide" data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
			<li data-target="#myCarousel" data-slide-to="1"></li>
			<li data-target="#myCarousel" data-slide-to="2"></li>
		</ol>
		<div class="carousel-inner" role="listbox">
			<div class="item active">
				<img class="first-slide"
					src="<c:url value='${banner1}'/>"
					alt="First slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Some Content</h1>
						<p>
							:) 
						</p>
						<p>
							<a class="btn btn-lg btn-primary" href="loginPage" role="button">Join Us</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="second-slide"
					src="<c:url value='/resources/images/teams/team2.jpg'/>"
					alt="Second slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Some content 2</h1>
						<p> Details </p>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Learn
								more</a>
						</p>
					</div>
				</div>
			</div>
			<div class="item">
				<img class="third-slide"
					src="<c:url value='/resources/images/teams/team3.jpg'/>"
					alt="Third slide">
				<div class="container">
					<div class="carousel-caption">
						<h1>Some content 2</h1>
						<p>Details</p>
						<p>
							<a class="btn btn-lg btn-primary" href="#" role="button">Browse
								gallery</a>
						</p>
					</div>
				</div>
			</div>
		</div>
		<a class="left carousel-control" href="#myCarousel" role="button"
			data-slide="prev"> <span class="glyphicon glyphicon-chevron-left"
			aria-hidden="true"></span> <span class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#myCarousel" role="button"
			data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>
	<!-- /.carousel -->


	<!-- Marketing messaging and featurettes
    ================================================== -->
	<!-- Wrap the rest of the page in another container to center all the content. -->

	<div class="container marketing">

		<!-- Three columns of text below the carousel -->
		<div class="row">
			<div class="col-lg-4">
				<img class="img-circle"
					src="<c:url value='/resources/images/projects/project1.jpg'/>"
					alt="Project Education" width="140" height="140">
				<h2>Shiksha Abhiyan</h2>
				<p>Project Details</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle"
					src="<c:url value='/resources/images/projects/project2.jpg'/>"
					alt="s" width="140" height="140">
				<h2>Medical Health Project</h2>
				<p>Details ....</p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
			<div class="col-lg-4">
				<img class="img-circle"
					src="<c:url value='/resources/images/projects/project3.jpg'/>"
					alt="Generic placeholder image" width="140" height="140">
				<h2>Aashirwad</h2>
				<p>Details... </p>
				<p>
					<a class="btn btn-default" href="#" role="button">View details
						&raquo;</a>
				</p>
			</div>
			<!-- /.col-lg-4 -->
		</div>
		<!-- /.row -->


		<!-- START THE FEATURETTES -->

		<!-- Looping here Start EVEN ODD -->
		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading">
					Event One  <span class="text-muted">Heading</span>
				</h2>
				<p class="lead">Event one details</p>
			</div>
			<div class="col-md-5">
				<img class="featurette-image img-responsive center-block" src="<c:url value='/resources/images/projects/project1.jpg'/>"
					data-src="holder.js/500x500/auto" alt="Generic placeholder image">
			</div>
		</div>

		<!-- Looping here End -->
		
		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7 col-md-push-5">
				<h2 class="featurette-heading">
					Event 2  <span class="text-muted">Heading</span>
				</h2>
				<p class="lead">Event Details </p>
			</div>
			<div class="col-md-5 col-md-pull-7">
				<img class="featurette-image img-responsive center-block" src="<c:url value='/resources/images/projects/project2.jpg'/>"
					data-src="holder.js/500x500/auto" alt="Generic placeholder image">
			</div>
		</div>

		<hr class="featurette-divider">

		<div class="row featurette">
			<div class="col-md-7">
				<h2 class="featurette-heading">
					Event 3 <span class="text-muted">Heading</span>
				</h2>
				<p class="lead"> Event 3 Details</p>
			</div>
			<div class="col-md-5">
				<img class="featurette-image img-responsive center-block" src="<c:url value='/resources/images/projects/project3.jpg'/>"
					data-src="holder.js/500x500/auto" alt="Generic placeholder image">
			</div>
		</div>

		<hr class="featurette-divider">

		<!-- /END THE FEATURETTES -->


		<!-- FOOTER -->
		<footer>
		<p class="pull-right">
			<a href="#">Back to top</a>
		</p>
		<p>
			&copy; Shubh-chintak 2016 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a
				href="#">Terms</a>
		</p>
		</footer>

	</div>
	<!-- /.container -->
	<!-- ======Bootstrap core JavaScript======= -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="<c:url value='/resources/js/jquery.min.js'/>"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="/resources/js/jquery.min.js"><\/script>')
	</script>
	<script src="<c:url value='/resources/js/bootstrap.min.js'/>" />
	<!-- Just to make our placeholder images work. Don't actually copy the next line! -->
	<script src="<c:url value='/resources/js/vendor/holder.min.js'/>" />
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="<c:url value='/resources/js/ie10-viewport-bug-workaround.js'/>"></script>
</body>
</html>
