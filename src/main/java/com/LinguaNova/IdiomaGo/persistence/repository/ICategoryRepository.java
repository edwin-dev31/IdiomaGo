package com.LinguaNova.IdiomaGo.persistence.repository;

import com.LinguaNova.IdiomaGo.persistence.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Boolean existsByName(String name);
}
