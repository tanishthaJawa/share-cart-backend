package com.teleco.share_cart_backend.Services;

import com.teleco.share_cart_backend.models.Products;
import com.teleco.share_cart_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Products> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Products> getProductById(String id) {
        return productRepository.findById(id);
    }

    public Products addProduct(Products product) {
        return productRepository.save(product);
    }

    public Products updateProduct(String id, Products productDetails) {
        Products product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
        product.setProductName(productDetails.getProductName());
        product.setProductQty(productDetails.getProductQty());
        product.setProductCategory(productDetails.getProductCategory());
        product.setProductQty(productDetails.getProductQty());
        return productRepository.save(product);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public List<Products> getProductsByCategory(String productCategory) {
        return productRepository.findByProductCategory(productCategory);
    }
}
