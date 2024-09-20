package com.teleco.share_cart_backend.Services;

import com.teleco.share_cart_backend.models.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public User updateUser(Long id, User user) {
        return new User();
    }

    public User createUser(User user) {
        return new User();
    }

    public List<User> getAllUsers() {
        return new ArrayList<>();
    }

    public User getUser(Long id) {
        return new User();
    }
}
