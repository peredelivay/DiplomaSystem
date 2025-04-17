package com.mirea.diploma.chat.dto;

public class MessageDto {
    private Long senderId;
    private String messageText;
    public Long getSenderId() { return senderId; }
    public void setSenderId(Long senderId) { this.senderId = senderId; }
    public String getMessageText() { return messageText; }
    public void setMessageText(String messageText) { this.messageText = messageText; }
}
