package com.mirea.diploma.practice.model;

import lombok.*;

import jakarta.persistence.*;

@Entity
@Table(name = "blocks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "version_id", nullable = false)
    private Version version;

    @Column(name = "order_number", nullable = false)
    private Integer orderNumber;

    @Column(name = "content_type", nullable = false)
    private String contentType; // e.g. TITLE, TEXT, IMAGE, LIST, TABLE

    @Lob
    @Column(nullable = false)
    private String content;
}
