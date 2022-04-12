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
	<title>Apply Loan</title>
</head>
<body id="LoginForm">
	<div class="container">
		<div class="login-form">
			<div class="main-div">
			    <div class="panel">
			   <h2> Apply Loan</h2>
			   </div>
			   <form action="applyLoan" method="post" enctype="multipart/form-data" onsubmit="return validAmount()">
					<div class="form-group">
			            <label>Address : </label><input class="form-control" type="text" name="address" required>
			        </div>
			        <div class="form-group">
			            <label>Total Loan Amount : </label><input class="form-control" id="LoanAmount" type="number" required min=1 name="total_loan_amt">
			        </div>
			        <div class="form-group">
			            <label>Tenure : </label><input class="form-control" type="number" min=5 max=20 name="tenure" required>
			        </div>
			        <div class="form-group">
			            <label>Net Monthly Salary : </label><input class="form-control" id="MonthSalary" type="number" min=1 required name="net_month_sal">
			        </div>
			        <div class="form-group">
			            <label>Upload Image: </label><input type="file" name="image" required accept="image/png, image/jpeg" />
			        </div>
			        <button type="submit" class="btn btn-primary">Login</button>
			        <button type="reset" name="Cancel" class="btn btn-primary">Reset</button>
				</form>
				<script type="text/javascript" src="./JS/checks.js"></script>
			  </div>
		</div>
	</div>
</body>