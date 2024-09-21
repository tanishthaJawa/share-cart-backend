package com.teleco.share_cart_backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teleco.share_cart_backend.models.CartDetails;

@Repository
public interface CartDetailsRepo extends MongoRepository
<CartDetails, Integer> {

	List<CartDetails> findAllByCartId(Long cartId);



}
