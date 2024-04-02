package com.example.graphdemo.event;

import org.springframework.data.repository.ListCrudRepository;

public interface EventRepository extends ListCrudRepository<Event, Integer> {
}
