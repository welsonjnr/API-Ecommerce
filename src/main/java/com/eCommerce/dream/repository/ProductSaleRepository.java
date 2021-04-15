package com.eCommerce.dream.repository;

import com.eCommerce.dream.domain.ProductSale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSaleRepository extends JpaRepository<ProductSale, Long> {
}
