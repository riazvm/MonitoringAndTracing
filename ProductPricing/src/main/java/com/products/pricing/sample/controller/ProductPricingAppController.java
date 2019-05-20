/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.products.pricing.sample.controller;


import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import com.products.pricing.sample.model.ProductPricing;
import com.products.pricing.sample.repository.PricingRepository;
import com.products.pricing.sample.exception.ResourceNotFoundException;


@RestController
@EnableAsync
@EnableCaching
@EnableScheduling
@SpringBootApplication
@ComponentScan({"com.products.pricing.sample"})
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public class ProductPricingAppController 
{

	@Autowired 
	PricingRepository pricingRepo;
	
	@GetMapping("/productpricing")
	 public List<ProductPricing> getAllPricing() {
	        return pricingRepo.findAll();
	  }

	    @PostMapping("/productpricing")
	    public  ProductPricing createProduct(@Valid @RequestBody ProductPricing pricing) throws InterruptedException {
	    	
	    	Thread.sleep(1 + (long)(Math.random()*500));
	        if (Math.random() > 0.8) {
	            throw new RuntimeException("Failed to Insert Pricing");
	        }
	        return pricingRepo.save(pricing);
	    }

	    @GetMapping("/productpricing/{id}")
	    public ProductPricing getProductById(@PathVariable(value = "id") Long productId) {
	        return pricingRepo.findById(productId)
	                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
	    }

	    @PutMapping("/productpricing/{id}")
	    public ProductPricing updateProduct(@PathVariable(value = "id") Long productId,
	                                           @Valid @RequestBody ProductPricing pricingDetails) {

	    	ProductPricing pricing = pricingRepo.findById(productId)
	                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

	    	pricing.setLicenseFee(pricingDetails.getLicenseFee());
	        pricing.setSupportFee(pricingDetails.getSupportFee());
	        pricing.setTier(pricingDetails.getTier());

	        ProductPricing updatedPricing = pricingRepo.save(pricing);
	        return updatedPricing;
	    }

	    @DeleteMapping("/productpricing/{id}")
	    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long productId) {
	    	ProductPricing pricing = pricingRepo.findById(productId)
	                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

	    	pricingRepo.delete(pricing);

	        return ResponseEntity.ok().build();
	    }
		
		
		
	}


	
