package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Transaction;
import com.example.demo.services.TransactionService;

@RestController
public class TransactionController {
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/createtransaction")
	public Transaction createTransaction(@RequestBody Transaction transaction) {
		return transactionService.createTransaction(transaction);
	}
	
	@GetMapping("/{transactionId}")
	public Transaction getTransactionByid(@PathVariable(value = "transactionId")Long transactionId) {
		return transactionService.getTransactionById(transactionId);
	}
	
	@PutMapping("/updatetransaction/{transactionId}")
	public Transaction updateTransaction(@PathVariable(value = "transactionId")Long transactionId, @RequestBody Transaction transaction) {
		Transaction existTransaction = transactionService.getTransactionById(transactionId);
		existTransaction.setTrans_amount(transaction.getTrans_amount());
		existTransaction.setTransferTo(transaction.getTransferTo());
		
		return transactionService.updateTransaction(existTransaction);
	}
	
	@DeleteMapping("/deletetransaction/{transactionId}")
	public void deleteTransaction(@PathVariable(value = "transactionId")Long transactionId) {
		transactionService.deleteTransaction(transactionId);
	}

}
