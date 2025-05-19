package com.mirea.diploma.notification.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mirea.diploma.notification.model.Notification;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByUserIdOrderByCreatedAtDesc(Long user_id);
}