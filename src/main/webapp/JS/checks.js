function validAmount(){
	var amount=document.getElementById("LoanAmount");
	var salary=document.getElementById("MonthSalary");
	if(amount.value>50*salary.value)
	{
		var isConfirm=confirm("The loan amount you enter is not elligible for approval.\nMaximum allowed loan "+ (50*salary.value) + ".\nWould you like to continue?");
		if(isConfirm){
			amount.value=50*salary.value;
			return true;
		}
		return false;
	}
	return true;
}