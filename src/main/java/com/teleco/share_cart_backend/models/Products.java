package com.teleco.share_cart_backend.models;

import java.util.Objects;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "products")
@Data
public class Products {

    @Id
  
    private String id;

   
    private String productName;

   
    private String productCategory;
    
   
    private String productDesc;

   
    private int productQty;

    private String imageUrl;

    private double productPrice;

    
}


