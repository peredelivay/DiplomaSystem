package com.mirea.diploma.practice.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder (toBuilder = true)
public class ChangeStatusDto {
    private String status;
}
