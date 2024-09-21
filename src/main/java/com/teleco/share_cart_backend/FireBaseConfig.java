package com.teleco.share_cart_backend;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FireBaseConfig {
    @PostConstruct
    public void initialize() {
        try {
//            FileInputStream serviceAccount =
//                new FileInputStream("src/main/resources/firebase-service-account.json");

            //String firebaseCredentialsPath = System.getenv("FIREBASE_CREDENTIALS");
            FileInputStream serviceAccount = new FileInputStream("src/main/resources/config.json");
           // FileInputStream serviceAccount = new FileInputStream(firebaseCredentialsPath);
            FirebaseOptions options = new FirebaseOptions.Builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            FirebaseApp.initializeApp(options);
            System.out.println("Firebase has been initialized successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




