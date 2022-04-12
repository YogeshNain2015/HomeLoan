package com.example.demo.model;

public class SavingsAccount {
	int seq_id;
	long acc_no;
	String name;
	String email;
	long curr_bal;
	public int getSeq_id() {
		return seq_id;
	}
	public void setSeq_id(int seq_id) {
		this.seq_id = seq_id;
	}
	public long getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(long acc_no) {
		this.acc_no = acc_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getCurr_bal() {
		return curr_bal;
	}
	public void setCurr_bal(long curr_bal) {
		this.curr_bal = curr_bal;
	}
	
}
