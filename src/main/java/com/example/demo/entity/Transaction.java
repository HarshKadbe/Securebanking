package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	
	private String trans_amount;
	private String transferTo;
	
	@ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
	@JsonBackReference
	private User user;

	public Transaction() {
		// TODO Auto-generated constructor stub
	}

	public Transaction(Long transactionId, String trans_amount, String transferTo, User user) {
		this.transactionId = transactionId;
		this.trans_amount = trans_amount;
		this.transferTo = transferTo;
		this.user = user;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public String getTrans_amount() {
		return trans_amount;
	}

	public void setTrans_amount(String trans_amount) {
		this.trans_amount = trans_amount;
	}

	public String getTransferTo() {
		return transferTo;
	}

	public void setTransferTo(String transferTo) {
		this.transferTo = transferTo;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


}
