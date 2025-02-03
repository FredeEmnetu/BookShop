package com.example.BookShop;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.example.BookShop.mongo")
public interface BookRepo extends MongoRepository<Book, String> {
    // You don't need to define any methods here, as JpaRepository provides CRUD methods by default.
    // However, you can add custom query methods if needed.
    List<Book> findByTitle(String title);
    List<Book> findAll();
}
