package com.tracing.sample.ordermgr.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@JsonInclude(Include.NON_NULL)
public class Order {
    public Order() {
    }
    
  
	

	public int getOrderQuantity() {
		return orderQuantity;
	}
	public void setOrderQuantity(int orderQuantity) {
		this.orderQuantity = orderQuantity;
	}




	public String getSku() {
		return sku;
	}




	public void setSku(String sku) {
		this.sku = sku;
	}




	private String sku = null;
    private int orderQuantity = 0;
   

}
