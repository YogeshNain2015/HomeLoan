package com.example.demo.model;

import java.sql.Date;

public class LoanRepaymentSchedule {

	int acc_id;
	Date date;
	long emi;
	long principal;
	long int_amt;
	long out_amount;
	String status;
	public int getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getEmi() {
		return emi;
	}
	public void setEmi(long emi) {
		this.emi = emi;
	}
	public long getPrincipal() {
		return principal;
	}
	public void setPrincipal(long principal) {
		this.principal = principal;
	}
	public long getInt_amt() {
		return int_amt;
	}
	public void setInt_amt(long int_amt) {
		this.int_amt = int_amt;
	}
	public long getOut_amount() {
		return out_amount;
	}
	public void setOut_amount(long out_amount) {
		this.out_amount = out_amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

	
}
