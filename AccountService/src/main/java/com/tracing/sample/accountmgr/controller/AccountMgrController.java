package com.tracing.sample.accountmgr.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tracing.sample.accountmgr.model.Account;
import com.tracing.sample.accountmgr.model.Order;

@RestController
public class AccountMgrController {
	
	  @Autowired
	  private RestTemplate restTemplate;
	  

	  private static String orderMgrUrl = System.getProperty("ORDERMGR_URL", System.getenv("ORDERMGR_URL"));

	@GetMapping("/orders")
    public String orders() throws InterruptedException {
		
		Thread.sleep(1 + (long)(Math.random()*600));
        if (Math.random() > 0.9) {
            throw new RuntimeException("Failed to find account");
        }
		ResponseEntity<String> response = restTemplate.getForEntity(orderMgrUrl + "/orders", String.class);
        return "" + response.getBody();
    }
	@PostMapping("/createorder")
    public ResponseEntity<Order> createorder(@Valid @RequestBody Account account) throws Exception {
    	 //Product tmpProduct= productRepo.save(product);
		Thread.sleep(1 + (long)(Math.random()*600));
		Order orderObj= new Order(); 
        orderObj.setOrderQuantity(account.getOrderQuantity());
        orderObj.setSku(account.getSku());
        ResponseEntity<Order> response = restTemplate.postForEntity(orderMgrUrl+"/createorder", orderObj, Order.class);
    	return response;
        
    }
	 @RequestMapping("/failaccount")
	    public String failaccount() throws InterruptedException {
		 throw new RuntimeException("No Such Method");
	 }
	
    @RequestMapping("/health")
    public String getHealth() throws InterruptedException {
        return "Ok";
    }

}
