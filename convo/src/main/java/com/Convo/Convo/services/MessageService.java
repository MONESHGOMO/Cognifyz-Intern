package com.Convo.Convo.services;


import com.Convo.Convo.data_encryption.EncryptionUtil;
import com.Convo.Convo.models.ChatMessage;
import com.Convo.Convo.repositorys.ChatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class MessageService {

    private static final Logger logger = LoggerFactory.getLogger(MessageService.class);

    @Autowired
    ChatRepository chatRepository;

    @Autowired
    private EncryptionUtil encryptionUtil;

    public void addDataIntoDataBase(ChatMessage chatMessage) {
        logger.info("Received message from sender: {}", chatMessage.getSender());

        try {
            ChatMessage encryptedData = new ChatMessage();
            encryptedData.setSender(chatMessage.getSender());
            encryptedData.setContent(encryptionUtil.encrypt(chatMessage.getContent()));
            encryptedData.setTimeStamp(LocalDateTime.now());

            chatRepository.save(encryptedData);

            logger.info("Message successfully encrypted and saved for sender: {}", chatMessage.getSender());
        } catch (Exception e) {
            logger.error("Error while processing message from sender: {}", chatMessage.getSender(), e);
        }
    }
}