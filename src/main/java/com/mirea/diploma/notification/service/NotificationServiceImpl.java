package com.mirea.diploma.notification.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mirea.diploma.notification.repository.NotificationRepository;
import com.mirea.diploma.notification.dto.*;
import com.mirea.diploma.notification.model.Notification;
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
                        .userId(n.getUser().getId())
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
                .userId(upd.getUser().getId())
                .type(upd.getType())
                .message(upd.getMessage())
                .status(upd.getStatus())
                .createdAt(upd.getCreatedAt())
                .build();
    }
}