
package com.eCommerce.dream.repository;

import com.eCommerce.dream.domain.Phones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonesRepository extends JpaRepository<Phones, Long>{
    
}
