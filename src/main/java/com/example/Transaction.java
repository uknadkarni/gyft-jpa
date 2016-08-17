package com.example;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Transaction {
	
	@Id
	public String transactionId;
	public String payeezyId;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(String transactionId, String payeezyId) {
		super();
		this.transactionId = transactionId;
		this.payeezyId = payeezyId;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public String getPayeezyId() {
		return payeezyId;
	}

	public void setPayeezyId(String payeezyId) {
		this.payeezyId = payeezyId;
	}

	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", payeezyId=" + payeezyId + "]";
	}
	
	

}
