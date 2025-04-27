package com.mirea.diploma.chat.service;

import com.mirea.diploma.chat.dto.*;
import com.mirea.diploma.chat.model.Message;
import java.util.List;

public interface ChatService {
    ChatDto findOrCreateChat(Long studentId, Long supervisorId);
    List<MessageDto> getMessages(Long chatId);
    MessageDto sendMessage(Long chatId, MessageDto dto);
}