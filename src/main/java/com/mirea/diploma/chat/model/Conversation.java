package com.mirea.diploma.chat.model;

import jakarta.persistence.*;

@Entity
@Table(name = "conversations", uniqueConstraints = {@UniqueConstraint(columnNames = {"student_id"})})
public class Conversation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long convId;
    @Column(name = "student_id", nullable = false)
    private Long studentId;
    @Column(name = "supervisor_id", nullable = false)
    private Long supervisorId;

    public Long getConvId() { return convId; }
    public void setConvId(Long convId) { this.convId = convId; }
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }
    public Long getSupervisorId() { return supervisorId; }
    public void setSupervisorId(Long supervisorId) { this.supervisorId = supervisorId; }
}
