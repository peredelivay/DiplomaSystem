package com.mirea.diploma.chat.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageDto {
    private Long id;
    private Long chatId;
    private Long senderId;
    private String messageText;
    private LocalDateTime sentTime;
}
