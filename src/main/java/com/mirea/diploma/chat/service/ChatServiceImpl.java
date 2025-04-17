package com.mirea.diploma.chat.service;

import com.mirea.diploma.chat.dto.MessageDto;
import com.mirea.diploma.chat.model.Conversation;
import com.mirea.diploma.chat.model.Message;
import com.mirea.diploma.chat.repository.ConversationRepository;
import com.mirea.diploma.chat.repository.MessageRepository;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    private final ConversationRepository conversationRepository;
    private final MessageRepository messageRepository;
    public ChatServiceImpl(ConversationRepository conversationRepository, MessageRepository messageRepository) {
        this.conversationRepository = conversationRepository;
        this.messageRepository = messageRepository;
    }
    @Override
    public List<Message> getMessages(Long convId) {
        return messageRepository.findByConversationConvIdOrderBySentAtAsc(convId);
    }
    @Override
    public Message sendMessage(Long convId, MessageDto dto) {
        Conversation conv = conversationRepository.findById(convId).orElseThrow();
        Message msg = new Message();
        msg.setConversation(conv);
        msg.setSenderId(dto.getSenderId());
        msg.setMessageText(dto.getMessageText());
        msg.setSentAt(new Date());
        return messageRepository.save(msg);
    }
}
