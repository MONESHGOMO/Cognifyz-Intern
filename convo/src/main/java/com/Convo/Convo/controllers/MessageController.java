package com.Convo.Convo.controllers;


import com.Convo.Convo.models.ChatMessage;
import com.Convo.Convo.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;


    @MessageMapping("/sendMessage")
    @SendTo("/topic/message")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        System.out.println("Received message from: " + chatMessage.getSender());
        messageService.addDataIntoDataBase(chatMessage);
        return chatMessage;
    }


    @GetMapping("/chat")
    public String chat(){
        return "index";
    }
}