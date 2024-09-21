package com.teleco.share_cart_backend.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teleco.share_cart_backend.models.Users;
import com.teleco.share_cart_backend.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepo;
    public Users updateUser(Long id, Users user) {
        return new Users();
    }

    public Users createUser(Users user) {
        return user;
    }

    public List<Users> getAllUsers() {
        return new ArrayList<>();
    }

    public Users getUser(Long id) {
        return new Users();
    }
}
