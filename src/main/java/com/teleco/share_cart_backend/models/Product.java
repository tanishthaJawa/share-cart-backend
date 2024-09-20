package com.teleco.share_cart_backend.models;

// CartItem.java


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String productName;
    private int quantity;
    private double price;

    @Column
    private String category;
    @Column
    private String image_url;


    // Getters and Setters
}
