package com.mirea.diploma.practice.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder (toBuilder = true)
public class VersionDto {
    private Long id;
    private Integer versionNumber;
    private LocalDateTime uploadTime;
}
