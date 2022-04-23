package edu.store.repository;

import edu.store.entity.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProductTypeRepository extends JpaRepository<ProductType, Long> {
    @Query("SELECT p FROM ProductType p where LOWER(p.name) = :name")
    ProductType findByName(@Param("name") String name);
}
