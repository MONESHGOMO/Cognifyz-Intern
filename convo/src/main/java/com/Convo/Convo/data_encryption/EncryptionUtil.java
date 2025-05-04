package com.Convo.Convo.data_encryption;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.stereotype.Component;

@Component
public class EncryptionUtil {

    @Value("${ENCRYPTION_SECRET_KEY}")
    private String SECRET_KEY;

    @Value("${ENCRYPTION_SALT}")
    private String SALT;

    private TextEncryptor textEncryptor;


    @PostConstruct
    public void init(){
        textEncryptor= Encryptors.text(SECRET_KEY,SALT);
    }

    public String encrypt(String message) {
        return textEncryptor.encrypt(message);
    }

    public String decrypt(String encryptedMessage) {
        return textEncryptor.decrypt(encryptedMessage);
    }
}