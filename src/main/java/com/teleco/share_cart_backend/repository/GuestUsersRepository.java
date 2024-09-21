package com.teleco.share_cart_backend.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.teleco.share_cart_backend.models.GuestUsers;

public interface GuestUsersRepository extends MongoRepository<GuestUsersRepository, String> {

	
	List<GuestUsers> findAllByUserId(String id);

}
