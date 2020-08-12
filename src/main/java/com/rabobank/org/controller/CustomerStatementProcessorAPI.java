/*
 * @Author Amarjeet
 */
package com.rabobank.org.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rabobank.org.model.CustomResponseEntity;
import com.rabobank.org.model.CustomerStatementModel;
import com.rabobank.org.service.RobBankCusStatProcessService;


/**
 * The Class CustomerStatementProcessorAPI 
 * This class has functionality to process the result and show errors
 * base on logic
 */
@RestController
public class CustomerStatementProcessorAPI {

	/** The rob bank cus stat process service. */
	@Autowired
	RobBankCusStatProcessService robBankCusStatProcessService;

	/**
	 * Process the records base on given records.
	 *
	 * @param customerStatementModels the customer statement models
	 * @return the response entity
	 */
	@PostMapping("/processRecords")
	public ResponseEntity<CustomResponseEntity> create(
			@RequestBody List<CustomerStatementModel> customerStatementModels) {

		CustomResponseEntity customResponseEntity = robBankCusStatProcessService
				.isDuplicateRefAndInvaliBalExists(customerStatementModels);

		return new ResponseEntity<CustomResponseEntity>(customResponseEntity, HttpStatus.OK);

	}

}
