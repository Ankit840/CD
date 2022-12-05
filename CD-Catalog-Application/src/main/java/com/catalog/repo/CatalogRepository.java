package com.catalog.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.catalog.Entity.CatalogEntity;
@Repository
public interface CatalogRepository extends JpaRepository<CatalogEntity, Integer>{

}
