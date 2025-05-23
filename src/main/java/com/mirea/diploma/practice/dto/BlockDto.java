package com.mirea.diploma.practice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder (toBuilder = true)
public class BlockDto {
    private Long id;
    private Integer orderNumber;
    private String contentType;
    private String content;
}
