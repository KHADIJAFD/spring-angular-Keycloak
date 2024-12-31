package org.example.inventoryservice.web;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.example.inventoryservice.entities.Product;
import org.example.inventoryservice.repository.ProductRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")

public class ProductRestController {
    ProductRepository productRepository;
    ProductRestController (ProductRepository productRepository){
        this.productRepository=productRepository;
    }
    @GetMapping("/products")
    @PreAuthorize("hasAuthority('ADMIN')")
    List<Product> productList(){
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    @PreAuthorize("hasAuthority('USER')")
    Product getProductById(@PathVariable String id){
        return productRepository.findById(id).get();
    }
    @GetMapping("/auth")
    Authentication authentication(Authentication authentication){
        return authentication;
    }
}
