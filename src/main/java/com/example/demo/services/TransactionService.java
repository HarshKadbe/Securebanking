package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Transaction;
import com.example.demo.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	public Transaction createTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	public Transaction getTransactionById(Long transactionId) {
		return transactionRepository.findById(transactionId).get();		
	}
	
	public Transaction updateTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	public void deleteTransaction(Long transactionId) {
		transactionRepository.deleteById(transactionId);
	}

}
