package com.cityscape.egovernace.controller;

import com.cityscape.egovernace.model.Message;
import com.cityscape.egovernace.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
@CrossOrigin(origins = "\"https://cityscape-ui.vercel.app")
public class ChatController {

    @Autowired
    private MessageRepository messageRepository;

    
    @PostMapping("/send")
    public Message sendMessage(@RequestBody Message message) {
        return messageRepository.save(message);
    }

    
    @GetMapping("/history")
    public List<Message> getChatHistory(@RequestParam String user1, @RequestParam String user2) {
        return messageRepository.findBySenderAndReceiverOrSenderAndReceiverOrderByTimestampAsc(
            user1, user2, user2, user1
        );
    }
}