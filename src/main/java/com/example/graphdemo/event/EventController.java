package com.example.graphdemo.event;

import com.example.graphdemo.session.Session;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class EventController {
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
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
    public List<Session> sessions(Event event) {
        System.out.println("Fetching sessions for Event: " + events.toString());
        var session = new Session(1, "session1", "hyper session");
        return List.of(session);
    }
}
