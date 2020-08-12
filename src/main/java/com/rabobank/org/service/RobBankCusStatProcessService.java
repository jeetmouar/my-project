/*
 *  @Author Amarjeet
 */
package com.rabobank.org.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rabobank.org.model.CustomResponseEntity;
import com.rabobank.org.model.CustomerStatementModel;
import com.rabobank.org.model.ErrorRecordResponse;


/**
 * The Class RobBankCusStatProcessService.
 */
@Service
public class RobBankCusStatProcessService {

	/** The Constant INCORRECTENDBALANCE. */
	public static final String INCORRECTENDBALANCE = "INCORRECT_END_BALANCE";
	
	/** The Constant DUPLICATEREFERENCEINCORRECTENDBALANCE. */
	public static final String DUPLICATEREFERENCEINCORRECTENDBALANCE = "DUPLICATE_REFERENCE _INCORRECT_END_BALANCE";

	/** The Constant DUPLICATEREFERENCE. */
	public static final String DUPLICATEREFERENCE = "DUPLICATE_REFERENCE";
	
	/** The Constant SUCCESSFUL. */
	public static final String SUCCESSFUL = "SUCCESSFUL";

	/**
	 * Checks if is duplicate ref and invali bal exists.
	 *
	 * @param customerStatementModels the customer statement models
	 * @return the custom response entity
	 */
	public CustomResponseEntity isDuplicateRefAndInvaliBalExists(List<CustomerStatementModel> customerStatementModels) {
		boolean isIncorrectBalance = false;
		boolean isDuplicateExists = false;
		ErrorRecordResponse errorRecordResponse = null;
		CustomResponseEntity customResponseEntity = new CustomResponseEntity();
		;
		List<ErrorRecordResponse> errors = new ArrayList<ErrorRecordResponse>();
		for (int i = 0; i < customerStatementModels.size(); i++) {

			CustomerStatementModel customerStatementModel = customerStatementModels.get(i);
			long reference = customerStatementModel.getReference();
			Float startBalance = customerStatementModel.getStartBalance();
			Float mutation = customerStatementModel.getMutation();
			Float endBalance = customerStatementModel.getEndBalance();
			if (!isBalanceCorrect(startBalance, mutation, endBalance)) {

				isIncorrectBalance = true;
				customResponseEntity.setResult(INCORRECTENDBALANCE);
				errorRecordResponse = new ErrorRecordResponse(reference, customerStatementModel.getAccountNumber());
				errors.add(errorRecordResponse);
			}

			long n = customerStatementModels.stream().filter(x -> x.getReference().equals(reference)).count();

			if (n > 1) {
				isDuplicateExists = true;
				errorRecordResponse = new ErrorRecordResponse(reference, customerStatementModel.getAccountNumber());
				errors.add(errorRecordResponse);

			}

		}
		if (isIncorrectBalance & isDuplicateExists) {
			customResponseEntity.setResult(DUPLICATEREFERENCEINCORRECTENDBALANCE);

		} else if (isIncorrectBalance & !isDuplicateExists) {
			customResponseEntity.setResult(INCORRECTENDBALANCE);
		} else if (isDuplicateExists) {

			customResponseEntity.setResult(DUPLICATEREFERENCE);
		} else {
			customResponseEntity.setResult(SUCCESSFUL);
		}
		customResponseEntity.setErrors(errors);
		return customResponseEntity;
	}

	/**
	 * Checks if is balance correct.
	 *
	 * @param startBalance the start balance
	 * @param mutation the mutation
	 * @param endBalance the end balance
	 * @return true, if is balance correct
	 */
	public static boolean isBalanceCorrect(Float startBalance, Float mutation, Float endBalance) {
		return endBalance == (startBalance + mutation);
	}

}
