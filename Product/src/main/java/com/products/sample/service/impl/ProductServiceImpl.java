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
package com.products.sample.service.impl;



import com.products.sample.model.Product;
import com.products.sample.model.ProductPricing;
import com.products.sample.repository.ProductRepository;
import com.products.sample.service.ProductService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;



@Service

public class ProductServiceImpl implements ProductService {


	private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired 
	ProductRepository productRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	private static String pricingURL = System.getProperty("PRICING_URL", System.getenv("PRICING_URL"));
	
	@Override
	public Product createProduct(Product product) throws Exception {
		System.out.println("Hello");
		Product tmpProduct=productRepo.save(product);
		ProductPricing pricing = new ProductPricing();
		pricing.setProductID(tmpProduct.getProductID());
		pricing.setLicenseFee(tmpProduct.getLicenseFee());
		pricing.setSupportFee(tmpProduct.getSupportFee());
		pricing.setTier(tmpProduct.getTier());
	
		ResponseEntity<String> result = restTemplate.postForEntity("http://localhost:9090"+"/productpricing", pricing, String.class);
		System.out.print("------helooooo--------"+result);
		// TODO Auto-generated method stub
		return tmpProduct;
	}

	
	

}

