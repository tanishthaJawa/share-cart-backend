//package com.teleco.share_cart_backend.Services;
//
//import com.teleco.share_cart_backend.models.Products;
//import com.teleco.share_cart_backend.repository.ProductRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class ProductService {
//
//    @Autowired
//    private ProductRepository productRepository;
//
//    public List<Products> getAllProducts() {
//        return productRepository.findAll();
//    }
//
//    public Optional<Products> getProductById(Long id) {
//        return productRepository.findById(id);
//    }
//
//    public Products addProduct(Products product) {
//        return productRepository.save(product);
//    }
//
//    public Products updateProduct(Long id, Products productDetails) {
//        Products product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
//        product.setProductName(productDetails.getProductName());
//        product.setPrice(productDetails.getPrice());
//        product.setCategory(productDetails.getCategory());
//        product.setQuantity(productDetails.getQuantity());
//        product.setImage_url(productDetails.getImage_url());
//        return productRepository.save(product);
//    }
//
//    public void deleteProduct(Long id) {
//        productRepository.deleteById(id);
//    }
//
//    public List<Products> getProductsByCategory(String category) {
//        return productRepository.findByCategory(category);
//    }
//}
