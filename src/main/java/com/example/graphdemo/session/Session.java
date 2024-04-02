package com.example.graphdemo.session;

import com.example.graphdemo.event.Event;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Session {

    @Id
    private Integer id;
    private String title;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Enumerated(EnumType.STRING)
    private Level level;
    @OneToMany
    private Set<Tag> tags;
    @ManyToMany
    private Event event;
    public Session() {
    }
    public Session(Integer id, String title, String description, Level level) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", level=" + level +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
