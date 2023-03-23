package com.indianbank.DAO;

public class Customers {
	private String name;
	private String father_name;
	private String uid;
	private String mobile_number;
	private String email;
	private String password;
	private long account_num;
	private String IFSC_code;
	private String branch;
	
	
	
	
	public Customers() {
		super();
	}

	


	public Customers(String name, String father_name, String uid, String mobile_number, String email, String password,
			String iFSC_code, String branch) {
		super();
		this.name = name;
		this.father_name = father_name;
		this.uid = uid;
		this.mobile_number = mobile_number;
		this.email = email;
		this.password = password;
		IFSC_code = iFSC_code;
		this.branch = branch;
	}




	public Customers(String name, String father_name, String uid, String mobile_number, String email, String password,
			String branch) {
		super();
		this.name = name;
		this.father_name = father_name;
		this.uid = uid;
		this.mobile_number = mobile_number;
		this.email = email;
		this.password = password;
		this.branch = branch;
	}




	public Customers(String name, String father_name, String uid, String mobile, String email, String password,
			long account_num, String iFSC_code, String branch) {
		super();
		this.name = name;
		this.father_name = father_name;
		this.uid = uid;
		this.mobile_number = mobile;
		this.email = email;
		this.password = password;
		this.account_num = account_num;
		IFSC_code = iFSC_code;
		this.branch = branch;
	}




	public String getName() {
		return name;
	}




	public void setName(String name) {
		this.name = name;
	}




	public String getFather_name() {
		return father_name;
	}




	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}




	public String getUid() {
		return uid;
	}




	public void setUid(String uid) {
		this.uid = uid;
	}




	public String getMobile_number() {
		return mobile_number;
	}




	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public long getAccount_num() {
		return account_num;
	}




	public void setAccount_num(long account_num) {
		this.account_num = account_num;
	}




	public String getIFSC_code() {
		return IFSC_code;
	}




	public void setIFSC_code(String iFSC_code) {
		IFSC_code = iFSC_code;
	}




	public String getBranch() {
		return branch;
	}




	public void setBranch(String branch) {
		this.branch = branch;
	}




	@Override
	public String toString() {
		return "Customers [name=" + name + ", father_name=" + father_name + ", uid=" + uid + ", mobile_number="
				+ mobile_number + ", email=" + email + ", password=" + password + ", account_num=" + account_num
				+ ", IFSC_code=" + IFSC_code + ", branch=" + branch + "]";
	}

	
	
	
	
}
