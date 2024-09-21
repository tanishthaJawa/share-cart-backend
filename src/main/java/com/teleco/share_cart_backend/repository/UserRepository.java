package com.teleco.share_cart_backend.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teleco.share_cart_backend.models.Users;

@Repository
public interface UserRepository extends MongoRepository<Users,String> {
}
