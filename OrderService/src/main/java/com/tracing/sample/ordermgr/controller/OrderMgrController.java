package com.tracing.sample.ordermgr.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tracing.sample.ordermgr.model.Order;

import io.opentracing.Tracer;

@RestController
public class OrderMgrController {

    @Autowired
    private RestTemplate restTemplate;

  
    //@Autowired
    //private Tracer tracer;

    @GetMapping("/orders")
    public String orders() throws InterruptedException {
   
        Thread.sleep(1 + (long)(Math.random()*600));
        if (Math.random() > 0.9) {
            throw new RuntimeException("Failed to find order");
        }
           
           return "Get orders successful";
      
    }
    
    @PostMapping("/createorder")
    public ResponseEntity<Order> createorder(@Valid @RequestBody Order order) throws Exception {
    	 //Product tmpProduct= productRepo.save(product);
		Thread.sleep(1 + (long)(Math.random()*600));
		
    	return ResponseEntity.accepted().body(order);
        
    }

    
 
    @RequestMapping("/health")
    public String getHealth() throws InterruptedException {
        return "Ok";
    }

}
