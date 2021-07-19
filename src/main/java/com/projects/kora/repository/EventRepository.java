package com.projects.kora.repository;

import com.projects.kora.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository <Event,Integer> {
    Event findByEventType(String answer_posted);
}
