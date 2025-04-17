package com.mirea.diploma.notification.service;

import com.mirea.diploma.notification.model.Notification;
import java.util.List;

public interface NotificationService {
    List<Notification> getNotifications(Long userId);
    Notification markAsRead(Long notificationId);
}
