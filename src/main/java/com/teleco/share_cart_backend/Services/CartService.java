package com.teleco.share_cart_backend.Services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.teleco.share_cart_backend.models.Cart;
import com.teleco.share_cart_backend.models.CartDetails;
import com.teleco.share_cart_backend.models.Users;
import com.teleco.share_cart_backend.repository.CartDetailsRepo;
import com.teleco.share_cart_backend.repository.CartRepository;
import com.teleco.share_cart_backend.repository.GuestUsersRepository;
import com.teleco.share_cart_backend.repository.UserRepository;


@Service
public class CartService {
	
    @Autowired
    private CartRepository cartRepository;
    
    @Autowired
	UserRepository userRepo;
    
    
    
    @Autowired
    private CartDetailsRepo cartDetailsRepository;

    @Autowired
    private UserRepository userRepository;
    @Autowired 
    private GuestUsersRepository guestUserRepository;
    

   // @Autowired
    //QrCodeService qrCodeService;

    public List<CartDetails> getCartById(String id) {
        return cartDetailsRepository.findAllByCartId(id);
    }
    // Create a new cart for the primary user
    public Cart createCart(String userId) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Cart cart = new Cart();
//        cart.setPrimaryAccountHolder(user);
//        cart.setSharedWithUsers(null); // No users initially
        return cartRepository.save(cart);
    }

    // Add users to share the cart with
    public Cart shareCart(String cartId) {
    	 Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
    	 return cart;
    }

    // Get carts shared with a specific user
//    public List<Cart> getSharedCarts(Long userId) {
//        Users user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
//        return user.getSharedCarts();
//    }

     //Add items to the cart
    public CartDetails addItemToCart(String cartId,CartDetails item) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found"));
        if(cartRepository.existsById(cartId)) {
        	return cartDetailsRepository.save(item);
        }
        return null;
    }

     //Remove item from the cart
    public List<CartDetails> removeItemFromCart(String cartId, String itemId) {
        List<CartDetails> cartDetails =  cartDetailsRepository.findAllByCartId(cartId);
        
        	cartDetails.removeIf(cart->cart.getProduct().getId().equals(itemId));
        
        return cartDetailsRepository.saveAll(cartDetails);
    }

    public static String generateUniqueLink(String cartId) {
        String uniqueToken = UUID.randomUUID().toString(); // Generates a unique identifier
        String baseUrl = "https://yourapp.com/cart"; // The base URL for your cart
        return baseUrl + "/" + cartId ;
    }

}
