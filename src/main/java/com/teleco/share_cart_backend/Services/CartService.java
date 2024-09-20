package com.teleco.share_cart_backend.Services;

import com.teleco.share_cart_backend.models.Cart;
import com.teleco.share_cart_backend.repository.CartRepository;
import com.teleco.share_cart_backend.models.CartItem;
import com.teleco.share_cart_backend.models.User;
import com.teleco.share_cart_backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.UUID;


@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserRepository userRepository;

   // @Autowired
    //QrCodeService qrCodeService;

    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart not found"));
    }
    // Create a new cart for the primary user
    public Cart createCart(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Cart cart = new Cart();
        cart.setPrimaryAccountHolder(user);
        cart.setSharedWithUsers(null); // No users initially
        return cartRepository.save(cart);
    }

    // Add users to share the cart with
    public Cart shareCart(Long cartId, List<Long> userIds) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        List<User> users = userRepository.findAllById(userIds);
        cart.setSharedWithUsers(users);
        cart.setShared(true);
        return cartRepository.save(cart);
    }

    // Get carts shared with a specific user
    public List<Cart> getSharedCarts(Long userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getSharedCarts();
    }

    // Add items to the cart
    public Cart addItemToCart(Long cartId, CartItem item) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    // Remove item from the cart
    public Cart removeItemFromCart(Long cartId, Long itemId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        cart.getItems ().removeIf(item -> item.getId().equals(itemId));
        return cartRepository.save(cart);
    }

    public static String generateUniqueLink(Long cartId) {
        String uniqueToken = UUID.randomUUID().toString(); // Generates a unique identifier
        String baseUrl = "https://yourapp.com/cart"; // The base URL for your cart
        return baseUrl + "/" + cartId + "?token=" + uniqueToken;
    }

}
