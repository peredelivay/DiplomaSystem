package com.mirea.diploma.practice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder (toBuilder = true)
public class CommentDto {
    private String comment;
}
