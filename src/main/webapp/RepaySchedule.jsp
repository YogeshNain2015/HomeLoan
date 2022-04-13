<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <link href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
  <link  rel="stylesheet" type="text/css" href="./css/style.css"></link>
<title>Repay Schedule</title>
</head>
<body>
<div class="repay container">
  
  <button onclick="exportData()" class="btn btn-primary">Export to CSV</button>
<TABLE BORDER="1" id="loanTable" class="table">
      <TR>
      <TH>Loan Account</TH>
      <TH>Year-Month</TH>
      <TH>EMI</TH>
      <TH>Principal</TH>
      <TH>Interest Amount</TH>
      <TH>Outstanding Amount</TH>
      <TH>Status</TH>
      </TR>
      <c:forEach var="result" items="${resultset}">
      <TR>
       <td> ${result.get("acc_id")}</td>
       <td> ${result.get("year_mnth")}</td>
       <td> ${result.get("emi")}</td>
       <td> ${result.get("principal")}</td>
       <td> ${result.get("int_amt")}</td>
       <td> ${result.get("outstanding")}</td>
       <td> ${result.get("status")}</td>
      </TR>
      </c:forEach>
     </TABLE>

</div>
     <script type="text/javascript" src="./JS/checks.js"></script>
</body>
</html>