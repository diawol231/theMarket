package ru.market.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.market.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {
}
