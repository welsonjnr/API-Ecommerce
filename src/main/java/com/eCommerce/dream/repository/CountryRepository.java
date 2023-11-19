
package com.eCommerce.dream.repository;

import com.eCommerce.dream.domain.Country;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, Long> {

    @Transactional
    Optional<Country> findByNameContaining(String name);
    
}
