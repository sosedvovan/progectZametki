package com.github.sosedvovan.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class Zapis {

    public static final Zapis EMPTY = new Zapis(1,"дата", "заметка 1", "заметка 2");

    private Integer id;

    private final String dateTime;

    private final String description1;

    private final String description2;

    public Zapis(Integer id, String dateTime, String description1, String description2) {
        this.id = id;
        this.dateTime = dateTime;
        this.description1 = description1;
        this.description2 = description2;
    }

//    public Zapis( String dateTime, String description1, String description2) {
//        this.dateTime = dateTime;
//        this.description1 = description1;
//        this.description2 = description2;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public String getDescription1() {
        return description1;
    }

    public String getDescription2() {
        return description2;
    }

    @Override
    public String toString() {
        return "Zapis{" +
                "id=" + id +
                ", dateTime=" + dateTime +
                ", description1='" + description1 + '\'' +
                ", description2='" + description2 + '\'' +
                '}';
    }
}
