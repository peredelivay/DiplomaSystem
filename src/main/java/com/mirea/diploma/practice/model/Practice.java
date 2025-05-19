package com.mirea.diploma.practice.model;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "practices")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Practice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private com.mirea.diploma.auth.model.User student;

    @Column(name = "practice_name", nullable = false)
    private String practiceName;

    @Column(name = "versions_amount")
    private Integer versionsAmount;

    @Column(name = "last_modified")
    private LocalDateTime lastModified;

    @Column(name = "status", nullable = false)
    private String status;

    @OneToMany(mappedBy = "practice", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Version> versions;
}
