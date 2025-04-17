package com.mirea.diploma.chat.service;

import com.mirea.diploma.chat.dto.MessageDto;
import com.mirea.diploma.chat.model.Message;
import java.util.List;

public interface ChatService {
    List<Message> getMessages(Long convId);
    Message sendMessage(Long convId, MessageDto dto);
}
