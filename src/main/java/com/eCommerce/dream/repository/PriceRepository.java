
package com.eCommerce.dream.repository;

import com.eCommerce.dream.domain.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long>{
    
}
