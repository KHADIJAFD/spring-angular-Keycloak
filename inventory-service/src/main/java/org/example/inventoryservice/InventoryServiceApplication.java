package org.example.inventoryservice;

import org.example.inventoryservice.entities.Product;
import org.example.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            productRepository.save(Product
                    .builder()
                            .id(UUID.randomUUID().toString())
                            .name("lenovo")
                            .price(4000)
                            .quantity(8)
                    .build());
            productRepository.save(Product
                    .builder()
                            .id(UUID.randomUUID().toString())
                            .name("Dell")
                            .price(5000)
                            .quantity(9)
                    .build());
            productRepository.save(Product
                    .builder()
                            .id(UUID.randomUUID().toString())
                            .name("Mac")
                            .price(8000)
                            .quantity(4)
                    .build());
        };
    }
}
