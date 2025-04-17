package com.mirea.diploma.chat.controller;

import com.mirea.diploma.chat.dto.MessageDto;
import com.mirea.diploma.chat.model.Message;
import com.mirea.diploma.chat.service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/chats")
public class ChatController {
    private final ChatService chatService;
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }
    @GetMapping("/{convId}/messages")
    public ResponseEntity<List<Message>> getMessages(@PathVariable Long convId) {
        return ResponseEntity.ok(chatService.getMessages(convId));
    }
    @PostMapping("/{convId}/messages")
    public ResponseEntity<Message> sendMessage(@PathVariable Long convId, @RequestBody MessageDto dto) {
        return ResponseEntity.ok(chatService.sendMessage(convId, dto));
    }
}
