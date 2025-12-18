package com.example.Barter.model;
@Entity
public class Skill {
    private long id;
    private String name;
    private String category;
    private String description;
    private boolean active;

    public Skill(){

    }

    public Skill(long id, String name, String category, String description, boolean active) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.active = active;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public boolean isActive() {
        return active;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    




}

