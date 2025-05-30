package com.mirea.diploma.notification.model;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id", nullable = false)
    private Long userId;

    private String type;    // INFO, WARNING, ERROR

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private Boolean status; // false = unread, true = read

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
