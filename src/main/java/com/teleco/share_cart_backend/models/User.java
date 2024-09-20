package com.teleco.share_cart_backend.models;

import com.teleco.share_cart_backend.models.Cart;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Table(name ="users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String username;
    @Column
    private String role; // PRIMARY or SECONDARY

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String address;

    @OneToMany(mappedBy = "primaryAccountHolder")
    private List<Cart> carts;

    @ManyToMany(mappedBy = "sharedWithUsers")
    private List<Cart> sharedCarts;

    // Getters and Setters
}
