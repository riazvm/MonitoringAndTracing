package com.tracing.sample.accountmgr.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonInclude(Include.NON_NULL)
public class Account {
    public Account() {
    }
    
    
    public String getAccountID() {
		return accountID;
	}
	public void setAccountID(String accountID) {
		this.accountID = accountID;
	}


	public String getAccountDescp() {
		return accountDescp;
	}


	public void setAccountDescp(String accountDescp) {
		this.accountDescp = accountDescp;
	}


	public String getSku() {
		return sku;
	}


	public void setSku(String sku) {
		this.sku = sku;
	}


	public int getOrderQuantity() {
		return orderQuantity;
	}


	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}


	private String accountID = null;
    private String accountDescp = null;
	private String sku = null;
    private int orderQuantity = 0;
   

}
