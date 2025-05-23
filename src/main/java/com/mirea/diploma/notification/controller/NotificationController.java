package com.mirea.diploma.notification.controller;

import com.mirea.diploma.chat.dto.MessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.mirea.diploma.notification.dto.NotificationDto;
import com.mirea.diploma.notification.service.NotificationService;
import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {
    private final NotificationService svc;

    @GetMapping("/{userId}")
    public ResponseEntity<List<NotificationDto>> list(@PathVariable Long userId) {
        return ResponseEntity.ok(svc.getForUser(userId));
    }

    @PutMapping("/{id}/read")
    public ResponseEntity<NotificationDto> read(@PathVariable Long id) {
        return ResponseEntity.ok(svc.markRead(id));
    }

    @PostMapping("/{userId}/send")
    public ResponseEntity<NotificationDto> send(@PathVariable Long userId,
                                           @RequestBody NotificationDto dto) {
        return ResponseEntity.ok(svc.sendNotification(userId, dto));
    }
}