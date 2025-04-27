package com.mirea.diploma.chat.dto;

import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class ChatDto {
    private Long id;
    private Long studentId;
    private Long supervisorId;
}