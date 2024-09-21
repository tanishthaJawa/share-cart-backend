package com.teleco.share_cart_backend.repository;

import java.util.List;

import com.teleco.share_cart_backend.models.Products;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teleco.share_cart_backend.models.CartDetails;

@Repository
public interface ProductRepository extends MongoRepository
<Products, String> {

//	List<CartDetails> findAllByCartId(Long cartId);cartId


	List<Products> findByProductCategory(String category);
}
