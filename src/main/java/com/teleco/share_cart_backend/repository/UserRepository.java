package com.teleco.share_cart_backend.repository;

import com.teleco.share_cart_backend.models.Products;
import org.apache.catalina.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.teleco.share_cart_backend.models.Users;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<Users,String> {
    Optional<Users> findByEmail(String email);
}
