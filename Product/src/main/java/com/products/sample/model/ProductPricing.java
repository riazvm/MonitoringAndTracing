package com.products.sample.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.Id;


@Entity
@Table(name = "productpricing")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
@JsonInclude(Include.NON_NULL)
public class ProductPricing {
    public ProductPricing() {
    }
    @Id
    private Long productID = null;
    private Long licenseFee = null;
    private Long supportFee = null;
    private String tier = null;

  
    
  

    @Override
    public String toString() {
        return "ProductID:"+productID;
    }

    /**
     * Constructor for mapping a user to a CardHolder Object
     * @param merchant
     */
    public ProductPricing(ProductPricing productPricing){
        this.setProductID(productPricing.getProductID());
        this.setLicenseFee(productPricing.getLicenseFee());
        this.setSupportFee(productPricing.getSupportFee());
        this.setTier(productPricing.getTier());
        
       

    }

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public Long getLicenseFee() {
		return licenseFee;
	}

	public void setLicenseFee(Long licenseFee) {
		this.licenseFee = licenseFee;
	}

	public Long getSupportFee() {
		return supportFee;
	}

	public void setSupportFee(Long supportFee) {
		this.supportFee = supportFee;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}


}
