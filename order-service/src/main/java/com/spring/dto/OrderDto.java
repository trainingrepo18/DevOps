package com.spring.dto;

public class OrderDto {
	
	private Integer orderId;
	private String orderName;
	private Integer qty;
	private Double price;
	
	private Integer paymentId;
	private String status;
	private String transactionId;
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
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
	public OrderDto(Integer orderId, String orderName, Integer qty, Double price, Integer paymentId, String status,
			String transactionId) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.qty = qty;
		this.price = price;
		this.paymentId = paymentId;
		this.status = status;
		this.transactionId = transactionId;
	}
	public OrderDto() {
		super();
	}
	
	
}
