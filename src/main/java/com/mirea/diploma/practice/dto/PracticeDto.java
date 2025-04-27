package com.mirea.diploma.practice.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder (toBuilder = true)
public class PracticeDto {
    private Long id;
    private Long studentId;
    private String practiceName;
    private Integer versionsAmount;
    private LocalDateTime lastModified;
}
