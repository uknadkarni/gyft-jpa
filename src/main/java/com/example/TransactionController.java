package com.example;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
	
	@Autowired
	TransactionRepository tr;
	
	Logger logger = Logger.getLogger(TransactionController.class);

	public TransactionController() {
		// TODO Auto-generated constructor stub
	}
	
	@RequestMapping(value="/transaction", method=RequestMethod.POST)
	public Transaction transaction(@RequestParam(value="transactionId", defaultValue="t1") String transactionId, 
			@RequestParam(value="payeezyId", defaultValue="p1")String payeezyId){
		Transaction t = new Transaction(transactionId, payeezyId);
		logger.info("Saving: " + t);
		return tr.save(t);
	}
	
	@RequestMapping(value="/transaction", method=RequestMethod.GET)
	public Transaction transaction(@RequestParam(value="transactionId", defaultValue="t1") String transactionId){
		
		Transaction t = tr.findOne(transactionId);
		if(t == null){
			logger.error("Unable to find transaction with id: " + transactionId);
		}
		logger.info("Found transaction " + t + " with id: " + transactionId);
		return t;
	}

}
