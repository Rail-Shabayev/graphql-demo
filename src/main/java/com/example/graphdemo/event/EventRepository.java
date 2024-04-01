package com.example.graphdemo.event;

import com.example.graphdemo.event.Event;
import org.springframework.data.repository.ListCrudRepository;

public interface EventRepository extends ListCrudRepository<Event, Integer> {
}
