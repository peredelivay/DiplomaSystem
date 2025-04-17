package com.mirea.diploma.practice.model;

import jakarta.persistence.*;

@Entity
@Table(name = "blocks")
public class Block {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long blockId;
    @ManyToOne
    @JoinColumn(name = "version_id", nullable = false)
    private PracticeVersion practiceVersion;
    private String type;
    @Column(columnDefinition = "TEXT")
    private String content;
    private Integer position;

    public Long getBlockId() { return blockId; }
    public void setBlockId(Long blockId) { this.blockId = blockId; }
    public PracticeVersion getPracticeVersion() { return practiceVersion; }
    public void setPracticeVersion(PracticeVersion practiceVersion) { this.practiceVersion = practiceVersion; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public Integer getPosition() { return position; }
    public void setPosition(Integer position) { this.position = position; }
}
