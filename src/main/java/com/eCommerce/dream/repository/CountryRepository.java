
package com.eCommerce.dream.repository;

import com.eCommerce.dream.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
    
}
