package com.mirea.diploma.auth.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String email;
    private String groupName;
    private String role;
    private Long supervisorId;
}
