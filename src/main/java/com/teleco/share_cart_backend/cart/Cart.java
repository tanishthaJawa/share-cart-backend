package com.teleco.share_cart_backend.cart;

import com.teleco.share_cart_backend.user.User;
import jakarta.persistence.*;
import lombok.Data;
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
    @Column
    private String phonePlan;
    @Column
    private boolean isUpgrade;

    @ManyToOne
    private User primaryAccountHolder;

    @ManyToMany
    @JoinTable(
            name = "cart_shared_with",
            joinColumns = @JoinColumn(name = "cart_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> sharedWithUsers;

    // Getters and Setters
}
