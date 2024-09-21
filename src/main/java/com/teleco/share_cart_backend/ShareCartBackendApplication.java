package com.teleco.share_cart_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class ShareCartBackendApplication {

	public static void main(String[] args) {
		//@Bean
	/*	public MongoTemplate mongoTemplate() {
			return new MongoTemplate(new SimpleMongoClientDbFactory("mongodb://<username>:<password>@localhost:27017/yourDatabase"));
		}*/
		SpringApplication.run(ShareCartBackendApplication.class, args);
	}

}
