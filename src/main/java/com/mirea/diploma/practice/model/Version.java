package com.mirea.diploma.practice.model;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "versions")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Version {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "practice_id", nullable = false)
    private Practice practice;

    @Column(name = "version_number", nullable = false)
    private Integer versionNumber;

    @Column(name = "upload_time", nullable = false)
    private LocalDateTime uploadTime;

    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "version", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Block> blocks;
}
