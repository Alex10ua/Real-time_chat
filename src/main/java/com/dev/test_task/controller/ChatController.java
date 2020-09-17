package com.dev.test_task.controller;

import com.dev.test_task.model.Message;
import com.dev.test_task.storage.UsersStorage;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    private static final Logger getLog= Logger.getLogger(ChatController.class);

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, Message message) {
        getLog.debug("handling send message: " + message + " to: " + to);
        boolean isExists = UsersStorage.getInstance().getUsers().contains(to); // check if a receiver user exists than send
        if (isExists) {
            simpMessagingTemplate.convertAndSend("/topic/messages/" + to, message);
        }
    }
}
