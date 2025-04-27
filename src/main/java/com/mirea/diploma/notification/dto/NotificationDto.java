package com.mirea.diploma.notification.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NotificationDto {
    private Long id;
    private Long userId;
    private String type;
    private String message;
    private Boolean status;
    private LocalDateTime createdAt;
}
