
package com.eCommerce.dream.repository;

import com.eCommerce.dream.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovementRepository extends JpaRepository<Transaction, Long> {
    
}
