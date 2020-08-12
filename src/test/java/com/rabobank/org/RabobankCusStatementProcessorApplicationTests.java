package com.rabobank.org;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.rabobank.org.model.CustomResponseEntity;
import com.rabobank.org.model.CustomerStatementModel;
import com.rabobank.org.model.ErrorRecordResponse;
import com.rabobank.org.service.RobBankCusStatProcessService;

@SpringBootTest
class RabobankCusStatementProcessorApplicationTests {

	@Autowired
	RobBankCusStatProcessService robBankCusStatProcessService;

	@Test
	public void whenDuplicateRefereceRecordProvided_thenRetrievedResponseIsCorrect() {
		List<CustomerStatementModel> list = new ArrayList<CustomerStatementModel>();
		CustomerStatementModel customerStatementModel = new CustomerStatementModel();
		customerStatementModel.setReference(112806L);
		customerStatementModel.setAccountNumber("NL93ABNA0585619023");
		customerStatementModel.setDescription("Tickets from Richard Bakker");
		customerStatementModel.setStartBalance(102.12F);
		customerStatementModel.setMutation(+45.87F);
		customerStatementModel.setEndBalance(147.99F);
		CustomerStatementModel customerStatementModel1 = new CustomerStatementModel();
		customerStatementModel1.setReference(112806L);
		customerStatementModel1.setAccountNumber("NL69ABNA0433647324");
		customerStatementModel1.setDescription("Clothes for Richard de Vries");
		customerStatementModel1.setStartBalance(90.83F);
		customerStatementModel1.setMutation(-10.91F);
		customerStatementModel1.setEndBalance(79.92F);
		list.add(customerStatementModel);
		list.add(customerStatementModel1);
		List<ErrorRecordResponse> list1 = new ArrayList<ErrorRecordResponse>();
		CustomResponseEntity customResponseEntity = new CustomResponseEntity();
		customResponseEntity.setResult("DUPLICATE_REFERENCE");
		ErrorRecordResponse errorRecordResponse1 = new ErrorRecordResponse();
		errorRecordResponse1.setReference(112806L);
		errorRecordResponse1.setAccountNumber("NL93ABNA0585619023");
		customResponseEntity.setErrors(list1);

		String result = robBankCusStatProcessService.isDuplicateRefAndInvaliBalExists(list).getResult();
		assertEquals(result, "DUPLICATE_REFERENCE");

	}

	@Test
	public void whenCorrectRecordProvided_thenRetrievedResponseIsCorrect() {
		List<CustomerStatementModel> list = new ArrayList<CustomerStatementModel>();
		CustomerStatementModel customerStatementModel = new CustomerStatementModel();
		customerStatementModel.setReference(112806L);
		customerStatementModel.setAccountNumber("NL93ABNA0585619023");
		customerStatementModel.setDescription("Tickets from Richard Bakker");
		customerStatementModel.setStartBalance(102.12F);
		customerStatementModel.setMutation(+45.87F);
		customerStatementModel.setEndBalance(147.99F);
		CustomerStatementModel customerStatementModel1 = new CustomerStatementModel();
		customerStatementModel1.setReference(112807L);
		customerStatementModel1.setAccountNumber("NL69ABNA0433647324");
		customerStatementModel1.setDescription("Clothes for Richard de Vries");
		customerStatementModel1.setStartBalance(90.83F);
		customerStatementModel1.setMutation(-10.91F);
		customerStatementModel1.setEndBalance(79.92F);
		list.add(customerStatementModel);
		list.add(customerStatementModel1);
		List<ErrorRecordResponse> list1 = new ArrayList<ErrorRecordResponse>();
		CustomResponseEntity customResponseEntity = new CustomResponseEntity();
		customResponseEntity.setResult("DUPLICATE_REFERENCE");
		ErrorRecordResponse errorRecordResponse1 = new ErrorRecordResponse();
		errorRecordResponse1.setReference(112806L);
		errorRecordResponse1.setAccountNumber("NL93ABNA0585619023");
		customResponseEntity.setErrors(list1);

		String result = robBankCusStatProcessService.isDuplicateRefAndInvaliBalExists(list).getResult();
		assertEquals(result, "SUCCESSFUL");

	}

	@Test
	public void isBalanceCorrectTest() {
		Float startBalance = 14F;
		Float mutation = -3F;
		Float endBalance = 11F;

		assertTrue(robBankCusStatProcessService.isBalanceCorrect(startBalance, mutation, endBalance));
	}
}
