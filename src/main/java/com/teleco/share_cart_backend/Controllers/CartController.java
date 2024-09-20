package com.teleco.share_cart_backend.Controllers;

import com.google.zxing.WriterException;
import com.teleco.share_cart_backend.models.Cart;
import com.teleco.share_cart_backend.Services.CartService;
import com.teleco.share_cart_backend.Services.QrCodeService;
import com.teleco.share_cart_backend.models.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(path ="api/carts")
@CrossOrigin(origins ="*")
@Slf4j
public class CartController {

    @Autowired
    private QrCodeService qrCodeService;

    @Autowired
    private CartService cartService;

    @GetMapping("/{id}")
    public ResponseEntity<Cart> getSharedCart(@PathVariable Long id, @RequestParam String token) {
        Cart cart = cartService.getCartById(id);
        if (!cart.getShareToken().equals(token)) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }
        return ResponseEntity.ok(cart);
    }


    @PostMapping("/create/{userId}")
    public ResponseEntity<Cart> createCart(@PathVariable Long userId) {
        Cart cart = cartService.createCart(userId);
        return ResponseEntity.ok(cart);
    }

    // Share a cart with QR code with other users
    @PostMapping("/share/{cartId}")
    public ResponseEntity<byte[]> shareCart(@PathVariable Long cartId, @RequestBody List<Long> userIds ) {
        // Share the cart with the specified users
        Cart cart = cartService.shareCart(cartId, userIds);

        // Generate the unique link for the shared cart
        String uniqueLink = CartService.generateUniqueLink(cart.getId());

        // Generate the QR code and return it as a byte array (PNG format)
        try {
            byte[] qrCodeImage = qrCodeService.generateQrCode(uniqueLink, 350, 350);

            // Return the QR code as a PNG image in the response
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.IMAGE_PNG);

            return ResponseEntity.ok()
                    .headers(headers)
                    .body(qrCodeImage);

        }
        catch (WriterException | IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }


    // Get carts shared with a user
    @GetMapping("/shared/{userId}")
    public ResponseEntity<List<Cart>> getSharedCarts(@PathVariable Long userId) {
        List<Cart> carts = cartService.getSharedCarts(userId);
        return ResponseEntity.ok(carts);
    }

    // Add an item to a cart
    @PostMapping("/add-item/{cartId}")
    public ResponseEntity<Cart> addItemToCart(@PathVariable Long cartId, @RequestBody Product item) {
        Cart cart = cartService.addItemToCart(cartId, item);
        return ResponseEntity.ok(cart);
    }

    // Remove an item from a cart
    @DeleteMapping("/remove-item/{cartId}/{itemId}")
    public ResponseEntity<Cart> removeItemFromCart(@PathVariable Long cartId, @PathVariable Long itemId) {
        Cart cart = cartService.removeItemFromCart(cartId, itemId);
        return ResponseEntity.ok(cart);
    }



}
