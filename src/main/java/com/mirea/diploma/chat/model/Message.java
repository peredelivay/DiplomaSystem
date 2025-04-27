package com.mirea.diploma.chat.model;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "messages")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "chat_id", nullable = false)
    private Chat chat;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private com.mirea.diploma.auth.model.User sender;

    @Column(name = "message_text", nullable = false)
    private String messageText;

    @Column(name = "sent_time", nullable = false)
    private LocalDateTime sentTime;
}
