package com.teleco.share_cart_backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.List;

@Entity
@Table(name ="cart")
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String device;

    private boolean isShared;

    @Column
    private String phonePlan;
    @Column
    private boolean isUpgrade;

    @ManyToOne
    private User primaryAccountHolder;

    private String shareToken; // Unique token for sharing the cart


    @ManyToMany
    @JoinTable(
            name = "cart_shared_with",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> sharedWithUsers;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "cart_id")
    private List<Product> productList;

    // Getters and Setters
}
