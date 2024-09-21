package com.teleco.share_cart_backend.Services;

import com.teleco.share_cart_backend.models.User;
import com.teleco.share_cart_backend.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserService {
        @Autowired
        private UserRepository userRepository;

        public UserService() {
            log.info("Initializing User Service");
        }

        public User createUser(User user) {
            return userRepository.save(user);
        }

        public void deleteUser(Long id) {
            Optional<User> user = userRepository.findById(id);
            user.ifPresent(userRepository::delete);
        }

        public User getUser(Long id) {
            Optional<User> user = userRepository.findById(id);
            return user.orElseThrow(() -> new RuntimeException("User doesn't exist"));
        }

        public User getUser(String email) {
            Optional<User> user = userRepository.findByEmail(email);
            return user.orElseThrow(() -> new RuntimeException("User doesn't exist"));
        }

        public List<User> getAllUsers() {
            return userRepository.findAll();
        }

    public List<User> getUsersByUserIds(List<Long> userIds) {
        return userRepository.findAllById(userIds);
    }

        public User updateUser(Long id,User user) {
            return userRepository.save(user);
        }
}
