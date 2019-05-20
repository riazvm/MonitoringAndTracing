package com.products.pricing.sample.repository;

import com.products.pricing.sample.model.ProductPricing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PricingRepository extends JpaRepository<ProductPricing, Long> {

}

