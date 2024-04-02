package com.example.graphdemo.speaker;

import jakarta.persistence.*;

@Entity
public class Speaker {

    @Id
    private Integer id;
    private String name;
    private String title;
    private String company;
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String country;
    private String email;
    private String phoneNumber;
    private String twitter;

    public Speaker() {
    }

    public Gender getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "Speaker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", title='" + title + '\'' +
                ", company='" + company + '\'' +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", twitter='" + twitter + '\'' +
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTwitter() {
        return twitter;
    }

    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

    public Speaker(Integer id, String name, String title, String company, Gender gender, String country, String email, String phoneNumber, String twitter) {
        this.id = id;
        this.name = name;
        this.title = title;
        this.company = company;
        this.gender = gender;
        this.country = country;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.twitter = twitter;
    }
}
