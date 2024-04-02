package com.example.graphdemo.event;

import com.example.graphdemo.session.Session;
import com.example.graphdemo.session.SessionRepository;
import org.springframework.data.domain.Limit;
import org.springframework.data.domain.ScrollPosition;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Window;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.graphql.data.query.ScrollSubrange;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class EventController {
    private final EventRepository eventRepository;
    private final SessionRepository sessionRepository;

    public EventController(EventRepository eventRepository,
                           SessionRepository sessionRepository) {
        this.eventRepository = eventRepository;
        this.sessionRepository = sessionRepository;
    }


    @QueryMapping
    public List<Event> events() {
        return eventRepository.findAll();
    }

    @QueryMapping
    Optional<Event> event(@Argument Integer id) {
        return eventRepository.findById(id);
    }

    @SchemaMapping
    Window<Session> sessions(Event event, ScrollSubrange scrollSubrange) {
        ScrollPosition scrollPosition = scrollSubrange.position().orElse(ScrollPosition.offset());
        Limit limit = Limit.of(scrollSubrange.count().orElse(10));
        Sort sort = Sort.by("title").ascending();
        return sessionRepository.findByEventId(event.getId(), scrollPosition, limit, sort);
    }
}
