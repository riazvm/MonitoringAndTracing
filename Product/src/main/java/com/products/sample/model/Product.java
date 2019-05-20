package com.products.sample.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
@Table(name = "productmaster")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(allowGetters = true)
@JsonInclude(Include.NON_NULL)
public class Product {
    public Product() {
    }
    @Id
    @GeneratedValue
    private Long productID = null;
    private String productVersion = null;
    private String productName = null;
    private String productDescription = null;
    @Transient
    private Long licenseFee = null;
    @Transient
    private Long supportFee = null;
    @Transient
    private String tier = null;
  
    @Override
    public String toString() {
        return "ProductID:"+productID;
    }

    /**
     * Constructor for mapping a user to a CardHolder Object
     * @param merchant
     */
    public Product(Product product){
        this.setProductID(product.getProductID());
        this.setProductName(product.getProductDescription());
        this.setProductDescription(product.getProductDescription());
       

    }

	public Long getProductID() {
		return productID;
	}

	public void setProductID(Long productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductVersion() {
		return productVersion;
	}

	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
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
