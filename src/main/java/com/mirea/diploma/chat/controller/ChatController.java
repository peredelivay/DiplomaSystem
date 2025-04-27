package com.mirea.diploma.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mirea.diploma.chat.dto.*;
import com.mirea.diploma.chat.service.ChatService;
import java.util.List;

@RestController
@RequestMapping("/api/chats")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<ChatDto> createOrGet(@RequestParam Long studentId,
                                               @RequestParam Long supervisorId) {
        return ResponseEntity.ok(chatService.findOrCreateChat(studentId, supervisorId));
    }

    @GetMapping("/{chatId}/messages")
    public ResponseEntity<List<MessageDto>> getMessages(@PathVariable Long chatId) {
        return ResponseEntity.ok(chatService.getMessages(chatId));
    }

    @PostMapping("/{chatId}/messages")
    public ResponseEntity<MessageDto> send(@PathVariable Long chatId,
                                           @RequestBody MessageDto dto) {
        return ResponseEntity.ok(chatService.sendMessage(chatId, dto));
    }
}