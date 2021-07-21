package com.example.a16;

import java.io.Serializable;

public class Task implements Serializable {
    String name;
    String surname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Task(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
