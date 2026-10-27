package com.spring.dto;

public class Payment {
	private Integer paymentId;
	private String status;
	private String transactionId;
	public Integer getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(Integer paymentId) {
		this.paymentId = paymentId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public Payment(Integer paymentId, String status, String transactionId) {
		super();
		this.paymentId = paymentId;
		this.status = status;
		this.transactionId = transactionId;
	}
	public Payment() {
		super();
	}
	
}
