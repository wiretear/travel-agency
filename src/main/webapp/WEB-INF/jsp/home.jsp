<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
	<title>Registration Form</title>

	<link rel="stylesheet"
		  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script	src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.4.5/js/bootstrapvalidator.min.js"></script>
</head>
<!DOCTYPE html>

<style>
	html, body {
		max-width: 100%;
		overflow-x: hidden;
	}
</style>
<body>
	<p>Welcome To Here.</p>

	<c:forEach var="boo" items="${listPersons}">

	<div class="container-fluid">
		<div class="col-md-6">
			<div class="panel panel-default">
				<div class="panel-heading">  <h4 >User Profile</h4></div>
				<div class="panel-body">
					<div class="col-md-4 col-xs-12 col-sm-6 col-lg-4">
						<img alt="User Pic" src="https://x1.xingassets.com/assets/frontend_minified/img/users/nobody_m.original.jpg" id="profile-image1" class="img-circle img-responsive">


					</div>
					<div class="col-md-8 ">
						<div class="container" >
							<h2>${boo.user_name}</h2>


						</div>
						<hr>
						<ul class="container details" >
							<li><p><span class="glyphicon glyphicon-user one" style="width:50px;"></span>${boo.status}</p></li>
							<li><p><span class="glyphicon glyphicon-envelope one" style="width:50px;"></span>${boo.checkInPlace}</p></li>
						</ul>
						<hr>

					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
		</div>
	</div>
	</c:forEach>

	<%--@elvariable id="information" type=""--%>

</body>
</html>