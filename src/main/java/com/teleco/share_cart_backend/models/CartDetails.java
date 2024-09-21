package com.teleco.share_cart_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



// CartItem.java




@Document(collection = "cart_details")
public class CartDetails {

    @Id
   
    private Long cartDetailsId;

    @DBRef
    private Cart cart;

    @DBRef
    private Products product;

   
    private int productQty;

    // Getters and Setters

    public Long getCartDetailsId() {
        return cartDetailsId;
    }

    public void setCartDetailsId(Long cartDetailsId) {
        this.cartDetailsId = cartDetailsId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Products getProduct() {
        return product;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }
}

