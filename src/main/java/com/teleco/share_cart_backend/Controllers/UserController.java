package com.teleco.share_cart_backend.Controllers;


import com.teleco.share_cart_backend.models.Users;
import com.teleco.share_cart_backend.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path ="api/user")
@CrossOrigin(origins ="*")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("signUp")
    public Users createUser(@RequestBody Users user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Long id, @RequestBody Users user) {
        return userService.updateUser(id, user);
    }

    @GetMapping
    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }
}

