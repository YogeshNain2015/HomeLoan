<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Loan</title>
<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<link  rel="stylesheet" type="text/css" href="./css/style.css"></link>
</head>
<body id="LoginForm">
	<div class="container">
		<div class="login-form">
			<div class="main-div">
			    <div class="panel">
			   <h2> Login</h2>
			   <p>Please enter your login ID and password</p>
			   </div>
			   <form action="validate" method="post">
					<div class="form-group">
			            <input type="number" name="logId" class="form-control" id="inputEmail" placeholder="Login ID">
			        </div>
			        <div class="form-group">
			            <input type="password" name="password" class="form-control" id="inputPassword" placeholder="Password">
			        </div>
			        <button type="submit" class="btn btn-primary">Login</button>
				</form>
			  </div>
		</div>
	</div>
</body>
</html>


