package com.indianbank.DAO;

public class Transactions {
	private long account_num;
	private double transactions;
	
	
	
	public Transactions() {
		super();
	}


	public Transactions(long account_num, double transactions) {
		super();
		this.account_num = account_num;
		this.transactions = transactions;
	}


	public long getAccount_num() {
		return account_num;
	}


	public void setAccount_num(long account_num) {
		this.account_num = account_num;
	}


	public double getTransactions() {
		return transactions;
	}


	public void setTransactions(double amount) {
		this.transactions = amount;
	}
	
	
	
}
