<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="applyLoan" method="post" enctype="multipart/form-data" onsubmit="return validAmount()">
<label>Address : </label><input type="text" name="address" required><br>
<label>Total Loan Amount : </label><input id="LoanAmount" type="number" required min=1 name="total_loan_amt"><br>
<label>Tenure : </label><input type="number" min=5 max=20 name="tenure" required><br>
<label>Net Monthly Salary : </label><input id="MonthSalary" type="number" min=1 required name="net_month_sal"><br>
<label>Upload Image: </label><input type="file" name="image" required accept="image/png, image/jpeg" /><br>
<input type="submit">
<input type="reset" name="Cancel">
</form>
<script type="text/javascript" src="./JS/checks.js"></script>
</body>
</html>