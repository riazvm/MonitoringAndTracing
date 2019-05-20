package com.products.sample.service;

import com.products.sample.model.Product;


import java.io.IOException;

public interface ProductService {
    /**
     * Generate QR Code
     *
     * @param Product
     *
     * @return String
  */

    Product createProduct(Product product) throws Exception;
}