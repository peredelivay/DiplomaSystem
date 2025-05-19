package com.mirea.diploma.notification.service;

import com.mirea.diploma.auth.model.User;
import com.mirea.diploma.auth.repository.UserRepository;
import com.mirea.diploma.chat.dto.MessageDto;
import com.mirea.diploma.chat.model.Chat;
import com.mirea.diploma.chat.model.Message;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;
import com.mirea.diploma.notification.repository.NotificationRepository;
import com.mirea.diploma.notification.dto.*;
import com.mirea.diploma.notification.model.Notification;

import javax.management.NotificationFilter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository repo;

    @Override
    public List<NotificationDto> getForUser(Long userId) {
        return repo.findByUserIdOrderByCreatedAtDesc(userId).stream().map(n ->
                NotificationDto.builder()
                        .id(n.getId())
                        .userId(n.getUserId())
                        .type(n.getType())
                        .message(n.getMessage())
                        .status(n.getStatus())
                        .createdAt(n.getCreatedAt())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public NotificationDto markRead(Long id) {
        Notification n = repo.findById(id).orElseThrow();
        n.setStatus(true);
        Notification upd = repo.save(n);
        return NotificationDto.builder()
                .id(upd.getId())
                .userId(upd.getUserId())
                .type(upd.getType())
                .message(upd.getMessage())
                .status(upd.getStatus())
                .createdAt(upd.getCreatedAt())
                .build();
    }

    @Override
    public NotificationDto sendNotification(Long userId, NotificationDto dto) {
        Notification n = Notification.builder()
                .userId(userId)
                .type(dto.getType())
                .message(dto.getMessage())
                .status(false)              // по умолчанию — не прочитано
                .createdAt(LocalDateTime.now())
                .build();

        n = repo.save(n);
        return NotificationDto.builder()
                .id(n.getId())
                .userId(n.getUserId())
                .type(n.getType())
                .message(n.getMessage())
                .status(n.getStatus())
                .createdAt(n.getCreatedAt())
                .build();
    }
}