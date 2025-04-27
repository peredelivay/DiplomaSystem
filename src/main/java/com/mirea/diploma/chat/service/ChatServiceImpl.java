package com.mirea.diploma.chat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.mirea.diploma.chat.dto.*;
import com.mirea.diploma.chat.model.*;
import com.mirea.diploma.chat.repository.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    private final ChatRepository chatRepo;
    private final MessageRepository msgRepo;

    @Override
    public ChatDto findOrCreateChat(Long studentId, Long supervisorId) {
        Chat chat = chatRepo.findByStudentId(studentId)
                .orElseGet(() -> {
                    Chat c = Chat.builder()
                            .student(new com.mirea.diploma.auth.model.User() {{ setId(studentId); }})
                            .supervisor(new com.mirea.diploma.auth.model.User() {{ setId(supervisorId); }})
                            .build();
                    return chatRepo.save(c);
                });
        return ChatDto.builder()
                .id(chat.getId())
                .studentId(chat.getStudent().getId())
                .supervisorId(chat.getSupervisor().getId())
                .build();
    }

    @Override
    public List<MessageDto> getMessages(Long chatId) {
        return msgRepo.findByChatIdOrderBySentTimeAsc(chatId).stream().map(m ->
                MessageDto.builder()
                        .id(m.getId())
                        .chatId(m.getChat().getId())
                        .senderId(m.getSender().getId())
                        .messageText(m.getMessageText())
                        .sentTime(m.getSentTime())
                        .build()
        ).collect(Collectors.toList());
    }

    @Override
    public MessageDto sendMessage(Long chatId, MessageDto dto) {
        Chat chat = chatRepo.findById(chatId).orElseThrow();
        Message m = Message.builder()
                .chat(chat)
                .sender(new com.mirea.diploma.auth.model.User() {{ setId(dto.getSenderId()); }})
                .messageText(dto.getMessageText())
                .sentTime(LocalDateTime.now())
                .build();
        Message saved = msgRepo.save(m);
        return MessageDto.builder()
                .id(saved.getId())
                .chatId(chatId)
                .senderId(saved.getSender().getId())
                .messageText(saved.getMessageText())
                .sentTime(saved.getSentTime())
                .build();
    }
}