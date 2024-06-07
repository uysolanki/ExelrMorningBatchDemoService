package com.excelr.DemoService.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.excelr.DemoService.entity.AmazonProducts;

@Repository
public interface AmazonProductRepository extends JpaRepository<AmazonProducts, Integer> {

}