package com.mirea.diploma.practice.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "practice_versions", uniqueConstraints = @UniqueConstraint(columnNames = {"practiceReport_id", "versionNumber"}))
public class PracticeVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long versionId;
    @ManyToOne
    @JoinColumn(name = "practiceReport_id", nullable = false)
    private PracticeReport practiceReport;
    private Integer versionNumber;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    private String status;
    @OneToMany(mappedBy = "practiceVersion", cascade = CascadeType.ALL)
    @OrderBy("position ASC")
    private List<Block> blocks;

    public Long getVersionId() { return versionId; }
    public void setVersionId(Long versionId) { this.versionId = versionId; }
    public PracticeReport getPracticeReport() { return practiceReport; }
    public void setPracticeReport(PracticeReport practiceReport) { this.practiceReport = practiceReport; }
    public Integer getVersionNumber() { return versionNumber; }
    public void setVersionNumber(Integer versionNumber) { this.versionNumber = versionNumber; }
    public Date getCreatedAt() { return createdAt; }
    public void setCreatedAt(Date createdAt) { this.createdAt = createdAt; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public List<Block> getBlocks() { return blocks; }
    public void setBlocks(List<Block> blocks) { this.blocks = blocks; }
}
