package com.example.graphdemo.data;

import com.example.graphdemo.event.Event;
import com.example.graphdemo.event.EventRepository;
import com.example.graphdemo.session.Level;
import com.example.graphdemo.session.Session;
import com.example.graphdemo.session.SessionRepository;
import com.example.graphdemo.speaker.Gender;
import com.example.graphdemo.speaker.Speaker;
import com.example.graphdemo.speaker.SpeakerRepository;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final EventRepository eventRepository;
    private final SpeakerRepository speakerRepository;
    private final SessionRepository sessionRepository;
    private final Faker faker;

    public DataLoader(EventRepository eventRepository, SpeakerRepository speakerRepository, SessionRepository sessionRepository) {
        this.eventRepository = eventRepository;
        this.speakerRepository = speakerRepository;
        this.sessionRepository = sessionRepository;
        this.faker = new Faker();
    }

    @Override
    public void run(String... args) throws Exception {

        if (eventRepository.count() == 0) {

            var event = new Event(1,
                    "SpringOne at VMware Explore",
                    "Join us at the biggest gathering of Spring enthusiasts, beginners and practitioners who build the apps that make the world run. ",
                    LocalDate.of(2023, 8, 21),
                    LocalDate.of(2023, 8, 24),
                    LocalDate.now().minusDays(180),
                    LocalDate.now().minusDays(90),
                    "Las Vegas, NV",
                    "https://springone.io/");

            eventRepository.save(event);

            List<Speaker> speakers = new ArrayList<>();
            for (int i = 1; i <= 20; i++) {
                speakers.add(new Speaker(i,
                        faker.name().fullName(),
                        faker.name().title(),
                        faker.company().name(),
                        Gender.values()[faker.number().numberBetween(0, Gender.values().length)],
                        faker.address().country(),
                        faker.internet().emailAddress(),
                        faker.phoneNumber().phoneNumber(),
                        faker.twitter().userName()));

            }
            speakerRepository.saveAll(speakers);
            List<Session> sessions = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                sessions.add(new Session(i,
                        faker.book().title(),
                        faker.lorem().paragraph(),
                        Level.values()[faker.number().numberBetween(0, Level.values().length)],
                        null,
                        event));
            }
            sessionRepository.saveAll(sessions);

        }

    }

    private Speaker randomSpeaker(List<Speaker> speakers) {
        return speakers.get(faker.number().numberBetween(0, speakers.size() - 1));
    }

}