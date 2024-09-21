package com.teleco.share_cart_backend.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;




@Document(collection = "guest_user")
public class GuestUsers {

    @Id
   
    private Long guestId;

    private String contactNo;

 
    private String email;

    @DBRef
    private Users primaryAccountHolder;

    // Getters and Setters

    public Long getGuestId() {
        return guestId;
    }

    public void setGuestId(Long guestId) {
        this.guestId = guestId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Users getPrimaryAccountHolder() {
        return primaryAccountHolder;
    }

    public void setPrimaryAccountHolder(Users primaryAccountHolder) {
        this.primaryAccountHolder = primaryAccountHolder;
    }
}