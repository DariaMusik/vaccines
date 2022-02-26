package com.thesis.vaccines.repository;

import com.thesis.vaccines.model.Notification;
import org.springframework.data.repository.CrudRepository;

public interface NotificationRepository extends CrudRepository <Notification,Integer> {
}
