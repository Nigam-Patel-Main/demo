package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
	
	@Autowired
	SimpMessagingTemplate simpMessagingTemplate;
	
	@MessageMapping("getMessageFromClient")
	public void name(@Payload String message) {
		simpMessagingTemplate.convertAndSend("/topic/getMessageFromServer","Modiefied:"+message);
	}
}
