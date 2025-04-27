package com.mirea.diploma.auth.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
    private String groupName;
    private String role;         // "STUDENT"
    private Long supervisorId;   // nullable для руководителя/админа
}