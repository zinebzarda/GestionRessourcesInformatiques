package com.example.GestionRessourcesInfo.controller;

import com.example.GestionRessourcesInfo.model.Notification;
import com.example.GestionRessourcesInfo.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping
    public ResponseEntity<Notification> creerNotification(@RequestBody Notification notification) {
        return ResponseEntity.ok(notificationService.creerNotification(notification));
    }

    @GetMapping
    public ResponseEntity<List<Notification>> getAllNotifications() {
        return ResponseEntity.ok(notificationService.getAllNotifications());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notification> getNotificationById(@PathVariable Long id) {
        Notification notification = notificationService.getNotificationById(id);
        if (notification != null) {
            return ResponseEntity.ok(notification);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/unread/{adminId}")
    public ResponseEntity<List<Notification>> getUnreadNotificationsForAdmin(@PathVariable Long adminId) {
        return ResponseEntity.ok(notificationService.getUnreadNotificationsForAdmin(adminId));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Notification> updateNotification(@PathVariable Long id, @RequestBody Notification notification) {
        notification.setId(id);
        return ResponseEntity.ok(notificationService.updateNotification(notification));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotification(@PathVariable Long id) {
        notificationService.deleteNotification(id);
        return ResponseEntity.noContent().build();
    }
}