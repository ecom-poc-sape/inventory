package com.sapient.inventory.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sapient.inventory.domain.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

}
