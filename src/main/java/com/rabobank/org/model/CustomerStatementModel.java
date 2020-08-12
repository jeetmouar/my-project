/*
 *  @Author Amarjeet
 */
package com.rabobank.org.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * The Class CustomerStatementModel.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "Reference", "AccountNumber", "Description", "Start Balance", "Mutation", "End Balance" })
public class CustomerStatementModel {

	/** The reference. */
	@JsonProperty("Reference")
	private Long reference;
	
	/** The account number. */
	@JsonProperty("AccountNumber")
	private String accountNumber;
	
	/** The description. */
	@JsonProperty("Description")
	private String description;
	
	/** The start balance. */
	@JsonProperty("Start Balance")
	private Float startBalance;
	
	/** The mutation. */
	@JsonProperty("Mutation")
	private Float mutation;
	
	/** The end balance. */
	@JsonProperty("End Balance")
	private Float endBalance;
	
	/** The additional properties. */
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * Gets the reference.
	 *
	 * @return the reference
	 */
	@JsonProperty("Reference")
	public Long getReference() {
		return reference;
	}

	/**
	 * Sets the reference.
	 *
	 * @param reference the new reference
	 */
	@JsonProperty("Reference")
	public void setReference(Long reference) {
		this.reference = reference;
	}

	/**
	 * Gets the account number.
	 *
	 * @return the account number
	 */
	@JsonProperty("AccountNumber")
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * Sets the account number.
	 *
	 * @param accountNumber the new account number
	 */
	@JsonProperty("AccountNumber")
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	@JsonProperty("Description")
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	@JsonProperty("Description")
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the start balance.
	 *
	 * @return the start balance
	 */
	@JsonProperty("Start Balance")
	public Float getStartBalance() {
		return startBalance;
	}

	/**
	 * Sets the start balance.
	 *
	 * @param startBalance the new start balance
	 */
	@JsonProperty("Start Balance")
	public void setStartBalance(Float startBalance) {
		this.startBalance = startBalance;
	}

	/**
	 * Gets the mutation.
	 *
	 * @return the mutation
	 */
	@JsonProperty("Mutation")
	public Float getMutation() {
		return mutation;
	}

	/**
	 * Sets the mutation.
	 *
	 * @param mutation the new mutation
	 */
	@JsonProperty("Mutation")
	public void setMutation(Float mutation) {
		this.mutation = mutation;
	}

	/**
	 * Gets the end balance.
	 *
	 * @return the end balance
	 */
	@JsonProperty("End Balance")
	public Float getEndBalance() {
		return endBalance;
	}

	/**
	 * Sets the end balance.
	 *
	 * @param endBalance the new end balance
	 */
	@JsonProperty("End Balance")
	public void setEndBalance(Float endBalance) {
		this.endBalance = endBalance;
	}

	/**
	 * Gets the additional properties.
	 *
	 * @return the additional properties
	 */
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	/**
	 * Sets the additional property.
	 *
	 * @param name the name
	 * @param value the value
	 */
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
