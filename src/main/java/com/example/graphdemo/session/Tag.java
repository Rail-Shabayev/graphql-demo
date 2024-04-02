package com.example.graphdemo.session;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tag {
    @Id
    private Integer id;
    private String name;

    public Tag() {

    }

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tag(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
