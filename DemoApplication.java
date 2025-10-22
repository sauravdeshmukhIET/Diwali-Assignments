package com.example.demo;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner dataLoader(CategoryRepository categoryRepository, ProductRepository productRepository) {
        return args -> {
            Category electronics = new Category();
            electronics.setName("Electronics");
            categoryRepository.save(electronics);

            Product p1 = new Product();
            p1.setName("Phone");
            p1.setPrice(500);
            p1.setCategory(electronics);

            Product p2 = new Product();
            p2.setName("Laptop");
            p2.setPrice(1200);
            p2.setCategory(electronics);

            productRepository.save(p1);
            productRepository.save(p2);
        };
    }
}
