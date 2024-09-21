package com.teleco.share_cart_backend.Services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teleco.share_cart_backend.models.Cart;
import com.teleco.share_cart_backend.models.CartDetails;
import com.teleco.share_cart_backend.models.Users;
import com.teleco.share_cart_backend.repository.CartDetailsRepo;
import com.teleco.share_cart_backend.repository.CartRepository;
import com.teleco.share_cart_backend.repository.UserRepository;


@Service
public class CartService {
	
    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
    private CartDetailsRepo cartDetailsRepository;

    @Autowired
    private UserRepository userRepository;

   // @Autowired
    //QrCodeService qrCodeService;

    public Cart getCartById(Long id) {
        return cartRepository.findById(id).orElseThrow(() -> new RuntimeException("Cart not found"));
    }
    // Create a new cart for the primary user
    public Cart createCart(Long userId) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Cart cart = new Cart();
//        cart.setPrimaryAccountHolder(user);
//        cart.setSharedWithUsers(null); // No users initially
        return cartRepository.save(cart);
    }

    // Add users to share the cart with
    public Cart shareCart(Long cartId, List<Long> userIds) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        List<Users> users = userRepository.findAllById(userIds);
//        cart.setSharedWithUsers(users);
//        cart.setShared(true);
        return cartRepository.save(cart);
    }

    // Get carts shared with a specific user
//    public List<Cart> getSharedCarts(Long userId) {
//        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
//        return user.getSharedCarts();
//    }

    // Add items to the cart
//    public Cart addItemToCart(Long cartId, CartDetails item) {
//        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
//        cart.getItems().add(item);
//        return cartRepository.save(cart);
//    }

    // Remove item from the cart
//    public CartDetails removeItemFromCart(Long cartId, Long itemId) {
//        List<CartDetails> cartDetails =  cartDetailsRepository.findAllByCartId(cartId);
//        for(CartDetails cart:cartDetails)
//        {
//        	cart.getProduct().removeIf
//        }
//        return cartDetailsRepository.save(cart);
//    }

    public static String generateUniqueLink(Long cartId) {
        String uniqueToken = UUID.randomUUID().toString(); // Generates a unique identifier
        String baseUrl = "https://yourapp.com/cart"; // The base URL for your cart
        return baseUrl + "/" + cartId + "?token=" + uniqueToken;
    }

}
