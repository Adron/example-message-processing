package com.messages.demo;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String processMessage(TextMessage message) {
        // Business logic goes here
        return "Hi, thanks for your message.";
    }
}


