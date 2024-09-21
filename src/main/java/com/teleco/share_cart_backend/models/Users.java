package com.teleco.share_cart_backend.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "users")
@Getter
@Setter
public class Users {

    @Id
    
    private String id;

    
    private String userName;

  
    private String contactNo;

    
    private String email;
    
    
    private String address;

    // Getters and Setters
}