package com.eCommerce.dream.repository;

import com.eCommerce.dream.domain.Subcategories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubcategoriesRepository extends JpaRepository<Subcategories, Long> {
}
