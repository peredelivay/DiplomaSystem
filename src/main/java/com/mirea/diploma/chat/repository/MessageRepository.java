package com.mirea.diploma.chat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mirea.diploma.chat.model.Message;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByChatIdOrderBySentTimeAsc(Long chatId);
}