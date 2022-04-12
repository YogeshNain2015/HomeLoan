<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<link  rel="stylesheet" type="text/css" href="./css/style.css"></link>
<title>Prepay Loan</title>
</head>
<body id="LoginForm">
	<div class="container">
		<div class="login-form">
			<div class="main-div">
			    <div class="panel">
			   <h2> Prepay</h2>
			   <p>Please enter your Loan Account and Amount</p>
			   </div>
			   <form action="prepayLoan" method="post">
					<div class="form-group">
			            <label>Loan Account : </label><input class="form-control" type="number" name="acc_id">
			        </div>
			        <div class="form-group">
			            <label>Amount : </label><input class="form-control" type="number" name="amount">
			        </div>
			        <button type="submit" class="btn btn-primary">Pay</button>
				</form>
			  </div>
		</div>
	</div>
</body>
</form>