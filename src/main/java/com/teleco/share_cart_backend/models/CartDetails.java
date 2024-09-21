package com.teleco.share_cart_backend.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;



// CartItem.java




@Document(collection = "cart_details")
@Getter
@Setter
public class CartDetails {

    @Id
   
    private String id;

    @DBRef
    private Cart cart;

    @DBRef
    private Products product;

   
    private int productQty;

    // Getters and Setters


}

