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
package com.products.sample.controller;


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
import com.products.sample.exception.ResourceNotFoundException;
import com.products.sample.model.Product;
import com.products.sample.repository.ProductRepository;
import com.products.sample.service.ProductService;

@RestController
@EnableAsync
@EnableCaching
@EnableScheduling
@SpringBootApplication
@ComponentScan({"com.products.sample"})
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST})
public class ProductAppController 
{

	@Autowired 
	ProductRepository productRepo;
	
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/products")
	 public List<Product> getAllProducts() {
        	 return productRepo.findAll();
	  }

	    @PostMapping("/products")
	    public Product createProduct(@Valid @RequestBody Product product) throws Exception {
	    	 //Product tmpProduct= productRepo.save(product);
	    	System.out.print("Hello");
	        //return productRepo.save(product);
	    	return productService.createProduct(product);
	    }

	    @GetMapping("/product/{id}")
	    public Product getProductById(@PathVariable(value = "id") Long productId) {
	        return productRepo.findById(productId)
	                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));
	    }

	    @PutMapping("/product/{id}")
	    public Product updateProduct(@PathVariable(value = "id") Long productId,
	                                           @Valid @RequestBody Product productDetails) {

	    	Product product = productRepo.findById(productId)
	                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

	        product.setProductDescription(productDetails.getProductDescription());
	        product.setProductName(productDetails.getProductName());

	        Product updatedProduct = productRepo.save(product);
	        return updatedProduct;
	    }

	    @DeleteMapping("/product/{id}")
	    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long productId) {
	        Product product = productRepo.findById(productId)
	                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", productId));

	        productRepo.delete(product);

	        return ResponseEntity.ok().build();
	    }
		
		
		
	}


	
