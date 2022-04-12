package com.example.demo.model;

public class LoanAccount {
	int acc_id;
	long saving_acc_no;
	long total_loan_amt;
	int rate=7;
	int tenure;
	String address;
	long net_month_sal;
	String assetImage;
	String status;
	public int getAcc_id() {
		return acc_id;
	}
	public void setAcc_id(int acc_id) {
		this.acc_id = acc_id;
	}
	public long getSaving_acc_no() {
		return saving_acc_no;
	}
	public void setSaving_acc_no(long saving_acc_no) {
		this.saving_acc_no = saving_acc_no;
	}
	public long getTotal_loan_amt() {
		return total_loan_amt;
	}
	public void setTotal_loan_amt(long total_loan_amt) {
		this.total_loan_amt = total_loan_amt;
	}
	public int getRate() {
		return rate;
	}
	public int getTenure() {
		return tenure;
	}
	public void setTenure(int tenure) {
		this.tenure = tenure;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getNet_month_sal() {
		return net_month_sal;
	}
	public void setNet_month_sal(long net_month_sal) {
		this.net_month_sal = net_month_sal;
	}
	public String getAssetImage() {
		return assetImage;
	}
	public void setAssetImage(String image) {
		this.assetImage = image;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	

}
