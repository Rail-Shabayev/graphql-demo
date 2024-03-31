package com.example.graphdemo.event;

import org.springframework.graphql.data.method.annotation.QueryMapping;
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
}
