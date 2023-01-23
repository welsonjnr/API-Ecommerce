
package com.eCommerce.dream.repository;

import com.eCommerce.dream.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

    @Transactional
    List<Sale> findByClientContaining(String name);
    
}
