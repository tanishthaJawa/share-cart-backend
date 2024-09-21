package com.teleco.share_cart_backend.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class LoginDto {
    public  String email;
    public String password;
}
