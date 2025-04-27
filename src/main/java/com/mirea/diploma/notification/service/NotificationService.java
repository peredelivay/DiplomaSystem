package com.mirea.diploma.notification.service;

import com.mirea.diploma.notification.dto.*;
import java.util.List;

public interface NotificationService {
    List<NotificationDto> getForUser(Long userId);
    NotificationDto markRead(Long id);
}