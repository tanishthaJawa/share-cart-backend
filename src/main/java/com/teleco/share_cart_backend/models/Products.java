package com.teleco.share_cart_backend.models;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "products")
public class Products {

    @Id
  
    private Long productId;

   
    private String productName;

   
    private String productCategory;
    
   
    private String productDesc;

   
    private int productQty;


    private double productPrice;

    // Getters and Setters

    

    public String getProductName() {
        return productName;
    }

    public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

	@Override
	public int hashCode() {
		return Objects.hash(productCategory, productDesc, productId, productName, productPrice, productQty);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Products other = (Products) obj;
		return Objects.equals(productCategory, other.productCategory) && Objects.equals(productDesc, other.productDesc)
				&& Objects.equals(productId, other.productId) && Objects.equals(productName, other.productName)
				&& Double.doubleToLongBits(productPrice) == Double.doubleToLongBits(other.productPrice)
				&& productQty == other.productQty;
	}

	public Products(Long productId, String productName, String productCategory, String productDesc, int productQty,
			double productPrice) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productCategory = productCategory;
		this.productDesc = productDesc;
		this.productQty = productQty;
		this.productPrice = productPrice;
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Products [productId=" + productId + ", productName=" + productName + ", productCategory="
				+ productCategory + ", productDesc=" + productDesc + ", productQty=" + productQty + ", productPrice="
				+ productPrice + "]";
	}
    
}
