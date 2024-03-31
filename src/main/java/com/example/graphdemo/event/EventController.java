package com.example.graphdemo.event;

import com.example.graphdemo.session.Session;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.*;

@Controller
public class EventController {
    private final List<Event> events = new ArrayList<>();

    public EventController() {
        var event = new Event(1,
                "some event name",
                "description",
                now(),
                now(),
                now(),
                now(),
                "location",
                "http://localhost:8080/graphiql?path=/graphql");
        events.add(event);
    }

    @QueryMapping
    public List<Event> events() {
        return events;
    }

    @SchemaMapping
    public List<Session> sessions(Event event) {
        System.out.println("Fetching sessions for Event: " + events.toString());
        var session = new Session(1, "session1", "hyper session");
        return List.of(session);
    }
}
