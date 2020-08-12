/*
 *  @Author Amarjeet
 */
package com.rabobank.org.model;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * The Class ErrorRecordResponse help to generate the response.
 */
public class ErrorRecordResponse {
	
	/** The reference. */
	@JsonProperty("Reference")
	private Long reference;
	
	/** The account number. */
	@JsonProperty("AccountNumber")
	private String accountNumber;

	/**
	 * Gets the reference.
	 *
	 * @return the reference
	 */
	public Long getReference() {
		return reference;
	}

	/**
	 * Sets the reference.
	 *
	 * @param reference the new reference
	 */
	public void setReference(Long reference) {
		this.reference = reference;
	}

	/**
	 * Gets the account number.
	 *
	 * @return the account number
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Sets the account number.
	 *
	 * @param accountNumber the new account number
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Instantiates a new error record response.
	 *
	 * @param reference the reference
	 * @param accountNumber the account number
	 */
	public ErrorRecordResponse(Long reference, String accountNumber) {
		super();
		this.reference = reference;
		this.accountNumber = accountNumber;
	}

	/**
	 * Instantiates a new error record response.
	 */
	public ErrorRecordResponse() {
		// TODO Auto-generated constructor stub
	}

}
