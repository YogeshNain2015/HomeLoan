<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<link href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<link  rel="stylesheet" type="text/css" href="./css/style.css"></link>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<div class="dashboard container">
		<button class="btn btn-primary" onclick="window.location.href='/apply'"> Apply Loan</button>
		<button class="btn btn-primary" onclick="window.location.href='/repay'"> Repay Schedule</button>
		<button class="btn btn-primary" onclick="window.location.href='/prepay'"> Loan Prepayment</button>
		<button class="btn btn-primary" onclick="window.location.href='/foreclose'"> Loan Foreclosure</button>
	</div>
</body>
</html>