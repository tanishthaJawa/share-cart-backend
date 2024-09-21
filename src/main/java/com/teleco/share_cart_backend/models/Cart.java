package com.teleco.share_cart_backend.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "cart")
@Data
public class Cart {

    @Id
    private String id;

    @DBRef
    private Users user;

   
    private double price;

    // Getters and Setters
}